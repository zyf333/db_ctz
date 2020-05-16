package com.company.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.db.sys.pojo.MenuNodeVO;
import com.company.db.sys.pojo.SysMenuDO;

public interface SysMenuDao {

	/**
	 * 添加菜单记录
	 * 
	 * @param sysMenuDO 新的菜单记录
	 * @return 添加成功的数据条数
	 */
	Integer insertSysMenu(SysMenuDO sysMenuDO);

	/**
	 * 基于菜单id删除菜单记录
	 * 
	 * @param id 菜单id
	 * @return 删除成功的记录条数
	 */
	Integer deleteById(Integer id);

	/**
	 * 基于菜单id查询子菜单数量
	 * 
	 * @param parentId 父菜单id
	 * @return 子菜单数量
	 */
	Integer countByParentId(Integer parentId);

	/**
	 * 基于菜单id查询菜单记录
	 * 
	 * @param id 菜单id
	 * @return 菜单记录 或 null
	 */
	SysMenuDO getSysMenu(Integer id);

	/**
	 * 查询所有菜单记录及父菜单名称
	 */
	List<SysMenuDO> selectAll();

	/**
	 * 查询所有菜单的id,name和parentId
	 * 
	 * @return 封装菜单节点信息的集合
	 */
	List<MenuNodeVO> listMenuNode();

	/**
	 * 基于id查询菜单记录及父菜单名称
	 * 
	 * @param id 菜单id
	 * @return 菜单记录
	 */
	SysMenuDO getSysMenuById(Integer id);

	/**
	 * 基于id更新菜单记录
	 * 
	 * @param sysMenuDO 新的菜单记录
	 * @return 更新成功的数据条数
	 */
	Integer updateSysMenu(SysMenuDO sysMenuDO);

	/**
	 * 基于菜单id查询对应记录的条数
	 * 
	 * @param menuIds 菜单id数组
	 * @return 实际存在的记录条数
	 */
	Integer getMenuCount(@Param("menuIds") Integer[] menuIds);

	// ========================== 对RoleMenu表的操作 ============================= //
	/**
	 * 基于菜单id查询角色菜单表中关联记录的条数
	 * 
	 * @param menuId 菜单id
	 * @return 对应的数据条数
	 */
	Integer countRoleMenuByMenuId(Integer menuId);

	/**
	 * 基于菜单id删除角色菜单表中的关联记录
	 * 
	 * @param menuId 菜单id
	 * @return 删除成功的记录条数
	 */
	Integer deleteRoleMenuByMenuId(Integer menuId);

	/**
	 * 基于菜单id查询权限信息
	 * 
	 * @param menuIds 菜单id
	 * @return 权限信息数组
	 */
	List<String> listPermissions(@Param("menuIds") Integer[] menuIds);
}
