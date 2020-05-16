package com.company.db.sys.service;

import java.util.List;

import org.junit.Test;

import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.pojo.SysLogDO;
import com.company.test.BaseTest;

public class ISysLogServiceTests extends BaseTest {

	private ISysLogService service;

	@Override
	public void doBefore() {
		super.doBefore();
		service = context.getBean("sysLogServiceImpl", ISysLogService.class);
	}

	@Test
	public void removeByIds() {
		
		Integer[] ids = { 1000, 20 };
		service.removeByIds(ids);
		System.out.println("OK.");
	}

	@Test
	public void findPage() {
		PageObjectVO<SysLogDO> vo = service.findPage("dmi", 1);
		System.out.println(vo);
		List<SysLogDO> pageRecord = vo.getPageRecord();
		for (SysLogDO sysLogDO : pageRecord) {
			System.out.println(sysLogDO);
		}
	}
}
