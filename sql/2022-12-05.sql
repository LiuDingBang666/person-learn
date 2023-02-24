-- 轮播图、公告
CREATE TABLE `sys_notice`
(
    `id`               VARCHAR(32)   DEFAULT NULL COMMENT '编号',
    `title`            VARCHAR(32)   DEFAULT NULL COMMENT '标题',
    `content`          text          DEFAULT NULL COMMENT '内容',
    `cover`            VARCHAR(200)  DEFAULT NULL COMMENT '封面',
    `attachment`       VARCHAR(1000) DEFAULT NULL COMMENT '附件,多个已逗号分割',
    `status`           TINYINT       DEFAULT NULL COMMENT '状态： 1=暂存 2=发布 3=禁用',
    `type`             TINYINT       DEFAULT NULL COMMENT '通知类型： 1=轮播图 2=公告',
    `range`            TINYINT       DEFAULT NULL COMMENT '范围: 1=全部 2=个人 3=所有部门 4=指定部门',
    `publish_time`     datetime      DEFAULT NULL COMMENT '发布时间',
    `create_by`        VARCHAR(50)   DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime      DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)   DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime      DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255)  DEFAULT NULL COMMENT '备注信息',
    `del_flag`         TINYINT(4)    DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    KEY `idx_title` (`title`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '通知表';

CREATE TABLE `sys_notice_range`
(
    `id`               VARCHAR(32)  DEFAULT NULL COMMENT '编号',
    `fk_notice_id`     VARCHAR(32)  DEFAULT NULL COMMENT '通知id',
    `fk_user_id`       VARCHAR(200) DEFAULT NULL COMMENT '用户id',
    `fk_dept_id`       VARCHAR(200) DEFAULT NULL COMMENT '部门id',
    `range`            TINYINT      DEFAULT NULL COMMENT '范围: 1=全部 2=个人 3=所有部门 4=指定部门',
    `create_by`        VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
    KEY `idx_notice_id` (`fk_notice_id`),
    KEY `idx_user_id` (`fk_user_id`),
    KEY `idx_dept_id` (`fk_dept_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '通知范围表';


CREATE TABLE `sys_message`
(
    `id`               VARCHAR(32)  DEFAULT NULL COMMENT '编号',
    `fk_target_id`     VARCHAR(32)  DEFAULT NULL COMMENT '主表id',
    `fk_user_id`       VARCHAR(32)  DEFAULT NULL COMMENT '用户id',
    `status`           TINYINT      DEFAULT NULL COMMENT '状态: 1=待查看 2=已查看 3=已处理',
    `type`             VARCHAR(50)  DEFAULT NULL COMMENT '消息类型',
    `create_by`        VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
    KEY `idx_target_id` (`fk_target_id`),
    KEY `idx_user_id` (`fk_user_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '消息表';