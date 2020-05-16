package com.company.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.db.sys.pojo.SysLogDO;

public interface SysLogDao {
	
	Integer insert(SysLogDO sysLogDO);

	Integer deleteByIds(@Param("ids") Integer... ids);

	/**
	 * 基于用户名查询总数据条数
	 */
	// 如果参数被用于动态SQL， 即使该方法仅有1个参数， 也必须加@Param注解
	Integer countByUsername(@Param("username") String username);

	/**
	 * 基于用户名分页查询数据
	 * 
	 * @param username    用户名
	 * @param recordIndex 跳过的数据条数
	 * @param pageSize    查询的数据条数
	 * @return 当前页数据
	 */
	List<SysLogDO> selectByUsernameLimit(
			@Param("username") String username, 
			@Param("recordIndex") Integer recordIndex,
			@Param("pageSize") Integer pageSize);

}
