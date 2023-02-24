CREATE TABLE `district`
(
    `id`               varchar(32)   DEFAULT NULL COMMENT '编号',
    `parent_id`        varchar(32)   DEFAULT NULL COMMENT '上级行政区id',
    `city_code`        varchar(500)  DEFAULT NULL COMMENT '城市编码',
    `adcode`           varchar(500)  DEFAULT NULL COMMENT '区域编码',
    `name`             varchar(500)  DEFAULT NULL COMMENT '行政区名称',
    `polyline`         varchar(5000) DEFAULT NULL COMMENT '行政区边界坐标点',
    `center`           varchar(500)  DEFAULT NULL COMMENT '区域中心点',
    `level`            varchar(100)  DEFAULT NULL COMMENT '行政区划级别 country:国家  province:省份（直辖市会在province和city显示） city:市（直辖市会在province和city显示） district:区县 street:街道',
    `create_by`        varchar(50)   DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime      DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50)   DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime      DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255)  DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)    DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='省份区域信息表';
create index index_1 on district (id);
create index index_2 on district (parent_id);
create index index_3 on district (parent_id);
create index index_4 on district (level);
create index index_5 on district (name);