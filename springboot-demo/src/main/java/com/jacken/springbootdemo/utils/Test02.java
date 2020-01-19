package com.jacken.springbootdemo.utils;

/**
 * 使用ThreadLocal创建线程变量 相当于一个容器用来存储变量
 */

public class Test02 {
    static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            local.set("你好世界");
            System.out.println(Thread.currentThread().getName());
            method();
        },"t1").start();

        new Thread(()->{
            local.set("你好");
            System.out.println(Thread.currentThread().getName());
            method();
        },"t2").start();


    }

    public static void method(){
        //可以在当前线程的任意地方获取变量
        System.out.println(local.get());
    }

}
