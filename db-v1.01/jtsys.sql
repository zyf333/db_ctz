/*
Navicat MySQL Data Transfer

Source Server         : fuckYouBitch
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : jtsys

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-05-16 09:42:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_configs
-- ----------------------------
DROP TABLE IF EXISTS `sys_configs`;
CREATE TABLE `sys_configs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '参数名',
  `value` varchar(50) DEFAULT NULL COMMENT '参数值',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='配置管理';

-- ----------------------------
-- Records of sys_configs
-- ----------------------------
INSERT INTO `sys_configs` VALUES ('4', 'uploadPath', '/upload/images', '上传路径', '2018-04-22 17:39:55', '2018-04-22 17:39:55', null, null);
INSERT INTO `sys_configs` VALUES ('5', 'downloadPath', '/downloads/', '文件下载路径', '2018-04-22 17:40:41', '2018-04-22 17:40:41', null, null);

-- ----------------------------
-- Table structure for sys_depts
-- ----------------------------
DROP TABLE IF EXISTS `sys_depts`;
CREATE TABLE `sys_depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `parentId` int(11) DEFAULT NULL COMMENT '上级部门',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of sys_depts
-- ----------------------------
INSERT INTO `sys_depts` VALUES ('2', 'dept-a', null, '1', 'dept-a ..', '2018-04-19 18:59:09', '2018-04-19 18:59:09', 'admin', 'admin');
INSERT INTO `sys_depts` VALUES ('3', 'dept-b', null, '2', '1111', '2018-04-19 19:15:05', '2018-04-19 19:15:05', null, null);
INSERT INTO `sys_depts` VALUES ('4', 'dept-aa', '2', '1', '', '2018-04-22 18:10:58', '2018-04-22 22:11:47', null, null);

-- ----------------------------
-- Table structure for sys_dicts
-- ----------------------------
DROP TABLE IF EXISTS `sys_dicts`;
CREATE TABLE `sys_dicts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `code` varchar(20) DEFAULT NULL COMMENT '字典码',
  `value` varchar(100) DEFAULT NULL COMMENT '字典值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典管理';

-- ----------------------------
-- Records of sys_dicts
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_logs
-- ----------------------------
INSERT INTO `sys_logs` VALUES ('9', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '3', '0:0:0:0:0:0:0:1', '2018-04-17 19:53:38');
INSERT INTO `sys_logs` VALUES ('10', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '2', '0:0:0:0:0:0:0:1', '2018-04-17 19:54:05');
INSERT INTO `sys_logs` VALUES ('11', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '1', '0:0:0:0:0:0:0:1', '2018-04-17 19:54:36');
INSERT INTO `sys_logs` VALUES ('12', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '155', '0:0:0:0:0:0:0:1', '2018-04-18 15:14:44');
INSERT INTO `sys_logs` VALUES ('13', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '165', '0:0:0:0:0:0:0:1', '2018-04-19 18:52:35');
INSERT INTO `sys_logs` VALUES ('14', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '75', '0:0:0:0:0:0:0:1', '2018-04-19 19:10:36');
INSERT INTO `sys_logs` VALUES ('15', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '69', '0:0:0:0:0:0:0:1', '2018-04-19 19:12:46');
INSERT INTO `sys_logs` VALUES ('16', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '187', '0:0:0:0:0:0:0:1', '2018-04-19 23:27:14');
INSERT INTO `sys_logs` VALUES ('17', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '103', '0:0:0:0:0:0:0:1', '2018-04-20 13:11:37');
INSERT INTO `sys_logs` VALUES ('18', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '85', '0:0:0:0:0:0:0:1', '2018-04-20 13:55:04');
INSERT INTO `sys_logs` VALUES ('19', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '89', '0:0:0:0:0:0:0:1', '2018-04-20 13:57:12');
INSERT INTO `sys_logs` VALUES ('20', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '69', '0:0:0:0:0:0:0:1', '2018-04-20 13:58:32');
INSERT INTO `sys_logs` VALUES ('21', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '291', '0:0:0:0:0:0:0:1', '2018-04-20 15:22:55');
INSERT INTO `sys_logs` VALUES ('22', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '158', '0:0:0:0:0:0:0:1', '2018-04-22 16:20:56');
INSERT INTO `sys_logs` VALUES ('23', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '94', '0:0:0:0:0:0:0:1', '2018-04-22 17:05:34');
INSERT INTO `sys_logs` VALUES ('24', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '138', '0:0:0:0:0:0:0:1', '2018-04-22 17:20:32');
INSERT INTO `sys_logs` VALUES ('25', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '124', '0:0:0:0:0:0:0:1', '2018-04-22 17:24:12');
INSERT INTO `sys_logs` VALUES ('26', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '75', '0:0:0:0:0:0:0:1', '2018-04-22 17:31:51');
INSERT INTO `sys_logs` VALUES ('27', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '148', '0:0:0:0:0:0:0:1', '2018-04-22 17:33:25');
INSERT INTO `sys_logs` VALUES ('28', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '69', '0:0:0:0:0:0:0:1', '2018-04-22 17:39:26');
INSERT INTO `sys_logs` VALUES ('29', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '120', '0:0:0:0:0:0:0:1', '2018-04-22 19:10:28');
INSERT INTO `sys_logs` VALUES ('30', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '104', '0:0:0:0:0:0:0:1', '2018-04-22 19:23:56');
INSERT INTO `sys_logs` VALUES ('31', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '79', '0:0:0:0:0:0:0:1', '2018-04-22 19:42:40');
INSERT INTO `sys_logs` VALUES ('32', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '71', '0:0:0:0:0:0:0:1', '2018-04-22 19:58:49');
INSERT INTO `sys_logs` VALUES ('33', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '201', '0:0:0:0:0:0:0:1', '2018-04-22 20:02:01');
INSERT INTO `sys_logs` VALUES ('34', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '119', '0:0:0:0:0:0:0:1', '2018-04-22 20:26:31');
INSERT INTO `sys_logs` VALUES ('35', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '131', '0:0:0:0:0:0:0:1', '2018-04-22 20:58:21');
INSERT INTO `sys_logs` VALUES ('36', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '9', '192.168.43.1', '2018-04-22 21:32:25');
INSERT INTO `sys_logs` VALUES ('37', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '6', '192.168.43.183', '2018-04-22 21:34:40');
INSERT INTO `sys_logs` VALUES ('39', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '4', '0:0:0:0:0:0:0:1', '2020-04-19 21:15:34');
INSERT INTO `sys_logs` VALUES ('40', 'visitor', '删除日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.removeByIds', '[[38]]', '25', '0:0:0:0:0:0:0:1', '2020-04-19 21:15:38');
INSERT INTO `sys_logs` VALUES ('41', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '4', '0:0:0:0:0:0:0:1', '2020-04-19 21:15:40');
INSERT INTO `sys_logs` VALUES ('42', 'visitor', '查询菜单节点', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuNode', '[]', '3', '0:0:0:0:0:0:0:1', '2020-04-19 21:22:45');
INSERT INTO `sys_logs` VALUES ('43', 'visitor', '查询菜单数量', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuCount', '[[46,115,116,117,118]]', '4', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:04');
INSERT INTO `sys_logs` VALUES ('44', 'visitor', '添加角色', 'com.company.db.sys.service.impl.SysRoleServiceImpl.saveSysRole', '[{\"createdTime\":null,\"modifiedTime\":null,\"createdUser\":\"visitor\",\"modifiedUser\":\"visitor\",\"id\":46,\"name\":\"菜单管理员\",\"note\":\"\"},[46,115,116,117,118]]', '11', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:04');
INSERT INTO `sys_logs` VALUES ('45', 'visitor', '查询菜单节点', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuNode', '[]', '3', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:10');
INSERT INTO `sys_logs` VALUES ('46', 'visitor', '查询菜单数量', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuCount', '[[47,120,128,129,130]]', '3', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:33');
INSERT INTO `sys_logs` VALUES ('47', 'visitor', '添加角色', 'com.company.db.sys.service.impl.SysRoleServiceImpl.saveSysRole', '[{\"createdTime\":null,\"modifiedTime\":null,\"createdUser\":\"visitor\",\"modifiedUser\":\"visitor\",\"id\":47,\"name\":\"角色管理员\",\"note\":\"\"},[47,120,128,129,130]]', '10', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:33');
INSERT INTO `sys_logs` VALUES ('48', 'visitor', '查询菜单节点', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuNode', '[]', '2', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:35');
INSERT INTO `sys_logs` VALUES ('49', 'visitor', '查询菜单数量', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuCount', '[[45,119,126,127]]', '2', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:49');
INSERT INTO `sys_logs` VALUES ('50', 'visitor', '添加角色', 'com.company.db.sys.service.impl.SysRoleServiceImpl.saveSysRole', '[{\"createdTime\":null,\"modifiedTime\":null,\"createdUser\":\"visitor\",\"modifiedUser\":\"visitor\",\"id\":48,\"name\":\"用户管理员\",\"note\":\"\"},[45,119,126,127]]', '7', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:49');
INSERT INTO `sys_logs` VALUES ('51', 'visitor', '查询菜单节点', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuNode', '[]', '2', '0:0:0:0:0:0:0:1', '2020-04-19 21:23:52');
INSERT INTO `sys_logs` VALUES ('52', 'visitor', '查询菜单数量', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuCount', '[[25]]', '1', '0:0:0:0:0:0:0:1', '2020-04-19 21:24:08');
INSERT INTO `sys_logs` VALUES ('53', 'visitor', '添加角色', 'com.company.db.sys.service.impl.SysRoleServiceImpl.saveSysRole', '[{\"createdTime\":null,\"modifiedTime\":null,\"createdUser\":\"visitor\",\"modifiedUser\":\"visitor\",\"id\":49,\"name\":\"日志管理员\",\"note\":\"\"},[25]]', '5', '0:0:0:0:0:0:0:1', '2020-04-19 21:24:08');
INSERT INTO `sys_logs` VALUES ('54', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '4', '0:0:0:0:0:0:0:1', '2020-04-19 21:24:13');
INSERT INTO `sys_logs` VALUES ('55', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '51', '0:0:0:0:0:0:0:1', '2020-04-19 21:51:15');
INSERT INTO `sys_logs` VALUES ('56', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '6', '0:0:0:0:0:0:0:1', '2020-04-19 22:16:13');
INSERT INTO `sys_logs` VALUES ('57', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '4', '0:0:0:0:0:0:0:1', '2020-04-19 22:18:10');
INSERT INTO `sys_logs` VALUES ('58', 'visitor', '查询菜单节点', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuNode', '[]', '2', '0:0:0:0:0:0:0:1', '2020-04-19 22:18:18');
INSERT INTO `sys_logs` VALUES ('59', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '18', '0:0:0:0:0:0:0:1', '2020-04-19 22:26:57');
INSERT INTO `sys_logs` VALUES ('60', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '7', '0:0:0:0:0:0:0:1', '2020-04-19 22:28:49');
INSERT INTO `sys_logs` VALUES ('61', 'visitor', '查询菜单节点', 'com.company.db.sys.service.impl.SysMenuServiceImpl.findMenuNode', '[]', '8', '0:0:0:0:0:0:0:1', '2020-04-19 22:29:12');
INSERT INTO `sys_logs` VALUES ('62', 'visitor', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '18', '0:0:0:0:0:0:0:1', '2020-04-19 22:35:07');
INSERT INTO `sys_logs` VALUES ('63', 'Cici', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '373', '0:0:0:0:0:0:0:1', '2020-04-19 22:36:34');
INSERT INTO `sys_logs` VALUES ('64', 'Cici', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '3', '0:0:0:0:0:0:0:1', '2020-04-19 22:36:35');
INSERT INTO `sys_logs` VALUES ('65', 'Aie', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '58', '0:0:0:0:0:0:0:1', '2020-05-16 09:02:26');
INSERT INTO `sys_logs` VALUES ('66', 'Aie', '查询日志', 'com.company.db.sys.service.impl.SysLogServiceImpl.findPage', '[\"\",1]', '2', '0:0:0:0:0:0:0:1', '2020-05-16 09:03:06');

-- ----------------------------
-- Table structure for sys_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_menus`;
CREATE TABLE `sys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8 COMMENT='资源管理';

-- ----------------------------
-- Records of sys_menus
-- ----------------------------
INSERT INTO `sys_menus` VALUES ('8', '系统管理', '请求路径', '1', '8', null, null, 'sys:list', '2017-07-12 15:15:59', '2017-07-21 11:16:00', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('24', '系统配置', '请求路径', '1', '24', null, '8', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('25', '日志管理', '请求路径', '1', '25', null, '8', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('45', '用户管理', 'user/listUI.do', '1', '45', null, '8', 'sys:user:view', '2017-07-12 15:15:59', '2017-07-21 17:36:01', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('46', '菜单管理', 'menu/listUI.do', '1', '46', null, '8', 'sys:menu:view', '2017-07-12 15:15:59', '2017-07-21 17:36:16', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('47', '角色管理', 'role/listUI.do', '1', '47', null, '8', 'sys:role:view', '2017-07-12 15:15:59', '2017-07-21 17:38:03', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('48', '组织管理', '请求路径', '1', '48', null, '8', 'sys:org:view', '2017-07-12 15:15:59', '2017-07-21 18:37:57', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('115', '查看', '', '2', '1', null, '46', 'sys:menu:view', '2017-07-13 16:33:41', '2017-07-21 11:09:05', null, null);
INSERT INTO `sys_menus` VALUES ('116', '新增', '', '2', '2', null, '46', 'sys:menu:add', '2017-07-13 16:34:02', '2017-07-21 11:09:22', null, null);
INSERT INTO `sys_menus` VALUES ('117', '修改', '', '2', '3', null, '46', 'sys:menu:update', '2017-07-13 16:34:25', '2017-07-21 11:09:45', null, null);
INSERT INTO `sys_menus` VALUES ('118', '删除', '', '2', '4', null, '46', 'sys:menu:delete', '2017-07-13 16:34:46', '2017-07-21 11:10:12', null, null);
INSERT INTO `sys_menus` VALUES ('119', '查看', '', '2', '1', null, '45', 'sys:user:view', '2017-07-13 16:35:05', '2017-07-21 11:12:46', null, null);
INSERT INTO `sys_menus` VALUES ('120', '查看', '', '2', '1', null, '47', 'sys:role:view', '2017-07-13 16:35:26', '2017-07-21 11:13:43', null, null);
INSERT INTO `sys_menus` VALUES ('126', '新增', '', '2', '2', null, '45', 'sys:user:add', '2017-07-21 11:11:34', '2017-07-21 11:11:34', null, null);
INSERT INTO `sys_menus` VALUES ('127', '修改', '', '2', '3', null, '45', 'sys:user:update', '2017-07-21 11:11:56', '2017-07-21 11:11:56', null, null);
INSERT INTO `sys_menus` VALUES ('128', '新增', '', '2', '2', null, '47', 'sys:role:add', '2017-07-21 11:14:24', '2017-07-21 11:14:24', null, null);
INSERT INTO `sys_menus` VALUES ('129', '修改', '', '2', '3', null, '47', 'sys:role:update', '2017-07-21 11:14:48', '2017-07-21 11:14:48', null, null);
INSERT INTO `sys_menus` VALUES ('130', '删除', '', '2', '4', null, '47', 'sys:role:delete', '2017-07-21 11:15:09', '2017-07-21 11:15:09', null, null);

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('46', '菜单管理员', '', '2020-04-19 21:23:04', '2020-04-19 21:23:04', 'visitor', 'visitor');
INSERT INTO `sys_roles` VALUES ('47', '角色管理员', '', '2020-04-19 21:23:33', '2020-04-19 21:23:33', 'visitor', 'visitor');
INSERT INTO `sys_roles` VALUES ('48', '用户管理员', '', '2020-04-19 21:23:49', '2020-04-19 21:23:49', 'visitor', 'visitor');
INSERT INTO `sys_roles` VALUES ('49', '日志管理员', '', '2020-04-19 21:24:08', '2020-04-19 21:24:08', 'visitor', 'visitor');

-- ----------------------------
-- Table structure for sys_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menus`;
CREATE TABLE `sys_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1265 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menus
-- ----------------------------
INSERT INTO `sys_role_menus` VALUES ('1250', '46', '46');
INSERT INTO `sys_role_menus` VALUES ('1251', '46', '115');
INSERT INTO `sys_role_menus` VALUES ('1252', '46', '116');
INSERT INTO `sys_role_menus` VALUES ('1253', '46', '117');
INSERT INTO `sys_role_menus` VALUES ('1254', '46', '118');
INSERT INTO `sys_role_menus` VALUES ('1255', '47', '47');
INSERT INTO `sys_role_menus` VALUES ('1256', '47', '120');
INSERT INTO `sys_role_menus` VALUES ('1257', '47', '128');
INSERT INTO `sys_role_menus` VALUES ('1258', '47', '129');
INSERT INTO `sys_role_menus` VALUES ('1259', '47', '130');
INSERT INTO `sys_role_menus` VALUES ('1260', '48', '45');
INSERT INTO `sys_role_menus` VALUES ('1261', '48', '119');
INSERT INTO `sys_role_menus` VALUES ('1262', '48', '126');
INSERT INTO `sys_role_menus` VALUES ('1263', '48', '127');
INSERT INTO `sys_role_menus` VALUES ('1264', '49', '25');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `deptId` int(11) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', 'admin', '4ebd394fbd25e495e0753a7dc9889a8e', '7adb778c-e7d3-4dd3-a3c5-5f80a158006d', 'admin@t.cn', '13624356789', '1', '3', null, '2018-04-22 20:53:48', null, 'admin');
INSERT INTO `sys_users` VALUES ('2', 'zhangli', 'bdcf69375bdb532e50279b91eb00940d', '5e7cbd36-e897-4951-b42b-19809caf3caa', 'zhangli@t.cn', '13678909876', '0', '3', '2017-07-18 10:01:51', '2018-04-22 20:49:19', null, 'admin');
INSERT INTO `sys_users` VALUES ('3', 'wangke', 'c5dc32ec66041aeddf432b3146bd2257', '5e3e1475-1ea9-4a6a-976e-b07545827139', 'wangke@t.cn', '18678900987', '1', '3', '2017-07-18 11:40:53', '2018-04-22 20:48:52', null, null);
INSERT INTO `sys_users` VALUES ('4', 'zhangql', '+HBpqtPuj9KLBIpneR5X0A==', 'ed487fac-9952-45c9-acaa-21dab9c689cc', 'zhangql@t.cn', '13678909876', '1', '2', '2017-07-18 12:17:30', '2018-04-22 20:48:04', null, null);
INSERT INTO `sys_users` VALUES ('5', 'fanwei', '1acab7425d6dfae670f26bd160518902', '34fbedb2-e135-4f8d-b595-24360edc348d', 'fanwei@t.cn', '13876545678', '1', '3', '2017-07-20 17:03:22', '2018-04-22 20:47:49', null, null);
INSERT INTO `sys_users` VALUES ('6', 'wumei', '431ebdcccf3404787a144f9ba669a8e2', '8a14f46f-7a17-4dfe-85ab-08e63cb618ce', 'wumei@t.cn', '13567898765', '1', '2', '2017-07-21 10:57:40', '2018-04-22 20:46:49', null, null);
INSERT INTO `sys_users` VALUES ('7', 'user-003', '689c673a0d8bda7ee795dd45a126ae96', '3faa1d2b-a99f-4ffb-9d29-0e71563258af', 't@t.com', '123', '1', '3', '2018-01-12 23:19:58', '2018-04-22 20:46:07', null, 'admin');
INSERT INTO `sys_users` VALUES ('9', 'user-002', 'e10adc3949ba59abbe56e057f20f883e', null, 't@t.com', '123', '1', '3', '2018-01-12 23:20:31', '2018-04-22 20:45:55', null, null);
INSERT INTO `sys_users` VALUES ('12', 'user-001', '5bf6593afd106aa544000d559f0c2241', '9528e727-2901-4746-8558-9010d9607da2', 't@t.com', '123', '1', '3', '2018-01-13 01:48:32', '2018-04-22 20:45:37', null, null);
INSERT INTO `sys_users` VALUES ('13', 'user-c', '2630d8bd50c76abf001a9daceeae97e6', '30fff766-e245-4a93-9f5e-6eb2c2cec494', 't@t.com', '123456', '0', '3', '2018-01-13 02:01:56', '2018-04-22 20:43:58', null, 'admin');
INSERT INTO `sys_users` VALUES ('15', 'user-b', '2ce586af95c6431112092f653659c85f', 'eaedbaee-d760-40e4-b71e-ccecf01b6187', 't@t.com', '123456', '1', '3', '2018-01-13 02:02:06', '2018-04-22 20:54:10', null, 'admin');
INSERT INTO `sys_users` VALUES ('16', 'user-a', '710058cf374a38d76510d009f63bf28d', 'e8e35b96-bbdd-4090-81ee-b71a36141760', '1@t.com', '121212', null, '2', '2018-04-22 19:43:11', '2018-04-22 20:54:02', null, null);
INSERT INTO `sys_users` VALUES ('17', 'Root', '1f0b8a10c67b217b8540e4eafafbe3a3', 'd7a35182-f51e-46dc-b19f-7155b8d95d6b', '', '', '1', null, '2020-04-19 21:24:46', '2020-04-19 21:24:46', 'visitor', 'visitor');
INSERT INTO `sys_users` VALUES ('18', 'Aie', 'a2c853bbe0e29d0079e3acd7ffbee4a3', '22994b25-84c4-4bf2-8fff-1e3624cce65b', '', '', '1', null, '2020-04-19 21:25:01', '2020-04-19 21:25:01', 'visitor', 'visitor');
INSERT INTO `sys_users` VALUES ('19', 'Ben', '09211764dcdd3df0a5605c425964bafd', '9c939ab3-391a-4a0d-9dfd-2fb1d0f4acaa', '', '', '1', null, '2020-04-19 21:25:15', '2020-04-19 21:25:15', 'visitor', 'visitor');
INSERT INTO `sys_users` VALUES ('20', 'Cici', '153d10d05c9e8d02fbda247dd44ce665', '4a050221-5f3f-4bd7-ae2c-05ce02da5a5b', '', '', '1', null, '2020-04-19 21:25:42', '2020-04-19 21:25:42', 'visitor', 'visitor');
INSERT INTO `sys_users` VALUES ('21', 'Davi', '8f949145d6ea373ebb3c8fb3924127bf', '73615072-c2c5-4a67-b110-66947fcf746c', '', '', '1', null, '2020-04-19 21:25:57', '2020-04-19 21:25:57', 'visitor', 'visitor');
INSERT INTO `sys_users` VALUES ('22', 'Eric', '8f949145d6ea373ebb3c8fb3924127bf', '73615072-c2c5-4a67-b110-66947fcf746c', null, null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES ('68', '17', '46');
INSERT INTO `sys_user_roles` VALUES ('69', '17', '47');
INSERT INTO `sys_user_roles` VALUES ('70', '17', '48');
INSERT INTO `sys_user_roles` VALUES ('71', '17', '49');
INSERT INTO `sys_user_roles` VALUES ('72', '18', '46');
INSERT INTO `sys_user_roles` VALUES ('73', '19', '47');
INSERT INTO `sys_user_roles` VALUES ('74', '20', '48');
INSERT INTO `sys_user_roles` VALUES ('75', '21', '49');
