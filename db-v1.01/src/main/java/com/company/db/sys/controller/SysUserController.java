package com.company.db.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.db.common.pojo.JsonResult;
import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.pojo.SysUserDO;
import com.company.db.sys.service.ISysUserService;

@RestController
@RequestMapping("/user")
public class SysUserController {

	@Autowired
	ISysUserService service;

	// localhost:8080/user/findSysUser?pageCurrent=2&username=user
	@RequestMapping("/findSysUser")
	public JsonResult<PageObjectVO<SysUserDO>> findSysUser(String username, Integer pageCurrent) {
		PageObjectVO<SysUserDO> vo = service.findSysUser(username, pageCurrent);
		return JsonResult.getSuccessJR(vo);
	}

//	localhost:8080/user/saveSysUser?username=aaa&password=123&roleIds=45,47,48
	@RequestMapping("/saveSysUser")
	public JsonResult<Void> saveSysUser(SysUserDO sysUserDO, Integer[] roleIds) {
		service.saveSysUser(sysUserDO, roleIds);
		return JsonResult.getSuccessJR();
	}

	@PostMapping("/login")
	public JsonResult<Void> login(String username, String password) {
		// 1. 获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		// 2. 通过Subject提交用户信息，交给Shiro框架进行认证操作
		// 2.1 对用户信息进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 2.2 对用户信息进行身份认证
		subject.login(token);
		// 3 返回登录结果
		return JsonResult.getSuccessJR();
	}
}