package com.yofc.common.bean;

/**
 * Created by roger.
 */
public class MessageJson {

    public final static String SUCCESS = "Success";

    public final static String FAIL = "Fail";

    /**
     * 调用返回的提示信息
     */
    private String msg;

    /**
     * 调用是否成功标识
     */
    private boolean success;

    /**
     * 调用返回的数据对象
     */
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
