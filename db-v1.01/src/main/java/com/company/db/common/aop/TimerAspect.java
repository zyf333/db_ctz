package com.company.db.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

	@Around("execution(* com.company.db.**.controller.*.*(..))")
	public Object jjj(ProceedingJoinPoint pjp) throws Throwable {
		long st = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long et = System.currentTimeMillis();
		System.out.println("消耗时间：" + (et - st));
		return obj;
	}
}
