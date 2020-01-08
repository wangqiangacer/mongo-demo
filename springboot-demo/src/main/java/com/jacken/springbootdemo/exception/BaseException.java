package com.jacken.springbootdemo.exception;

public class BaseException extends RuntimeException {
    private String code;
    private String msg;

    public BaseException(String message, String code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
