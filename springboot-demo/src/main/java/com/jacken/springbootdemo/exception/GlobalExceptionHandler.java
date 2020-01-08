package com.jacken.springbootdemo.exception;

import com.jacken.springbootdemo.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义全局异常处理类 使用 ControllerAdvice
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map defaultErrorHandler(HttpServletRequest req, BaseException e) throws Exception {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", e.getMsg());
        return map;
    }
}
