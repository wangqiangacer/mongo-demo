package com.jacken.springbootdemo.aop;

import com.jacken.springbootdemo.aop.annos.LimitSendCode;
import com.jacken.springbootdemo.result.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
@Component
@Slf4j
public class LimitSendCodeAop {

    @Autowired
    private StringRedisTemplate redisTemplate;


    private final static String CODE_KEY_PREFIX = "sms:code";


    private Lock lock = new ReentrantLock();

    @Around(value = "@annotation(limitSendCode)&&args(mobileNo))", argNames = "joinPoint,mobileNo,limitSendCode")
    public ResultModel before(ProceedingJoinPoint joinPoint, String mobileNo, LimitSendCode limitSendCode) throws Throwable {

        String key = CODE_KEY_PREFIX + mobileNo + limitSendCode.work();

        try {
            lock.tryLock();
            String val = redisTemplate.opsForValue().get(key);
            if (val == null) {
                redisTemplate.opsForValue().set(key, "Y", limitSendCode.second(), TimeUnit.SECONDS);
            } else {
                log.info("{} send code busy", mobileNo);
                return ResultModel.createFail(1000, "验证码发送频繁,请稍后再试");
            }
        } finally {
            lock.unlock();
        }
        return (ResultModel) joinPoint.proceed();

    }
}
