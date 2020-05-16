package com.company.db.sys.service;

import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.pojo.SysLogDO;
import com.company.db.sys.service.ex.DeleteException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.IllegalPageCurrentNumberException;
import com.company.db.sys.service.ex.RecordNotFoundException;

public interface ISysLogService {

	void removeByIds(Integer[] ids) throws EmptyIdException, DeleteException;

	/**
	 * 基于用户名分页查询日志数据
	 * 
	 * @param username    用户名
	 * @param pageCurrent 当前页码
	 * @return 当前页数据
	 * @throws IllegalPageCurrentNumberException
	 * @throws RecordNotFoundException
	 */
	PageObjectVO<SysLogDO> findPage(String username, Integer pageCurrent)
			throws IllegalPageCurrentNumberException, RecordNotFoundException;

}
