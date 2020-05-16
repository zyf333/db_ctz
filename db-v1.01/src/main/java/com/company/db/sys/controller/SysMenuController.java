package com.company.db.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.db.common.pojo.JsonResult;
import com.company.db.sys.pojo.MenuNodeVO;
import com.company.db.sys.pojo.SysMenuDO;
import com.company.db.sys.service.ISysMenuService;

@RestController
@RequestMapping("/menu")
public class SysMenuController {

	@Autowired
	ISysMenuService service;

	// localhost:8080/menu/saveSysMenu?name=测试菜单4&permission=test:menu&parentId=8
	// localhost:8080/menu/saveSysMenu
	@RequestMapping("/saveSysMenu")
	public JsonResult<Void> saveSysMenu(SysMenuDO sysMenuDO) {
		service.saveSysMenu(sysMenuDO);
		return JsonResult.getSuccessJR();
	}

	// localhost:8080/menu/removeById?id=128
	@RequestMapping("/removeById")
	public JsonResult<Void> removeById(Integer id) {
		service.removeById(id);
		return JsonResult.getSuccessJR();
	}

	// localhost:8080/menu/findAll
	@RequestMapping("/findAll")
	public JsonResult<List<SysMenuDO>> findAll() {
		List<SysMenuDO> list = service.findAll();
		return JsonResult.getSuccessJR(list);
	}

	// localhost:8080/menu/findMenuNode
	@RequestMapping("/findMenuNode")
	public JsonResult<List<MenuNodeVO>> findMenuNode() {
		List<MenuNodeVO> data = service.findMenuNode();
		return JsonResult.getSuccessJR(data);
	}

	@RequestMapping("/findSysMenuById")
	public JsonResult<SysMenuDO> findSysMenuById(Integer menuId) {
		SysMenuDO data = service.findSysMenuById(menuId);
		return JsonResult.getSuccessJR(data);
	}

	@RequestMapping("/modifySysMenu")
	public JsonResult<Void> modifySysMenu(SysMenuDO sysMenuDO) {
		service.modifySysMenu(sysMenuDO);
		return JsonResult.getSuccessJR();
	}
}