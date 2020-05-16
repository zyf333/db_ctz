package com.company.db.sys.dao;

import java.util.List;
import org.junit.Test;
import com.company.db.sys.pojo.SysRoleDO;
import com.company.test.BaseTest;

public class SysRoleDaoTests extends BaseTest {

	private SysRoleDao dao;

	@Override
	public void doBefore() {
		super.doBefore();
		dao = context.getBean("sysRoleDao", SysRoleDao.class);
	}

	@Test
	public void getRowCount() {
		Integer rowCount = dao.getRowCount("");
		System.err.println("row=" + rowCount);
	}

	@Test
	public void getPageRecord() {
		List<SysRoleDO> list = dao.getPageRecord(1, 2, "");
		System.out.println(list.size());
		for (SysRoleDO item : list) {
			System.err.println(item);
		}
	}

	@Test
	public void insertSysRole() {
		SysRoleDO sysRoleDO = new SysRoleDO(null, null, "admin", "admin", null, "测试角色", "测试note");
		Integer row = dao.insertSysRole(sysRoleDO);
		System.err.println("row=" + row);
		System.err.println("id=" + sysRoleDO.getId());
	}

	@Test
	public void insertRoleMenu() {
		Integer roleId = 48;
		Integer[] menuIds = { 8, 24, 25 };
		Integer count = dao.insertRoleMenus(roleId, menuIds);
		System.err.println("count=" + count);
	}

	@Test
	public void getMenuByRoleId() {
		List<Integer> menuIds = dao.getMenuByRoleId(1);
		System.out.println("size:" + menuIds.size());
		for (Integer menuId : menuIds) {
			System.out.println("menuId=" + menuId);
		}
	}

	@Test
	public void updateSysRole() {
		SysRoleDO sysRoleDO = new SysRoleDO(null, null, "admin", "tester", 45, "updateRole", "updateNote");
		Integer row = dao.updateSysRole(sysRoleDO);
		System.out.println("row=" + row);
	}

	@Test
	public void deleteSysRole() {
		Integer row = dao.deleteSysRole(47);
		System.err.println("row=" + row);
	}

	@Test
	public void deleteRoleMenu() {
		Integer row = dao.deleteRoleMenu(49);
		System.err.println("row=" + row);
	}

	@Test
	public void deleteUserRole() {
		Integer row = dao.deleteUserRole(45);
		System.err.println("row=" + row);
	}

	@Test
	public void getRoleMenuCount() {
		Integer count = dao.getRoleMenuCount(1);
		System.err.println("count=" + count);
	}

	@Test
	public void getUserRoleCount() {
		Integer count = dao.getUserRoleCount(1);
		System.err.println("count=" + count);
	}

	@Test
	public void listAllSysRole() {
		List<SysRoleDO> list = dao.listAllSysRole();
		for (SysRoleDO sysRoleDO : list) {
			System.err.println(sysRoleDO);
		}
	}

	@Test
	public void getRoleCount() {
		Integer[] roleIds = { 45, 46 };
		Integer count = dao.getRoleCount(roleIds);
		System.err.println("count=" + count);
	}

	@Test
	public void listMenuIdByRoleId() {
		Integer[] roleIds = { 48, 49 };
		List<Integer> list = dao.listMenuIdByRoleId(roleIds);
		for (Integer menuId : list) {
			System.err.println("menuId=" + menuId);
		}
	}
}