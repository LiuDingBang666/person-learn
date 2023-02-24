CREATE TABLE `search_record`
(
    `id`               VARCHAR(32)  DEFAULT NULL COMMENT '编号',
    `fk_user_id`       VARCHAR(32)  DEFAULT NULL COMMENT '用户id',
    `content`          varchar(100) DEFAULT NULL COMMENT '搜索内容',
    `create_by`        VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
    KEY `idx_user_id` (`fk_user_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '搜索记录表';


CREATE TABLE `log_record`
(
    `id`               VARCHAR(32)  DEFAULT NULL COMMENT '编号',
    `fk_user_id`       VARCHAR(32)  DEFAULT NULL COMMENT '用户id',
    `title`            varchar(100) DEFAULT NULL COMMENT '标题',
    `content`          varchar(100) DEFAULT NULL COMMENT '内容',
    `is_public`        tinyint      DEFAULT NULL COMMENT '是否公开 1=是 0=否',
    `images`           varchar(500) DEFAULT NULL COMMENT '图片',
    `create_by`        VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`         TINYINT(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    KEY `idx_user_id` (`fk_user_id`),
    KEY `idx_title` (`title`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '日志记录表';

CREATE TABLE `log_record_message`
(
    `id`               VARCHAR(32)  DEFAULT NULL COMMENT '编号',
    `fk_log_record`    VARCHAR(32)  DEFAULT NULL COMMENT '日志记录id',
    `parent_id`        VARCHAR(32)  DEFAULT NULL COMMENT '上级留言',
    `content`          varchar(100) DEFAULT NULL COMMENT '留言内容',
    `create_by`        VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
    KEY `idx_fk_parent_id` (`parent_id`),
    KEY `idx_fk_log_record` (`fk_log_record`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '日志留言回复表';



CREATE TABLE `user_wish`
(
    `id`               VARCHAR(32)  DEFAULT NULL COMMENT '编号',
    `fk_user_id`       VARCHAR(32)  DEFAULT NULL COMMENT '用户id',
    `name`             varchar(100) DEFAULT NULL COMMENT '愿望名称',
    `content`          varchar(100) DEFAULT NULL COMMENT '愿望内容',
    `images`           varchar(500) DEFAULT NULL COMMENT '描述图片',
    `is_selected`      varchar(500) DEFAULT NULL COMMENT '该愿望是否被选中 0=选中 1=未选中 ',
    `create_by`        VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`         TINYINT(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    KEY `idx_user_id` (`fk_user_id`),
    KEY `idx_idx` (`name`),
    KEY `idx_is_selected` (`is_selected`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '用户愿望表';


CREATE TABLE `user_wish_impl`
(
    `id`               VARCHAR(32)  DEFAULT NULL COMMENT '编号',
    `fk_user_id`       VARCHAR(32)  DEFAULT NULL COMMENT '实现用户id',
    `user_name`        VARCHAR(50)  DEFAULT NULL COMMENT '实现人',
    `fk_wish_id`       VARCHAR(32)  DEFAULT NULL COMMENT '愿望id',
    `desc`             varchar(500) DEFAULT NULL COMMENT '实现描述',
    `create_by`        VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   VARCHAR(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`         TINYINT(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    KEY `idx_user_id` (`fk_user_id`),
    KEY `idx_user_name` (`user_name`),
    KEY `idx_wish_id` (`fk_wish_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT = '愿望实现表';