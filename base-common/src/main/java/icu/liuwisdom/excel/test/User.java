package icu.liuwisdom.excel.test;

import cn.hutool.core.date.DateTime;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-02-17 17:18
 */
@Builder
@Data
public class User {
    // 用户名
    String name;
    // 密码
    String psw;
    // 手机号
    String phone;
    // 出生日期
    Date birthday;
    // 年龄
    Integer age;
    // 余额
    Double banlance;
    // 出生年份
    Integer year;
    // 创建时间
    Date gmtCreate;
    // 是否删除
    Boolean isDeleted;
    // 创建日期
    Date gmtTime;
}
