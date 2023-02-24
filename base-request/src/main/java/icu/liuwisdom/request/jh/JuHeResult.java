package icu.liuwisdom.request.jh;

import lombok.Data;

/**
 * 聚合数据结果
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 15:56
 */
@Data
public class JuHeResult<T> {
    private Integer errorCode;

    private String reason;

    private T result;
}
