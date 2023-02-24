package icu.liuwisdom.admin.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @author LDB
 * @date 2022-07-23
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 用户操作
     *
     * @author LDB
     * @date 2022-07-23 12:00
     * @version 1.0
     */
    String operation() default "";

    /**
     * 备注
     *
     * @author LDB
     * @date 2022-07-23 14:41
     * @version 1.0
     */
    String memo() default "";
}
