package com.jacken.springbootdemo.controller;


import com.jacken.springbootdemo.aop.annos.LimitTime;
import com.jacken.springbootdemo.exception.BaseException;
import com.jacken.springbootdemo.result.ResultModel;
import com.jacken.springbootdemo.service.AsyncTask;
import com.jacken.springbootdemo.service.IndexService;
import com.jacken.springbootdemo.service.SyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 在启动类上加入EnableAsync 开启异步功能
 * 具体执行的方式加上@Async  一般常用在
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private SyncTask syncTask;

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/doAsyncTask")
    public String doAsyncTask() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        long currentTimeMillis1 = System.currentTimeMillis();
        log.info("--------->{}",Thread.currentThread().getName());
        return "异步执行task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";
    }

    @RequestMapping("/doSyncTask")
    public String doSyncTask() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        syncTask.task1();
        syncTask.task2();
        syncTask.task3();
        long currentTimeMillis1 = System.currentTimeMillis();
        log.info("--------->{}",Thread.currentThread().getName());
        return "同步执行task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";

    }
    @RequestMapping("/index")
    @LimitTime
    public  ResultModel<Object> index(){
        //return  indexService.getUserName();
        return ResultModel.createSuccess("方法执行");
    }

    @PostMapping("/home")
    public  String  home(@RequestBody String  name){
        log.info("name---------->",name);
        return "vue 执行post请求";
    }

    @RequestMapping("/getTbkGoods")
    public  void getTbkGoods(){
        indexService.getTbkGoods();
    }

    @RequestMapping("/exception")
    public String hello() throws BaseException {
        throw new BaseException("1000","业务异常，请稍后重试!!!");
    }
}
