package com.company.db.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.company.db.common.pojo.PageObjectVO;
import com.company.db.common.util.UserUtils;
import com.company.db.sys.dao.SysUserDao;
import com.company.db.sys.pojo.SysUserDO;
import com.company.db.sys.service.ISysRoleService;
import com.company.db.sys.service.ISysUserService;
import com.company.db.sys.service.ex.EmptyArgumentException;
import com.company.db.sys.service.ex.EmptyIdException;
import com.company.db.sys.service.ex.IllegalPageNumberException;
import com.company.db.sys.service.ex.InsertException;
import com.company.db.sys.service.ex.RecordNotFoundException;
import com.company.db.sys.service.ex.UsernameExistsException;

@Service
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	SysUserDao dao;

	int pageSize = 3;

	@Autowired
	private ISysRoleService roleService;

	public PageObjectVO<SysUserDO> findSysUser(String username, Integer pageCurrent)
			throws IllegalPageNumberException, RecordNotFoundException {
		// 判断currentPage是否为null或小于1
		if (pageCurrent == null || pageCurrent < 1) {
			// 是：IllegalPageNumberException
			throw new IllegalPageNumberException("查询用户信息异常！当前页码异常");
		}

		// 调用持久层方法，查询总数据条数
		Integer rowCount = dao.getRowCount(username);
		// 判断rowCount是否为0
		if (rowCount == 0) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("查询用户信息异常！总数据条数为0");
		}

		// 计算生成recordIndex
		int recordIndex = (pageCurrent - 1) * pageSize;
		// 调用持久层方法，查询当前页记录
		List<SysUserDO> list = dao.listSysUser(username, recordIndex, pageSize);
		// 创建PageObjectVo对象
		PageObjectVO<SysUserDO> vo = new PageObjectVO<SysUserDO>();
		// 向PageObjectVo中填充数据
		vo.setPageCurrent(pageCurrent);
		vo.setPageCount((rowCount - 1) / pageSize + 1);
		vo.setPageRecord(list);
		vo.setPageSize(pageSize);
		vo.setRowCount(rowCount);
		// 返回PageObjectVo对象
		return vo;
	}

	@Transactional
	public void saveSysUser(SysUserDO sysUserDO, Integer[] roleIds) throws EmptyArgumentException, EmptyIdException,
			RecordNotFoundException, UsernameExistsException, InsertException {
		// 判断sysUserDO是否为null
		if (sysUserDO == null) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("添加用户异常！用户数据为空");
		}

		// 判断sysUserDO.username是否为空
		if (StringUtils.isEmpty(sysUserDO.getUsername())) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("添加用户异常！用户名为空");
		}

		// 判断sysUserDO.password是否为空
		if (StringUtils.isEmpty(sysUserDO.getPassword())) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("添加用户异常！密码为空");
		}

		// 调用持久层方法，使用username查询用户记录
		SysUserDO user = dao.getUserByUsername(sysUserDO.getUsername());
		// 判断查询结果是否不为null
		if (user != null) {
			// 是：UsernameExistsException
			throw new UsernameExistsException("添加用户异常！该用户名已存在");
		}

		// 调用roleService，查询roleIds对应的数据条数
		Integer roleCount = roleService.findRoleCount(roleIds);
		System.out.println("roleIds.length:"+roleIds.length);
		System.out.println("roleCount:" + roleCount);
		// 判断查询结果与roleIds长度是否不一致
		if (roleCount != roleIds.length) {
			System.out.println(11111);
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("添加用户异常！拟添加的角色可能不存在");
		}

		// 生成盐值
		String salt = UUID.randomUUID().toString();
		// 对密码进行加密 Shiro 有一个加密模块-优化的加密API，简单，没有受检异常
		SimpleHash sh = new SimpleHash("MD5", // 算法名称
				sysUserDO.getPassword(), // 被加密的内容
				salt, // 盐值
				3); // 迭代次数，默认值为1

		// 设置盐值和加密后的密码
		sysUserDO.setPassword(sh.toHex());
		sysUserDO.setSalt(salt);
		// 设置valid为1
		sysUserDO.setValid(1);
		// 设置createdUser和modifiedUser
		sysUserDO.setCreatedUser(UserUtils.getUsername());
		sysUserDO.setModifiedUser(UserUtils.getUsername());

		// 调用持久层方法，添加用户信息
		Integer row1 = dao.insertSysUser(sysUserDO);
		// 判断返回值是否为0或者sysUserDO.id是否为null
		if (row1 == 0 || sysUserDO.getId() == null) {
			// 是：InsertException
			throw new InsertException("添加用户异常！用户添加失败");
		}

		// 调用持久层方法，添加用户角色关联记录
		Integer row2 = dao.insertUserRoles(sysUserDO.getId(), roleIds);
		// 判断返回值是否与roleIds的长度不一致
		if (row2 != roleIds.length) {
			// 是：InsertException
			throw new InsertException("添加用户异常！用户角色关联数据添加失败");
		}
	}
}
