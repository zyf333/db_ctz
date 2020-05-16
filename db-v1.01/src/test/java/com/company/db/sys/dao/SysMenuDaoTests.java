package com.company.db.sys.dao;

import java.util.List;

import org.junit.Test;

import com.company.db.sys.pojo.MenuNodeVO;
import com.company.db.sys.pojo.SysMenuDO;
import com.company.test.BaseTest;

public class SysMenuDaoTests extends BaseTest {

	private SysMenuDao dao;

	@Override
	public void doBefore() {
		super.doBefore();
		dao = context.getBean("sysMenuDao", SysMenuDao.class);
	}

	@Test
	public void deleteById() {
		Integer row = dao.deleteById(130);
		System.out.println("row=" + row);
	}

	@Test
	public void countByParentId() {
		Integer count = dao.countByParentId(8);
		System.out.println("count=" + count);
	}

	@Test
	public void selectAll() {
		List<SysMenuDO> list = dao.selectAll();
		for (SysMenuDO menu : list) {
			System.out.println(menu);
		}
	}

	@Test
	public void listMenuNode() {
		List<MenuNodeVO> list = dao.listMenuNode();
		for (MenuNodeVO vo : list) {
			System.out.println(vo);
		}
	}

	@Test
	public void getSysMenu() {
		SysMenuDO menu = dao.getSysMenu(8);
		System.out.println(menu);
	}

	@Test
	public void insertSysMenu() {
		SysMenuDO sysMenuDO = new SysMenuDO(null, null, "Tester", "Tester", null, "测试菜单1", "testurl", 1, 12, "testNote",
				8, "user:test");
		Integer row = dao.insertSysMenu(sysMenuDO);
		System.out.println("row=" + row);
	}

	@Test
	public void getSysMenuById() {
		SysMenuDO sysMenuDO = dao.getSysMenuById(24);
		System.out.println(sysMenuDO);
	}

	@Test
	public void updateSysMenu() {
		SysMenuDO sysMenuDO = new SysMenuDO(null, null, "Tester", "Tester", 229, "测试菜单1", "testurl2", 1, 12, "testNote",
				24, "user:test");
		Integer row = dao.updateSysMenu(sysMenuDO);
		System.out.println("row=" + row);
	}

	@Test
	public void getMenuCount() {
		Integer[] menuIds = { 8, 24, 25, 26 };
		Integer count = dao.getMenuCount(menuIds);
		System.err.println("count=" + count);
	}

	// ========================== 对RoleMenu表的操作 ============================= //
	@Test
	public void countRoleMenuByMenuId() {
		Integer count = dao.countRoleMenuByMenuId(48);
		System.out.println("count=" + count);
	}

	@Test
	public void deleteRoleMenuByMenuId() {
		Integer row = dao.deleteRoleMenuByMenuId(48);
		System.out.println("row=" + row);
	}

	@Test
	public void listPermissions() {
		Integer[] menuIds = { 8, 45, 46, 47, 48 };
		List<String> list = dao.listPermissions(menuIds);
		for (String permission : list) {
			System.err.println("permission=" + permission);
		}
	}
}
