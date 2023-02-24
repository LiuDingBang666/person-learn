CREATE TABLE `gen_template_group`
(
    `id`                varchar(32)  DEFAULT NULL COMMENT '编号',
    `name`              varchar(50)  DEFAULT NULL COMMENT '模板组名称',
    `type`              varchar(50)  DEFAULT NULL COMMENT '模板组类型',
    `desc`              varchar(500) DEFAULT NULL COMMENT '描述',
    `create_by`         varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`    varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`           varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`          tinyint(4)   DEFAULT '0' COMMENT '是否删除 -1：已删除 0：正常',
    `fk_create_user_Id` varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id` varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    KEY `index_type` (`type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='模板分组信息表';

CREATE TABLE `gen_template`
(
    `id`                       varchar(32)  DEFAULT NULL COMMENT ' 编号 ',
    `fk_gen_template_group_id` varchar(32)  DEFAULT NULL COMMENT ' 模板组id ',
    `name`                     varchar(50)  DEFAULT NULL COMMENT ' 模板名称 ',
    `content`                  varchar(500) DEFAULT NULL COMMENT ' 模板内容 ',
    `desc`                     varchar(500) DEFAULT NULL COMMENT ' 模板描述 ',
    `create_by`                varchar(50)  DEFAULT NULL COMMENT ' 创建人 ',
    `create_time`              datetime     DEFAULT NULL COMMENT ' 创建时间 ',
    `last_update_by`           varchar(50)  DEFAULT NULL COMMENT ' 更新人 ',
    `last_update_time`         datetime     DEFAULT NULL COMMENT ' 更新时间 ',
    `remarks`                  varchar(255) DEFAULT NULL COMMENT ' 备注信息 ',
    `del_flag`                 tinyint(4)   DEFAULT '0 ' COMMENT ' 是否删除 -1：已删除 0：正常 ',
    `fk_create_user_Id`        varchar(32)  DEFAULT NULL COMMENT ' 创建人用户id ',
    `fk_update_user_Id`        varchar(32)  DEFAULT NULL COMMENT ' 修改人用户id ',
    KEY `index_fk_gen_template_group_id` (`fk_gen_template_group_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='模板信息表';

ALTER TABLE gen_template add COLUMN output_prefix VARCHAR(100) DEFAULT NULL COMMENT '生成文件夹';