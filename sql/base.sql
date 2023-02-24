/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : learn

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 07/12/2022 20:03:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for district
-- ----------------------------
DROP TABLE IF EXISTS `district`;
CREATE TABLE `district`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '编号',
    `parent_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '上级行政区id',
    `city_code`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '城市编码',
    `adcode`           varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '区域编码',
    `name`             varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '行政区名称',
    `polyline`         varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区边界坐标点',
    `center`           varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '区域中心点',
    `level`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '行政区划级别 country:国家  province:省份（直辖市会在province和city显示） city:市（直辖市会在province和city显示） district:区县 street:街道',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                 NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                 NULL DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)                                               NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    INDEX `index_1` (`id`) USING BTREE,
    INDEX `index_2` (`parent_id`) USING BTREE,
    INDEX `index_3` (`parent_id`) USING BTREE,
    INDEX `index_4` (`level`) USING BTREE,
    INDEX `index_5` (`name`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '省份区域信息表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '编号',
    `value`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据值',
    `label`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
    `type`             varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
    `description`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
    `sort`             decimal(10, 0)                                          NOT NULL COMMENT '排序（升序）',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统配置表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
    `name`             varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
    `parent_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
    `order_num`        int(11)                                                NULL DEFAULT NULL COMMENT '排序',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                               NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                               NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)                                             NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '机构管理'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '编号',
    `value`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据值',
    `label`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
    `type`             varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
    `description`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
    `sort`             decimal(10, 0)                                          NOT NULL COMMENT '排序（升序）',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '字典表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_file_upload
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_upload`;
CREATE TABLE `sys_file_upload`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '编号',
    `file_name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
    `file_url`         varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件地址',
    `description`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `sort`             decimal(10, 0)                                          NULL DEFAULT NULL COMMENT '排序（升序）',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统文件上传表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '编号',
    `user_name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '用户名',
    `operation`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '用户操作',
    `method`           varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '请求方法',
    `params`           varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
    `time`             bigint(20)                                               NOT NULL COMMENT '执行时长(毫秒)',
    `ip`               varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT 'IP地址',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                 NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                 NULL DEFAULT NULL COMMENT '更新时间',
    `result`           tinyint(4)                                               NULL DEFAULT NULL COMMENT '执行结果 1=执行成功 2=执行失败',
    `error_info`       text CHARACTER SET utf8 COLLATE utf8_general_ci          NULL COMMENT '异常信息',
    `memo`             varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '备注',
    `result_info`      text CHARACTER SET utf8 COLLATE utf8_general_ci          NULL COMMENT '请求结果',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统操作日志'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
    `user_name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `status`           varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）',
    `ip`               varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                               NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                               NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统登录日志'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '编号',
    `name`             varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '菜单名称',
    `parent_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
    `url`              varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)',
    `perms`            varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:alter)',
    `type`             int(11)                                                 NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
    `icon`             varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '菜单图标',
    `order_num`        int(11)                                                 NULL DEFAULT NULL COMMENT '排序',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    `endpoint`         tinyint(1)                                              NULL DEFAULT NULL COMMENT '菜单显示端 0=管理端 1=用户端',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '菜单管理'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '编号',
    `fk_target_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '主表id',
    `fk_user_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '用户id',
    `status`           tinyint(4)                                              NULL DEFAULT NULL COMMENT '状态: 1=待查看 2=已查看 3=已处理',
    `type`             varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '消息类型',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    INDEX `idx_target_id` (`fk_target_id`) USING BTREE,
    INDEX `idx_user_id` (`fk_user_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '消息表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '编号',
    `title`            varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '标题',
    `content`          text CHARACTER SET utf8 COLLATE utf8_general_ci          NULL COMMENT '内容',
    `cover`            varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '封面',
    `attachment`       varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件,多个已逗号分割',
    `status`           tinyint(4)                                               NULL DEFAULT NULL COMMENT '状态： 1=暂存 2=发布 3=禁用',
    `type`             tinyint(4)                                               NULL DEFAULT NULL COMMENT '通知类型： 1=轮播图 2=公告',
    `range`            tinyint(4)                                               NULL DEFAULT NULL COMMENT '范围: 1=全部 2=个人 3=所有部门 4=指定部门',
    `publish_time`     datetime                                                 NULL DEFAULT NULL COMMENT '发布时间',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                 NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                 NULL DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)                                               NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    INDEX `idx_title` (`title`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '通知表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_notice_range
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice_range`;
CREATE TABLE `sys_notice_range`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '编号',
    `fk_notice_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '通知id',
    `fk_user_id`       varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
    `fk_dept_id`       varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门id',
    `range`            tinyint(4)                                              NULL DEFAULT NULL COMMENT '范围: 1=全部 2=个人 3=所有部门 4=指定部门',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    INDEX `idx_notice_id` (`fk_notice_id`) USING BTREE,
    INDEX `idx_user_id` (`fk_user_id`) USING BTREE,
    INDEX `idx_dept_id` (`fk_dept_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '通知范围表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '编号',
    `name`             varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
    `remark`           varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色管理'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
    `role_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
    `dept_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构ID',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                               NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                               NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色机构'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
    `role_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
    `menu_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单ID',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                               NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                               NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色菜单'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '编号',
    `name`             varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '用户名',
    `nick_name`        varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
    `avatar`           varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `password`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `salt`             varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '加密盐',
    `email`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `mobile`           varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
    `status`           tinyint(4)                                              NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
    `dept_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '机构ID',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)                                              NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    `user_type`        tinyint(4)                                              NULL DEFAULT NULL COMMENT '用户类型 0=普通用户 1=管理员',
    UNIQUE INDEX `name` (`name`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户管理'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
    `user_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
    `role_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
    `create_by`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime                                               NULL DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime                                               NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户角色'
  ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
