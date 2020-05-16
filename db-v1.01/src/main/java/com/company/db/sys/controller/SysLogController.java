package com.company.db.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.db.common.pojo.JsonResult;
import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.pojo.SysLogDO;
import com.company.db.sys.service.ISysLogService;

@RestController
@RequestMapping("/log")
public class SysLogController {

	@Autowired
	ISysLogService service;

	// localhost:8080/log/remove?ids=19&ids=20&ids=21或localhost:8080/log/remove?ids=19,20,21
	@RequestMapping("/remove")
	public JsonResult<Void> removeByIds(Integer[] ids) {
		service.removeByIds(ids);
		return JsonResult.getSuccessJR();
	}

	// localhost:8080/log/findPage?pageCurrent=1
	@RequestMapping("/findPage")
	public JsonResult<PageObjectVO<SysLogDO>> findPage(String username, Integer pageCurrent) {
		PageObjectVO<SysLogDO> data = service.findPage(username, pageCurrent);
		return JsonResult.getSuccessJR(data);
	}
}