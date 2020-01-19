package com.jacken.springbootdemo.utils;

public class Test01 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Transfer transfer = new Transfer(bank);
        Thread t1 = new Thread(transfer);
        t1.start();
        Thread t2 = new Thread(transfer);
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
