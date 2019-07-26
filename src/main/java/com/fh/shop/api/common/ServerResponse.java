package com.fh.shop.api.common;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    private static final long serialVersionUID = -2851160976712753385L;

    private int code;
    private String msg;
    private Object data;

    //公共的访问方法  无返回数据
    public static ServerResponse success(){
        return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),null);
    }//公共的访问方法  有返回数据
    public static ServerResponse success(Object obj){
        return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),obj);
    }
    //普通异常
    public static ServerResponse error(){
        return new ServerResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg(),null);
    }
    //用户名或密码出现异常
    public static ServerResponse error(ResponseEnum responseEnum){
        return new ServerResponse(responseEnum.getCode(),responseEnum.getMsg(),null);
    }
    //生成私有化构造函数
    private ServerResponse(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
