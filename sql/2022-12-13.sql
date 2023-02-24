-- 日记、轮播、公告、愿望
CREATE VIEW home_search AS
SELECT id          id,
       NAME        title,
       content     content,
       images      images,
       create_time create_time,
       '1'         type
FROM user_wish
WHERE del_flag = 0
  AND is_publish = 1
UNION
SELECT id          id,
       title       title,
       content     content,
       cover       images,
       create_time create_time,
       '2'         type
FROM sys_notice
WHERE del_flag = 0
  AND sys_notice.notice_range = 1
  AND sys_notice.type = 1
UNION
SELECT id          id,
       title       title,
       content     content,
       cover       images,
       create_time create_time,
       '3'         type
FROM sys_notice
WHERE del_flag = 0
  AND sys_notice.notice_range = 1
  AND sys_notice.type = 2
UNION
SELECT id          id,
       title       title,
       content     content,
       images      images,
       create_time create_time,
       '4'         type
FROM log_record
WHERE del_flag = 0
  AND is_public = 1