package com.jacken.springbootdemo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("http://www.baidu.com").get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
