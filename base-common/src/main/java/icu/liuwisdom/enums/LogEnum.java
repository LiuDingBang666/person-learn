package icu.liuwisdom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LDB
 * @version 1.0
 * @date 2022-07-23 15:37
 */

@Getter
@AllArgsConstructor
public enum LogEnum {
    SUCCESS("成功", 1L),
    FAIL("失败", 2L);

    /**
     * 键
     *
     * @author LDB
     * @date 2022-07-23 15:39
     * @version 1.0
     */

    private String key;

    /**
     * 值
     *
     * @author LDB
     * @date 2022-07-23 15:40
     * @version 1.0
     */

    private Long value;
}
