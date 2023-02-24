package icu.liuwisdom.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 系统通知枚举类
 *
 * @author LDB
 * @version 1.0
 * @date 2022-12-06 21:01
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("all")
public enum SysNoticeEnum {
    SAVE("暂存", 1), PUBLISH("发布", 2), DISABLED("禁用", 3);
    /**
     * 类型
     *
     * @author LDB
     * @date 2022-12-06 21:06
     * @version 1.0
     */
    private String TYPE;
    /**
     * 值
     *
     * @author LDB
     * @date 2022-12-06 21:07
     * @version 1.0
     */
    private Integer VALUE;

    public static SysNoticeEnum getEnumByValue(Integer value) {
        return Arrays.asList(values()).stream().filter(val -> val.getVALUE().equals(value)).findFirst().get();
    }
}
