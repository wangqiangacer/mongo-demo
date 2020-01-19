package com.jacken.springbootdemo.aop.annos;

import java.lang.annotation.*;

/**
 * 限制发送验证码注释
 * @author 江勇
 * @date 2019/12/6
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LimitSendCode {

    /**
     * 默认60s
     */
    int second() default 60;


    /**
     * 类型 "boss-login","login-or-register"
     */
    String work() default "index";
}
