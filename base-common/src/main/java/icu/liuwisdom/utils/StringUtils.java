package icu.liuwisdom.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author Louis
 * @date Sep 1, 2018
 */
public class StringUtils {

    /**
     * 判空操作
     *
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }

    /**
     * 字符串转列表
     *
     * @param str
     * @return java.util.List<java.lang.String>
     * @author LDB
     * @date 2023-01-27
     **/
    public static List<String> strToList(String str) {
        return Arrays.asList(str.split(","));
    }
}
