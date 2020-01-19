package com.jacken.springbootdemo.aop.annos;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LimitTime {

    /**
     * 限制的时间
     *
     * @return
     */
    int second() default 1;
}
