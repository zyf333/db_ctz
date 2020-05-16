package com.company.db.sys.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.pojo.SysUserDO;
import com.company.db.sys.service.ex.EmptyArgumentException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.IllegalPageNumberException;
import com.company.db.sys.service.ex.InsertException;
import com.company.db.sys.service.ex.RecordNotFoundException;
import com.company.db.sys.service.ex.UsernameExistsException;

public interface ISysUserService {

	/**
	 * 基于用户名分页查询用户信息
	 * 
	 * @param username    用户名
	 * @param pageCurrent 当前页码
	 * @return 当前页数据
	 * @throws IllegalPageNumberException
	 * @throws RecordNotFoundException
	 */
	@RequiresPermissions("sys:user:view")
	PageObjectVO<SysUserDO> findSysUser(String username, Integer pageCurrent)
			throws IllegalPageNumberException, RecordNotFoundException;

	/**
	 * 保存用户信息
	 * 
	 * @param sysUserDO 用户信息
	 * @param roleIds   关联的角色id的数组
	 * @throws EmptyArgumentException
	 * @throws RecordNotFoundException
	 * @throws EmptyIdException
	 * @throws UsernameExistsException
	 * @throws InsertException
	 */
	@RequiresPermissions("sys:user:add")
	void saveSysUser(SysUserDO sysUserDO, Integer[] roleIds) throws EmptyArgumentException, RecordNotFoundException,
			EmptyIdException, UsernameExistsException, InsertException;

}
