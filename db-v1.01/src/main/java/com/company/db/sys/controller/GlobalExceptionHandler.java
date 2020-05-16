package com.company.db.sys.controller;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.db.common.pojo.JsonResult;
import com.company.db.sys.service.ex.DeleteException;
import com.company.db.sys.service.ex.EmptyArgumentException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.HasSubMenuException;
import com.company.db.sys.service.ex.IllegalPageCurrentNumberException;
import com.company.db.sys.service.ex.InsertException;
import com.company.db.sys.service.ex.ParentNodeNotFoundException;
import com.company.db.sys.service.ex.RecordNotFoundException;
import com.company.db.sys.service.ex.ServiceException;
import com.company.db.sys.service.ex.UsernameExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult<Void> doHandleShiroException(ShiroException e) {
		JsonResult<Void> r = new JsonResult<Void>();
		r.setState(0);
		// 注意：现实开发中，这里的错误提示信息要尽量模糊
		// 不要给攻击者任何可以判断账户状态的信息
		if (e instanceof UnknownAccountException) {
			r.setMessage("账户不存在");
		} else if (e instanceof LockedAccountException) {
			r.setMessage("账户已被禁用");
		} else if (e instanceof IncorrectCredentialsException) {
			r.setMessage("密码不正确");
		} else if (e instanceof AuthorizationException) {
			r.setMessage("没有此操作权限");
		} else {
			r.setMessage("系统维护中");
		}
		e.printStackTrace();
		return r;
	}

	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handleCustomException(Throwable e) {
		e.printStackTrace();
		JsonResult<Void> jr = new JsonResult<Void>();
		jr.setMessage(e.getMessage());

		if (e instanceof IllegalPageCurrentNumberException) {
			jr.setState(4001);
		} else if (e instanceof RecordNotFoundException) {
			jr.setState(4002);
		} else if (e instanceof EmptyIdException) {
			jr.setState(4003);
		} else if (e instanceof DeleteException) {
			jr.setState(4004);
		} else if (e instanceof HasSubMenuException) {
			jr.setState(4005);
		} else if (e instanceof EmptyArgumentException) {
			jr.setState(4006);
		} else if (e instanceof ParentNodeNotFoundException) {
			jr.setState(4007);
		} else if (e instanceof InsertException) {
			jr.setState(4008);
		} else if (e instanceof UsernameExistsException) {
			jr.setState(4009);

		} else {
			jr.setState(0);
		}
		return jr;
	}

	@ExceptionHandler(Exception.class)
	public JsonResult<Void> handleException(Throwable e) {
		e.printStackTrace();
		JsonResult<Void> jr = new JsonResult<Void>();
		jr.setState(1);
		jr.setMessage("很抱歉！系统运行异常！请稍后重试");
		return jr;
	}
}
