package com.fh.shop.api.common;

public enum ResponseEnum {
    SUCCESS(200,"success"),
    USERNAME_PASSWORD(10002,"用户名或密码为空"),
    USERNAME_ERROR(10003,"用户名错误"),
    PASSWORD_ERROR(10004,"密码错误"),
    HERDLER_ERROR(2000,"头信息错误"),
    HERDLER_ISNULL(2001,"头信息不存在"),
	LOGIN_COOKIE_DIE(20001,"cookie超时"),
    SMS_PHONE_IS_NULL(2002,"手机号不能为空"),
    SMS_PHONE_LENGTH_ERROR(2002,"手机号码长度不正确"),
    SMS_REPEAT_SEND(2003,"不能重复发送"),
    SMS_FORMAT_ERROR(2004,"请输入正确号码"),
    SMS_CODE_ERROR(2005,"网易云信平台失败"),
    SMS_CODE_IS_NULL(2006,"验证码不能为空"),
    SMS_CODE_MISTAKE(2007,"验证码输入有误"),
    SMS_CODE_TIME_OUT(2008,"验证码超时"),
    ERROR(500,"error"),;

    private int code;
    private String msg;

    //生成私有构造函数
    private ResponseEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
