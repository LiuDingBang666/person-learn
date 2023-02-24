package icu.liuwisdom.utils;

import java.util.UUID;

/**
 * UUID工具类
 * */
public class UidUtils {

    public static String getUUID() {
        String id = UUID.randomUUID().toString();
        String[] split = id.split("-");
        String res = new String();
        for (String s : split) {
            res += s;
        }
        return res;
    }
}
