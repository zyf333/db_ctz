package com.company.db.sys.dao;

import java.util.List;

import org.junit.Test;

import com.company.db.sys.pojo.SysUserDO;
import com.company.test.BaseTest;

public class SysUserDaoTests extends BaseTest {

	private SysUserDao dao;

	@Override
	public void doBefore() {
		super.doBefore();
		dao = context.getBean("sysUserDao", SysUserDao.class);
	}

	@Test
	public void listSysUser() {
		List<SysUserDO> list = dao.listSysUser("user", 1, 3);
		for (SysUserDO sysUserDO : list) {
			System.err.println(sysUserDO);
		}
	}

	@Test
	public void getRowCount() {
		Integer count = dao.getRowCount("");
		System.err.println("count=" + count);
	}

	@Test
	public void getUserByUsername() {
		SysUserDO user = dao.getUserByUsername("abc");
		System.err.println(user);
	}

	@Test
	public void insertSysUser() {
		SysUserDO sysUserDO = new SysUserDO(null, null, "admin", "admin", null, "abc", "123456", "aaaaaa", "a@tedu.cn",
				"13322223333", 1, 1, null);
		Integer row = dao.insertSysUser(sysUserDO);
		System.err.println("row=" + row);
	}

	@Test
	public void insertUserRoles() {
		Integer userId = 19;
		Integer[] roleIds = { 45, 47, 48 };
		Integer row = dao.insertUserRoles(userId, roleIds);
		System.out.println("row=" + row);
	}

	@Test
	public void listRoleIdByUserId() {
		List<Integer> list = dao.listRoleIdByUserId(17);
		for (Integer roleId : list) {
			System.err.println("roleId=" + roleId);
		}
	}
}
