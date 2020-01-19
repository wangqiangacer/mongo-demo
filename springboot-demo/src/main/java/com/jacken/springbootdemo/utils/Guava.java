package com.jacken.springbootdemo.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;

public class Guava {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList();
//        list.add("xiaoming");
////        list.add("xiaohong");
////        list.stream().forEach(s -> System.out.println(s));
        //创建一个不可变的集合
        ImmutableList<String> list1 = ImmutableList.of("1", "2", "3");
    }
}
