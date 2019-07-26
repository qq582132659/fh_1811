package com.fh.shop.api.book.common;

/**
 * @Auther: Liu
 * @Date: 2019/7/13 11:26
 * @Description:
 */
public class ResultSMS {

    private Integer code;

    private String msg;

    private Object obj;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
