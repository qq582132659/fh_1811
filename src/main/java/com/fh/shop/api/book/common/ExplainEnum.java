package com.fh.shop.api.book.common;

public enum ExplainEnum {

    SUCCESS(200,"成功"),
    USER_NAME_PASSWD_ERROR(202,"用户名或密码不能为空!"),
    USER_NAME_PASSWD(210,"密码不能为空!"),
    USER_NAME_REALNAME(211,"真实姓名不能为空!"),
    USER_AREA(212,"地址不能为空!"),
    USER_CODE(214,"验证码不能为空!"),
    USER_CODE_ERROR(216,"验证码错误"),
    USER_EMAII(217,"邮箱不能为空"),
    USER_CODE_DB(215,"不能重复发送短信"),
    USER_BIRTHDAY(213,"生日不能为空!"),
    USER_NAME(203,"会员名错误"),
    USER_NAME_EXIST(209,"会员名存在"),
    USER_NAME_MISS(222,"会员名不能为空"),
    USER_PASSWD(204,"密码错误"),
    USER_IS_MISS(205,"用户信息不存在"),
    USER_IS_CHANGCE(206,"签名已被更改"),
    USER_DATE_GROW(207,"请重新登录"),
    NAME(201,"重复"),
    SMS_PHONE_NULL(1000,"手机号不能为空"),
    SMS_PHONE_FORMAT(1001,"手机号格式不正确"),
    SMS_PHONE_FORMAT_WYYX(1002,"调用第三方接口错误"),
    BOOK_ADD_NAME(300,"图书名不能为空"),
    BOOK_ADD_PRICE(301,"图书价格不能为空"),
    BOOK_DELETE_ID(302,"请选择要删除的图书ID"),
    ERROR(400,"失败")
    ;

    private Integer code;

    private String massage;

    ExplainEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
