alter table sys_log
    add column result tinyint default null comment '执行结果 1=执行成功 2=执行失败';
alter table sys_log
    add column error_info varchar(500) default null comment '异常信息';
alter table sys_log
    add column memo varchar(500) default null comment '备注';
alter table sys_log
    add column result_info varchar(5000) default null comment '请求结果';