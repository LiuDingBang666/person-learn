package icu.liuwisdom.admin.utils;

import java.util.Random;

/**
 * 随机生成验证码工具类
 *
 * @param null
 * @author LDB
 * @date 2022-12-09
 * @return null
 **/
public class AuthCodeUtil {
    public static String getCode() {
        return String.valueOf(new Random().nextInt(500000) + 500000);
    }
}
