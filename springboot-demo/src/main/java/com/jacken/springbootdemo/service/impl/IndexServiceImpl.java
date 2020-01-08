package com.jacken.springbootdemo.service.impl;

import com.jacken.springbootdemo.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Override
    @Async
    public String getUserName() {
        try {
            Thread.sleep(3000);
            log.info("异步方法执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    @Async
    public void getTbkGoods() {
        try {
            log.info("同步淘宝商品开始");
            Thread.sleep(3000);
            log.info("同步淘宝商品结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
