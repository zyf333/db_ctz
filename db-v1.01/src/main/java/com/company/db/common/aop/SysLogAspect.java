package com.company.db.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.db.common.util.IPUtils;
import com.company.db.common.util.UserUtils;
import com.company.db.sys.dao.SysLogDao;
import com.company.db.sys.pojo.SysLogDO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class SysLogAspect {

	@Autowired
	SysLogDao dao;

	/**
	 * 记录日志的切面方法
	 * 
	 * @param pjp     目标方法的句柄
	 * @param logAnno 目标方法上的SysLogAnnotation注解对象
	 * @return 目标方法的执行结果
	 * @throws Throwable
	 */
	@Around(value = "execution(* com.company.db.sys.service.impl.*.*(..))&&@annotation(logAnno)")
	public Object logAdvice(ProceedingJoinPoint pjp, SysLogAnnotation logAnno) throws Throwable {
		
		long st = System.currentTimeMillis();
		Object result = pjp.proceed();
		long et = System.currentTimeMillis();
		long time = et - st;
		
		String operation = logAnno.operation();
		saveSysLog(pjp, time, operation);

		return result;
	}

	/**
	 * 收集日志信息并保存
	 * 
	 * @param pjp       目标方法句柄
	 * @param time      目标方法执行耗时
	 * @param operation 目标操作中文描述
	 * @throws JsonProcessingException
	 */
	public void saveSysLog(ProceedingJoinPoint pjp, long time, String operation) throws JsonProcessingException {
		
		String username = UserUtils.getUsername();
		
		String className = pjp.getTarget().getClass().getName();
		
		String method = className + "." + pjp.getSignature().getName();
		
		Object[] paramsObj = pjp.getArgs();
		
		// 使用Jackson的一个API，将对象数组转换成对应的字符串表示
		String params = new ObjectMapper().writeValueAsString(paramsObj);
		
		String ip = IPUtils.getIpAddr();
		
		SysLogDO sysLogDO = new SysLogDO(null, username, operation, method, params, time, ip, null);
		
		dao.insert(sysLogDO);
	}
}