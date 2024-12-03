package com.sky.annotation;

import com.sky.enumeration.OperationType;//定义的枚举包

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标识某个方法需要进行功能字段的自动填充处理
 */
@Target(ElementType.METHOD)//指定注解只能加在方法上
@Retention(RetentionPolicy.RUNTIME)//定义注解的生命周期
public @interface AutoFill {
    //数据库操作类型,UPDATE,INSERT
    OperationType value();
}
