package com.fh.shop.api.utils;

public class KeyUtil {
    //签名
    public static String buildMemberKey(String memberName,String uuid){
        return "user:"+memberName+":"+uuid;
    }
    //设置手机号在redis做唯一标识
    public static String buildSMSKey(String phone){
        return "userPhone:"+phone;
    }
}
