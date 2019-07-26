package com.fh.shop.api.exception;

import com.fh.shop.api.common.ResponseEnum;

public class MyExceltion extends  RuntimeException{
    private ResponseEnum responseEnum;
    //定义构造函数
    public MyExceltion(ResponseEnum responseEnum){
        this.responseEnum = responseEnum;
    }
    //定义get方法
    public ResponseEnum getResponseEnum(){
        return this.responseEnum;
    }
}
