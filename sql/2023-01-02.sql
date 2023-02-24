# 商城表
CREATE TABLE `mall_product`
(
    `id`                  varchar(32)    NOT NULL COMMENT '编号',
    `fk_dept_id`          varchar(32)    NOT NULL COMMENT '部门id',
    `dept_name`           varchar(32)    NOT NULL COMMENT '部门名称',
    `name`                varchar(50)    NOT NULL COMMENT '产品名称',
    `inventory`           int            NOT NULL COMMENT '库存',
    `status`              tinyint        NOT NULL COMMENT '状态 0=已上架 1=已下架 2=已售馨',
    `price`               decimal(5, 2)  NOT NULL COMMENT '价格（元）',
    `is_credits_exchange` tinyint        NOT NULL COMMENT '是否可用积分兑换 0=不可用 1=可用',
    `cover`               varchar(100)   NOT NULL COMMENT '产品封面',
    `fk_type_id`          varchar(32)    NOT NULL COMMENT '产品分类id',
    `type_name`           varchar(50)    NOT NULL COMMENT '产品分类名称',
    `description`         varchar(500)   NOT NULL COMMENT '产品描述',
    `sort`                decimal(10, 0) NOT NULL COMMENT '排序（升序）',
    `create_by`           varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`         datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`      varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`             varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`            tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id`   varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id`   varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 产品信息';
create index idx_fk_dept_id on mall_product (fk_dept_id);
create index idx_fk_type_id on mall_product (fk_type_id);
alter table mall_product modify price decimal(7, 2)  NOT NULL COMMENT '价格（元）';
CREATE TABLE `mall_product_activity`
(
    `id`                  varchar(32)    NOT NULL COMMENT '编号',
    `fk_product_id`       varchar(32)    NOT NULL COMMENT '商品id',
    `name`                varchar(500)   NOT NULL COMMENT '活动名称',
    `cover`               varchar(100)   NOT NULL COMMENT '活动封面',
    `description`         varchar(500)   NOT NULL COMMENT '活动描述',
    `status`              tinyint        NOT NULL COMMENT '状态 0=未开始 1=进行中 2=已结束',
    `nums`                varchar(100)   NOT NULL COMMENT '活动商品数量',
    `inventory`           int            NOT NULL COMMENT '当前库存',
    `price`               decimal(5, 2)  NOT NULL COMMENT '原价格（元）',
    `discount_price`      decimal(5, 2)  NOT NULL COMMENT '折扣价格（元）',
    `discount_unit`       tinyint        NOT NULL COMMENT '折扣',
    `is_credits_exchange` tinyint        NOT NULL COMMENT '是否可用积分兑换 0=不可用 1=可用',
    `start_time`          datetime       NOT NULL COMMENT '活动开始时间',
    `end_time`            datetime       NOT NULL COMMENT '活动结束时间',
    `sort`                decimal(10, 0) NOT NULL COMMENT '排序（升序）',
    `create_by`           varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`         datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`      varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`             varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`            tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id`   varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id`   varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 产品活动';
create index idx_fk_product_id on mall_product_activity (fk_product_id);
alter table mall_product_activity modify `nums`  int   NOT NULL COMMENT '活动商品数量';
CREATE TABLE `mall_order`
(
    `id`                varchar(32)    NOT NULL COMMENT '编号',
    `fk_user_id`        varchar(32)    NOT NULL COMMENT '用户id',
    `status`            tinyint        NOT NULL COMMENT '订单状态 0=待支付 1=已取消 2=已支付 3=已收货 4=已退款',
    `type`              tinyint        NOT NULL COMMENT '订单类型 0=积分订单 1=余额订单',
    `pay_type`          tinyint        NOT NULL COMMENT '支付方式 0=系统内部 1=微信 2=支付宝 3=信用卡 4=其他',
    `consignee`         varchar(100)   NOT NULL COMMENT '收货人',
    `phone`             varchar(100)   NOT NULL COMMENT '收货人手机号',
    `address`           varchar(100)   NOT NULL COMMENT '收货地址',
    `total`             decimal(10, 0) NOT NULL COMMENT '总金额',
    `create_by`         varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`    varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`           varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`          tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id` varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id` varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 订单信息';
create index idx_fk_user_id on mall_order (fk_user_id);

CREATE TABLE `mall_order_process`
(
    `id`                varchar(32) NOT NULL COMMENT '编号',
    `fk_order_id`       varchar(32) NOT NULL COMMENT '订单id',
    `status`            tinyint     NOT NULL COMMENT '订单状态 0=待支付 1=已取消 2=已支付 3=已收货 4=已退款',
    `name`              varchar(50)  DEFAULT NULL COMMENT '进展名称',
    `create_by`         varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`    varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`           varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`          tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id` varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id` varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 订单进展信息';
create index idx_fk_order_id on mall_order_process (fk_order_id);

CREATE TABLE `mall_product_order`
(
    `id`                varchar(32)    NOT NULL COMMENT '编号',
    `fk_order_id`       varchar(32)    NOT NULL COMMENT '订单id',
    `fk_product_id`     varchar(32)    NOT NULL COMMENT '商品id',
    `nums`              int            NOT NULL COMMENT '购买数量',
    `total`             decimal(10, 0) NOT NULL COMMENT '单笔总金额',
    `create_by`         varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`    varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`           varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`          tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id` varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id` varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 订单商品关联信息';
create index idx_fk_order_id on mall_product_order (fk_order_id);
create index idx_fk_product_id on mall_product_order (fk_product_id);


CREATE TABLE `mall_product_type`
(
    `id`                varchar(32)    NOT NULL COMMENT '编号',
    `fk_dept_id`        varchar(32)    NOT NULL COMMENT '部门id',
    `dept_name`         varchar(100)   NOT NULL COMMENT '部门名称',
    `parent_id`         varchar(32)    NOT NULL COMMENT '上级分类id',
    `description`       varchar(500)   NOT NULL COMMENT '描述',
    `sort`              decimal(10, 0) NOT NULL COMMENT '排序（升序）',
    `create_by`         varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`    varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`           varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`          tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id` varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id` varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 分类信息';
create index idx_fk_dept_id on mall_product_type (fk_dept_id);
create index idx_parent_id on mall_product_type (parent_id);
alter table mall_product_type add column  name varchar(50) DEFAULT NULL COMMENT '名称';

CREATE TABLE `mall_user_balance`
(
    `id`                varchar(32)    NOT NULL COMMENT '编号',
    `fk_user_id`        varchar(32)    NOT NULL COMMENT '用户id',
    `user_name`         varchar(100)   NOT NULL COMMENT '用户名称',
    `balance`           decimal(10, 0) NOT NULL COMMENT '余额',
    `type`              tinyint        NOT NULL COMMENT '余额类型 0=积分 1=余额',
    `create_by`         varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`    varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`           varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`          tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id` varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id` varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 用户余额信息';
create index idx_fk_user_id on mall_user_balance (fk_user_id);

CREATE TABLE `mall_user_balance_water`
(
    `id`                varchar(32)    NOT NULL COMMENT '编号',
    `fk_user_id`        varchar(32)    NOT NULL COMMENT '用户id',
    `water_date`        date           NOT NULL COMMENT '时间',
    `balance`           decimal(10, 0) NOT NULL COMMENT '余额',
    `type`              tinyint        NOT NULL COMMENT '余额类型 0=积分 1=余额',
    `water_type`        tinyint        NOT NULL COMMENT '流水类型 0=充值 1=扣除',
    `recharge_type`     tinyint        NOT NULL COMMENT '充值方式 0=系统内部 1=微信 2=支付宝 3=信用卡 4=其他',
    `create_by`         varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`    varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`           varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`          tinyint(4)   DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
    `fk_create_user_Id` varchar(32)  DEFAULT NULL COMMENT '创建人用户id',
    `fk_update_user_Id` varchar(32)  DEFAULT NULL COMMENT '修改人用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='商城 用户余额流水信息';
create index idx_fk_user_id on mall_user_balance_water (fk_user_id);