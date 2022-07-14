package com.example.doublesourse.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weepppp 2022/7/14 13:48
 **/

/**
 * @功能 通过自定义注解去切换请求的数据源
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Ds {
    String value() default "master";
}
