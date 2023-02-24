package icu.liuwisdom.business.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品枚举
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-27 15:07
 */
@Getter
@AllArgsConstructor
public enum ProductEnum {

    Gallery("已上架", 0),

    SOLD_OUT("已下架", 1),

    SOLD_FLOWERS("已售馨", 2);

    private String name;

    private Integer value;
}
