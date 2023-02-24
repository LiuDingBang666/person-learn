alter table user_wish
    add column is_impl varchar(2) default null comment '该愿望是否被实现 0=未实现 1=已实现 ';
alter table user_wish
    add column is_publish tinyint default null comment '是否公开愿望 0=公开 1=私人';
alter table user_wish
    modify column is_impl tinyint default null comment '该愿望是否被实现 0=未实现 1=已实现 ';
alter table user_wish
    modify column is_selected tinyint default null comment '该愿望是否被选择 0=未被选择 1=被选择';


