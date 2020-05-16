package com.company.db.sys.service;

import java.util.List;

import org.junit.Test;

import com.company.db.sys.pojo.MenuNodeVO;
import com.company.db.sys.pojo.SysMenuDO;
import com.company.test.BaseTest;

public class ISysMenuServiceTests extends BaseTest {

	private ISysMenuService service;

	@Override
	public void doBefore() {
		super.doBefore();
		service = context.getBean("sysMenuServiceImpl", ISysMenuService.class);
	}

	@Test
	public void saveSysMenu() {
		SysMenuDO sysMenuDO = new SysMenuDO(null, null, "Tester", "Tester", null, "测试菜单3", "testurl", 1, 12, "testNote",
				8, "user:test");
		service.saveSysMenu(sysMenuDO);
	}

	@Test
	public void removeById() {
		Integer id = 129;
		service.removeById(id);
		System.out.println("OK.");
	}

	@Test
	public void findAll() {
		List<SysMenuDO> list = service.findAll();
		for (SysMenuDO menu : list) {
			System.out.println(menu);
		}
	}

	@Test
	public void findMenuNode() {
		List<MenuNodeVO> list = service.findMenuNode();
		for (MenuNodeVO vo : list) {
			System.err.println(vo);
		}
	}

}
