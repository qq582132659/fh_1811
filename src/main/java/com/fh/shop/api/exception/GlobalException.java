package com.fh.shop.api.exception;

import com.fh.shop.api.common.ResponseEnum;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MyExceltion.class)
    public ServerResponse globalHandler(MyExceltion ex){
        ResponseEnum responseEnum = ex.getResponseEnum();
        return ServerResponse.error(responseEnum);
    }
}
