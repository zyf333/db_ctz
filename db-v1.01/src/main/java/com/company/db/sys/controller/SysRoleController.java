package com.company.db.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.db.common.pojo.JsonResult;
import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.pojo.SysRoleDO;
import com.company.db.sys.service.ISysRoleService;

@RestController
@RequestMapping("/role")
public class SysRoleController {

	@Autowired
	ISysRoleService service;

	// localhost:8080/role/findSysRole?pageCurrent=1&name=系统
	@RequestMapping("/findSysRole")
	public JsonResult<PageObjectVO<SysRoleDO>> findSysRole(String name, Integer pageCurrent) {
		PageObjectVO<SysRoleDO> data = service.findSysRole(name, pageCurrent);
		return JsonResult.getSuccessJR(data);
	}

	// localhost:8080/role/saveSysRole?name=Aie&menuIds=10,20
	@RequestMapping("/saveSysRole")
	public JsonResult<Void> saveSysRole(SysRoleDO sysRoleDO, Integer[] menuIds) {
		service.saveSysRole(sysRoleDO, menuIds);
		return JsonResult.getSuccessJR();
	}

	@RequestMapping("/removeSysRole")
	public JsonResult<Void> removeSysRole(Integer roleId) {
		System.out.println("roleId:" + roleId);
		service.removeSysRole(roleId);
		return JsonResult.getSuccessJR();
	}

	@RequestMapping("/findMenuByRoleId")
	public JsonResult<List<Integer>> findMenuByRoleId(Integer roleId) {
		List<Integer> data = service.findMenuByRoleId(roleId);
		return JsonResult.getSuccessJR(data);
	}

	@RequestMapping("/modifySysRole")
	public JsonResult<Void> modifySysRole(SysRoleDO sysRoleDO, Integer[] menuIds) {
		service.modifySysRole(sysRoleDO, menuIds);
		return JsonResult.getSuccessJR();
	}

//	localhost:8080/role/findAllSysRole
	@RequestMapping("/findAllSysRole")
	public JsonResult<List<SysRoleDO>> findAllSysRole() {
		List<SysRoleDO> data = service.findAllSysRole();
		return JsonResult.getSuccessJR(data);
	}
}
