package com.fh.shop.api.book.common;


public class RequestEnum {

    private Integer code;

    private String massage;

    private Object data;

    public RequestEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public RequestEnum(Integer code, String massage, Object data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public static RequestEnum SUCCESS(Object data){
        return new RequestEnum(ExplainEnum.SUCCESS.getCode(),ExplainEnum.SUCCESS.getMassage(),data);
    }

    public static RequestEnum SUCCESS(){
        return new RequestEnum(ExplainEnum.SUCCESS.getCode(),ExplainEnum.SUCCESS.getMassage());
    }

    public static RequestEnum ERROR(Object data){
        return new RequestEnum(ExplainEnum.ERROR.getCode(),ExplainEnum.ERROR.getMassage(),data);
    }

    public static RequestEnum ERROR(){
        return new RequestEnum(ExplainEnum.ERROR.getCode(),ExplainEnum.ERROR.getMassage());
    }

    public static RequestEnum UNITED(ExplainEnum explainEnum,Object data){
        return new RequestEnum(explainEnum.getCode(),explainEnum.getMassage(),data);
    }

    public static RequestEnum UNITED(ExplainEnum explainEnum){
        return new RequestEnum(explainEnum.getCode(),explainEnum.getMassage());
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
