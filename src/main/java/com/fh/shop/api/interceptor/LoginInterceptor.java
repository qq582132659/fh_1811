package com.fh.shop.api.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.common.ConstantResponse;
import com.fh.shop.api.common.ResponseEnum;
import com.fh.shop.api.exception.MyExceltion;
import com.fh.shop.api.memberuser.vo.MemberVo;
import com.fh.shop.api.utils.KeyUtil;
import com.fh.shop.api.utils.Md5Util;
import com.fh.shop.api.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Base64;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 自定义拦截器 {@code true}.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        /*//处理跨域
        //设置IP
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"*");
        //设置请求方式
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,"GET,POST,DELETE,PUT,OPTIONS");
        //设置参数
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,"Content-Type,x-auth");
        //处理options请求方式
        String methodTpe = request.getMethod();
        //如果请求方式位OPTIONS就拦截
        if(methodTpe.equals("OPTIONS")){
            return false;
        }
        //判断哪些方法拦截哪些比拦截
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //判断方法是否使用执行注解  //如果使用该注解就进行拦截
        if(!method.isAnnotationPresent(Check.class)){
            return true;
        }
        //获取头信息
        String header = request.getHeader("x-auth");
        if(StringUtils.isEmpty(header)||header.equals("undefined")){
            throw new MyExceltion(ResponseEnum.HERDLER_ISNULL);
        }
        //转译
        String[] split = header.split("\\.");
        String memberUserbase64 = split[0];
        String signBase64 = split[1];
        String newmember = Md5Util.md5(memberUserbase64 + ConstantResponse.SECRET_KEY);
        String newMenberJsonBase64 = Base64.getEncoder().encodeToString(newmember.getBytes());
        //验签
        if(!signBase64.equals(newMenberJsonBase64)){
            throw new MyExceltion(ResponseEnum.HERDLER_ERROR);
        }
        //转换格式
        byte[] decode = Base64.getDecoder().decode(memberUserbase64);
        String memberStr = new String(decode);
        MemberVo memberVos = JSONObject.parseObject(memberStr, MemberVo.class);
        //返回
        request.setAttribute("memberVo",memberVos);*/
        //处理跨域请求
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"*");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,"GET,PUT,DELETE,POST,OPTIONS");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,"Content-Type,x-auth");
        //处理options请求方式
        String methodType = request.getMethod();
        if(methodType.equalsIgnoreCase("OPTIONS")){
            return false;
        }
        //判断哪些方法需要进行拦截
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //获取方法
        Method method = handlerMethod.getMethod();
        //判断方法是否含有指定注解
        if(!method.isAnnotationPresent(Check.class)){
            return true;
        }
        //获取签名
        String header = request.getHeader("x-auth");
        //判断签名是否为空
        if(StringUtils.isEmpty(header)){
            throw new MyExceltion(ResponseEnum.HERDLER_ISNULL);
        }
        //验签 因为 . 是特殊字符所以要进行转译
        String[] split = header.split("\\.");
        //我们知道分割出来0坐标是会员信息 1坐标是签名 所以直接进行判断
        String menberJsonBase64 = split[0];
        String signBase64 = split[1];
        //进行签名判断
        String newSignMd5 = Md5Util.md5(menberJsonBase64, ConstantResponse.SECRET_KEY);
        //进行base64编码
        String newSignBase64 = Base64.getEncoder().encodeToString(newSignMd5.getBytes());
        if(!newSignBase64.equalsIgnoreCase(signBase64)){
            throw new MyExceltion(ResponseEnum.HERDLER_ERROR);
        }
        //转换类型
        byte[] decode = Base64.getDecoder().decode(menberJsonBase64);
        String menberByte = new String(decode);
        //将字符串转换为对应的java对象
        MemberVo memberVo = JSONObject.parseObject(menberByte, MemberVo.class);
		//判断指定key是否存在 KeyUtil.buildMemberKey(memberVo.getMenberName(), memberVo.getUuid())
        boolean exists = RedisUtil.exists(KeyUtil.buildMemberKey(memberVo.getMenberName(),memberVo.getUuid()));
        //加个非 取反 当不存在时
        if(!exists){
            throw new MyExceltion(ResponseEnum.LOGIN_COOKIE_DIE);
        }
        //当,前面验证都通过时 给cookid续命 KeyUtil.buildMemberKey(memberVo.getMenberName(), memberVo.getUuid()),ConstantResponse.LOGIN_USER_LIFECYCLE
        RedisUtil.expire(KeyUtil.buildMemberKey(memberVo.getMenberName(),memberVo.getUuid()),ConstantResponse.LOGIN_USER_LIFECYCLE);
        //通过request将数据放到控制层方法里
        request.setAttribute(ConstantResponse.REQUEST_MEMBERVO,memberVo);
        return true;
    }
}
