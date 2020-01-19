package com.jacken.springbootdemo.utils;

public class Bank {
     ThreadLocal<Integer> t=new ThreadLocal<Integer>(){
         @Override
         protected Integer initialValue() {
             return 100;
         }
     };
     public  int get(){
         return t.get();
     }
     public  void  set(){
         t.set(t.get()+10);
     }
}
