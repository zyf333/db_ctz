package com.company.db.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.db.common.aop.SysLogAnnotation;
import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.dao.SysLogDao;
import com.company.db.sys.pojo.SysLogDO;
import com.company.db.sys.service.ISysLogService;
import com.company.db.sys.service.ex.DeleteException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.IllegalPageCurrentNumberException;
import com.company.db.sys.service.ex.RecordNotFoundException;

@Service
public class SysLogServiceImpl implements ISysLogService {

	@Autowired
	private SysLogDao dao;

	private Integer pageSize = 3;

	@Override
	@Transactional
	@SysLogAnnotation(operation = "删除日志")
	public void removeByIds(Integer[] ids) throws EmptyIdException, DeleteException {

		if (ids == null || ids.length == 0) {
			throw new EmptyIdException("删除日志异常！id数组为空");
		}

		Integer rows = dao.deleteByIds(ids);

		if (rows != ids.length) {
			throw new DeleteException("删除日志异常！存在未删除成功的记录");
		}
	}

	@Override
	@SysLogAnnotation(operation = "查询日志")
	public PageObjectVO<SysLogDO> findPage(String username, Integer pageCurrent)
			throws IllegalPageCurrentNumberException, RecordNotFoundException {

		if (pageCurrent == null || pageCurrent < 1) {
			throw new IllegalPageCurrentNumberException("查询日志异常！页码不正确");
		}

		Integer rowCount = dao.countByUsername(username);
		if (rowCount == 0) {
			throw new RecordNotFoundException("查询日志异常！总数据条数为0");
		}

		Integer recordIndex = (pageCurrent - 1) * pageSize;
		List<SysLogDO> pageRecord = dao.selectByUsernameLimit(username, recordIndex, pageSize);
		if (pageRecord == null || pageRecord.size() == 0) {
			throw new RecordNotFoundException("查询日志异常！未查询到相关记录");
		}

		PageObjectVO<SysLogDO> vo = new PageObjectVO<SysLogDO>();
		vo.setPageCount((rowCount - 1) / pageSize + 1);
		vo.setPageCurrent(pageCurrent);
		vo.setPageRecord(pageRecord);
		vo.setPageSize(pageSize);
		vo.setRowCount(rowCount);
		return vo;
	}

}
