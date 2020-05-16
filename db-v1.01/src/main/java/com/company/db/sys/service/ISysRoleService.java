package com.company.db.sys.service;

import java.util.List;

import com.company.db.common.pojo.PageObjectVO;
import com.company.db.sys.pojo.SysRoleDO;
import com.company.db.sys.service.ex.DeleteException;
import com.company.db.sys.service.ex.EmptyArgumentException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.IllegalPageNumberException;
import com.company.db.sys.service.ex.InsertException;
import com.company.db.sys.service.ex.RecordNotFoundException;
import com.company.db.sys.service.ex.UpdateException;

/**
 * 角色模块的业务层父接口
 */
public interface ISysRoleService {

	/**
	 * 基于角色名称分页查询角色记录
	 * 
	 * @param name        角色名称
	 * @param pageCurrent 当前页码
	 * @return 当前页记录
	 * @throws IllegalPageNumberException
	 * @throws RecordNotFoundException
	 */
	PageObjectVO<SysRoleDO> findSysRole(String name, Integer pageCurrent)
			throws IllegalPageNumberException, RecordNotFoundException;

	/**
	 * 添加角色记录 和角色菜单表中关联记录
	 * 
	 * @param sysRoleDO 新的角色记录
	 * @param menuIds   关联的菜单记录id的数组
	 * @throws EmptyArgumentException
	 * @throws EmptyIdException
	 * @throws RecordNotFoundException
	 * @throws InsertException
	 */
	void saveSysRole(SysRoleDO sysRoleDO, Integer[] menuIds)
			throws EmptyArgumentException, EmptyIdException, RecordNotFoundException, InsertException;

	/**
	 * 基于角色id删除角色记录 同时删除角色菜单关联记录 和 用户角色关联记录
	 * 
	 * @param roleId 角色id
	 * @throws EmptyIdException
	 * @throws DeleteException
	 */
	void removeSysRole(Integer roleId) throws EmptyIdException, DeleteException;

	/**
	 * 基于角色id查询关联的菜单id
	 * 
	 * @param roleId 角色id
	 * @return 菜单id的集合
	 * @throws EmptyIdException
	 * @throws RecordNotFoundException
	 */
	List<Integer> findMenuByRoleId(Integer roleId) throws EmptyIdException, RecordNotFoundException;

	/**
	 * 更新角色记录及角色菜单关联记录
	 * 
	 * @param sysRoleDO 新的角色记录
	 * @param menuIds   关联的菜单id
	 * @throws EmptyIdException
	 * @throws EmptyArgumentException
	 * @throws RecordNotFoundException
	 * @throws UpdateException
	 * @throws DeleteException
	 * @throws InsertException
	 */
	void modifySysRole(SysRoleDO sysRoleDO, Integer[] menuIds) throws EmptyIdException, EmptyArgumentException,
			RecordNotFoundException, UpdateException, DeleteException, InsertException;

	/**
	 * 查询所有角色id和name
	 * 
	 * @return 角色信息的集合
	 * @throws RecordNotFoundException
	 */
	List<SysRoleDO> findAllSysRole() throws RecordNotFoundException;

	/**
	 * 基于角色id数组查询对应角色数据条数
	 * 
	 * @param roleIds 角色id的数组
	 * @return 实际存在的数据条数
	 * @throws EmptyIdException
	 */
	Integer findRoleCount(Integer[] roleIds) throws EmptyIdException;
}