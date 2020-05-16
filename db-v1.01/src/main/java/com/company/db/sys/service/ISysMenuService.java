package com.company.db.sys.service;

import java.util.List;

import com.company.db.sys.pojo.MenuNodeVO;
import com.company.db.sys.pojo.SysMenuDO;
import com.company.db.sys.service.ex.DeleteException;
import com.company.db.sys.service.ex.EmptyArgumentException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.HasSubMenuException;
import com.company.db.sys.service.ex.IllegalOperationException;
import com.company.db.sys.service.ex.InsertException;
import com.company.db.sys.service.ex.ParentNodeNotFoundException;
import com.company.db.sys.service.ex.RecordNotFoundException;
import com.company.db.sys.service.ex.UpdateException;

public interface ISysMenuService {

	/**
	 * 添加菜单信息
	 * 
	 * @param sysMenuDO 新的菜单信息
	 * @throws EmptyArgumentException
	 * @throws ParentNodeNotFoundException
	 * @throws InsertException
	 */
	void saveSysMenu(SysMenuDO sysMenuDO) throws EmptyArgumentException, ParentNodeNotFoundException, InsertException;

	/**
	 * 基于菜单id 删除菜单记录及角色菜单表中关联记录
	 */
	void removeById(Integer id) throws EmptyIdException, HasSubMenuException, DeleteException;

	List<SysMenuDO> findAll() throws RecordNotFoundException;

	/**
	 * 查询所有菜单节点信息
	 * 
	 * @return 菜单节点信息的集合
	 * @throws RecordNotFoundException
	 */
	List<MenuNodeVO> findMenuNode() throws RecordNotFoundException;

	/**
	 * 基于id查询菜单记录和父菜单名称
	 * 
	 * @param id
	 * @return 菜单记录
	 * @throws EmptyIdException
	 * @throws RecordNotFoundException
	 */
	SysMenuDO findSysMenuById(Integer id) throws EmptyIdException, RecordNotFoundException;

	/**
	 * 更新菜单记录
	 * 
	 * @param sysMenuDO 新的菜单记录
	 * @throws EmptyArgumentException
	 * @throws ParentNodeNotFoundException
	 * @throws IllegalOperationException
	 * @throws UpdateException
	 */
	void modifySysMenu(SysMenuDO sysMenuDO) throws EmptyArgumentException, EmptyIdException,
			ParentNodeNotFoundException, IllegalOperationException, UpdateException;

	/**
	 * 基于菜单id查询菜单记录数量
	 * 
	 * @param menuIds 菜单id数组
	 * @return 实际存在的菜单记录数量
	 * @throws EmptyIdException
	 */
	Integer findMenuCount(Integer[] menuIds) throws EmptyIdException;
}
