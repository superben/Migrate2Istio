package com.yofc.common.bean;

public class ValidationException extends Exception implements BaseException{

    public ValidationException(String errMsg, Throwable e) {
        super(errMsg, e);
    }

    public ValidationException(String errMsg) {
        super(errMsg);
    }
}