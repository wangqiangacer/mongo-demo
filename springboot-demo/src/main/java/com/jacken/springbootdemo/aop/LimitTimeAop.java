package com.jacken.springbootdemo.aop;


import com.jacken.springbootdemo.aop.annos.LimitTime;
import com.jacken.springbootdemo.result.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
@Component
@Slf4j
public class LimitTimeAop {


    @Autowired
    private StringRedisTemplate redisTemplate;
    private final static String LIMIT_NAME = "sale:limit:";
    private Lock lock = new ReentrantLock();
    /**
     * 环绕通知才能获取ProceedingJoinPoint
     * 前置通知(在访问前判断该用户是否刚刚才提交)
     */
    @Around(value = "@annotation(limitTime)", argNames = "joinPoint,limitTime")
    public ResultModel before(ProceedingJoinPoint joinPoint, LimitTime limitTime) throws Throwable {
        String uri = getUri();
        String name = joinPoint.getTarget().getClass().getName();
        log.info("name---{}",name);
        try {
            lock.tryLock();
            String key = LIMIT_NAME + uri ;
            String value = redisTemplate.opsForValue().get(key);
            if (value == null) {
                redisTemplate.opsForValue().set(key, "Y", limitTime.second(), TimeUnit.SECONDS);
            } else {
                return ResultModel.createFail(1000, "访问接口过快,请稍后再试");
            }
        } catch (Exception e) {
            log.info("lock throw exception");
            e.printStackTrace();
            return ResultModel.createFail(1000, "请稍后再试");
        } finally {
            lock.unlock();
        }

        return (ResultModel) joinPoint.proceed();

    }

    /**
     * 获取用户token
     *
     * @return token
     */
    public String getToken() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String token = request.getHeader("Token");
        if (StringUtils.isBlank(token)) {
            token = request.getParameter("Token");
        }

        return token;
    }


    /**
     * 获取请求的地址
     *
     * @return
     */
    public String getUri() {

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        return request.getRequestURI();
    }
}
