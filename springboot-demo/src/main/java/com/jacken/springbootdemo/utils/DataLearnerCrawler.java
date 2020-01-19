package com.jacken.springbootdemo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DataLearnerCrawler {
    public static void main(String[] args) {

        Document doc = null;
        String url="";
        try {
            for (int i = 0; i < 100; i++) {
                if(i ==0){
                    url="https://duanziwang.com/";
                }
                 url="https://duanziwang.com/"+"page/"+i+1;
                doc = Jsoup.connect(url).get();
                Elements elements = doc.select("div[class=post-content] > pre >code");
                for (Element element : elements) {
                    System.out.println("获取第"+i+"页成功--["+element.html()+"]");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
