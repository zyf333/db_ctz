package com.company.db.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.company.db.common.aop.SysLogAnnotation;
import com.company.db.common.util.UserUtils;
import com.company.db.sys.dao.SysMenuDao;
import com.company.db.sys.pojo.MenuNodeVO;
import com.company.db.sys.pojo.SysMenuDO;
import com.company.db.sys.service.ISysMenuService;
import com.company.db.sys.service.ex.DeleteException;
import com.company.db.sys.service.ex.EmptyArgumentException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.HasSubMenuException;
import com.company.db.sys.service.ex.IllegalOperationException;
import com.company.db.sys.service.ex.InsertException;
import com.company.db.sys.service.ex.ParentNodeNotFoundException;
import com.company.db.sys.service.ex.RecordNotFoundException;
import com.company.db.sys.service.ex.UpdateException;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

	@Autowired
	private SysMenuDao dao;

	@Transactional
	@SysLogAnnotation(operation = "添加菜单")
	public void saveSysMenu(SysMenuDO sysMenuDO)
			throws EmptyArgumentException, ParentNodeNotFoundException, InsertException {

		if (sysMenuDO == null || StringUtils.isEmpty(sysMenuDO.getName())) {
			throw new EmptyArgumentException("添加菜单异常！新菜单记录为空");
		}

		SysMenuDO parentMenu = dao.getSysMenu(sysMenuDO.getParentId());
		if (parentMenu == null) {
			throw new ParentNodeNotFoundException("添加菜单异常！父菜单不存在");
		}

		Integer row = dao.insertSysMenu(sysMenuDO);
		if (row == 0) {
			throw new InsertException("添加菜单异常！菜单添加失败");
		}
	}

	@Transactional
	public void removeById(Integer id) throws EmptyIdException, HasSubMenuException, DeleteException {

		if (id == null || id < 1) {
			throw new EmptyIdException("删除菜单异常！菜单id为空");
		}

		Integer subMenuCount = dao.countByParentId(id);

		if (subMenuCount != 0) {
			throw new HasSubMenuException("删除菜单异常！请先删除其子菜单项");
		}

		Integer row1 = dao.deleteById(id);
		if (row1 == 0) {
			throw new DeleteException("删除菜单异常！删除菜单记录失败");
		}

		Integer roleMenuCount = dao.countRoleMenuByMenuId(id);
		if (roleMenuCount != 0) {
			Integer row2 = dao.deleteRoleMenuByMenuId(id);
			if (row2 != roleMenuCount) {
				throw new DeleteException("删除菜单异常！关联数据删除异常");
			}
		}
	}

	@Override
	public List<SysMenuDO> findAll() throws RecordNotFoundException {

		List<SysMenuDO> list = dao.selectAll();
		if (list == null || list.size() == 0) {
			throw new RecordNotFoundException("查询菜单异常！未查询到相关记录");
		}
		return list;
	}

	@SysLogAnnotation(operation = "查询菜单节点")
	public List<MenuNodeVO> findMenuNode() throws RecordNotFoundException {

		List<MenuNodeVO> list = dao.listMenuNode();
		if (list == null || list.size() == 0) {
			throw new RecordNotFoundException("查询菜单节点异常！未查询到相关记录");
		}
		return list;
	}

	@SysLogAnnotation(operation = "查询菜单")
	public SysMenuDO findSysMenuById(Integer id) throws EmptyIdException, RecordNotFoundException {
		// 判断id是否为null或者小于1
		if (id == null || id < 1) {
			// 是：EmptyIdException
			throw new EmptyIdException("查询菜单记录异常！id为空");
		}
		// 调用持久层方法，查询菜单记录
		SysMenuDO sysMenuDO = dao.getSysMenuById(id);
		// 判断返回值是否为null
		if (sysMenuDO == null) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("查询菜单异常！未找到对应记录");
		}
		// 返回查询结果
		return sysMenuDO;
	}

	@Transactional
	@SysLogAnnotation(operation = "更新菜单")
	public void modifySysMenu(SysMenuDO sysMenuDO) throws EmptyArgumentException, EmptyIdException,
			ParentNodeNotFoundException, IllegalOperationException, UpdateException {
		// 判断sysMenuDO是否为null
		if (sysMenuDO == null) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("更新菜单异常！菜单数据为空");
		}
		// 判断sysMenuDO.id是否为null或者小于1
		if (sysMenuDO.getId() == null || sysMenuDO.getId() < 1) {
			// 是：EmptyIdException
			throw new EmptyIdException("更新菜单异常！菜单id为空");
		}
		// 判断sysMenuDO.name是否为null或者为空字符
		if (sysMenuDO.getName() == null || StringUtils.isEmpty(sysMenuDO.getName())) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("更新菜单异常！菜单名称为空");
		}
		// 其他必填字段也已经进行验证

		// 判断sysMenuDO.id和sysMenuDO.parentId是否一致
		if (sysMenuDO.getId().equals(sysMenuDO.getParentId())) {
			// 是：IllegalOperationException
			throw new IllegalOperationException("更新菜单异常！不能将当前菜单设置为自己的父菜单");
		}

		// 调用持久层方法，查询parentId对应的记录
		SysMenuDO parentMenu = dao.getSysMenu(sysMenuDO.getParentId());
		// 判断记录是否为null
		if (parentMenu == null) {
			// 是：ParentNodeNotFoundException
			throw new ParentNodeNotFoundException("更新菜单异常！未查询到父菜单！");
		}

		// 设置modifiedUser
		sysMenuDO.setModifiedUser(UserUtils.getUsername());

		// 调用持久层方法，执行更新操作
		Integer row = dao.updateSysMenu(sysMenuDO);
		// 判断返回值是否为0
		if (row == 0) {
			// 是：UpdateException
			throw new UpdateException("更新菜单异常！菜单更新失败！");
		}
	}

	@SysLogAnnotation(operation = "查询菜单数量")
	@Transactional
	public Integer findMenuCount(Integer[] menuIds) throws EmptyIdException {
		if (menuIds == null || menuIds.length == 0) {
			throw new EmptyIdException("查询菜单记录异常！菜单id为空");
		}
		Integer count = dao.getMenuCount(menuIds);
		return count;
	}
}
