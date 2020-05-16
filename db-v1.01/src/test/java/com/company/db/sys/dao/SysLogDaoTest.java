package com.company.db.sys.dao;

import java.util.List;

import org.junit.Test;

import com.company.db.sys.pojo.SysLogDO;
import com.company.test.BaseTest;

public class SysLogDaoTest extends BaseTest {

	private SysLogDao dao;

	@Override
	public void doBefore() {
		super.doBefore();
		dao = context.getBean("sysLogDao", SysLogDao.class);

	}

	@Test
	public void insert() {
		SysLogDO sysLogDO = new SysLogDO(null, "tester", "测试操作", "cn.tedu.test...", "abc", 100L, "127.0.0.1", null);
		Integer row = dao.insert(sysLogDO);
		System.err.println("row=" + row);
	}

	@Test
	public void deleteByIds() {
		Integer rows = dao.deleteByIds(20, 21);
		System.out.println("rows:" + rows);
	}

	// ========================== 查询方法的测试 ============================= //

	@Test
	public void countByUsername() {
		Integer count = dao.countByUsername("dmi");
		System.out.println("count=" + count);
	}

	@Test
	public void selectByUsernameLimit() {
		List<SysLogDO> list = dao.selectByUsernameLimit("admin1", 0, 5);
		for (SysLogDO item : list) {
			System.out.println(item);
		}
	}
}
