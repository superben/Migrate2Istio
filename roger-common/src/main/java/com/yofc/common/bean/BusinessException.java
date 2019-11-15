package com.yofc.common.bean;

public class BusinessException extends Exception implements BaseException{

    public BusinessException(String errMsg, Throwable e) {
        super(errMsg, e);
    }

    public BusinessException(String errMsg) {
        super(errMsg);
    }
}
