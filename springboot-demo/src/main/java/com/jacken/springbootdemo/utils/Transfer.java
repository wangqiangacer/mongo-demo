package com.jacken.springbootdemo.utils;

public class Transfer implements  Runnable {
    Bank  bank;
    public  Transfer(Bank bank){
        this.bank=bank;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            bank.set();
            System.out.println(Thread.currentThread().getName()+"  "+bank.get());
        }
    }
}
