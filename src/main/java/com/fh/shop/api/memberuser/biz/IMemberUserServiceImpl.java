package com.fh.shop.api.memberuser.biz;

import com.alibaba.fastjson.JSONObject;
import com.fh.shop.api.common.ConstantResponse;
import com.fh.shop.api.common.ResponseEnum;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.common.SmsResponse;
import com.fh.shop.api.memberuser.mapper.IMemberUserMapper;
import com.fh.shop.api.memberuser.po.MemberUser;
import com.fh.shop.api.memberuser.vo.MemberVo;
import com.fh.shop.api.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("memberUserService")
public class IMemberUserServiceImpl implements IMemberUserService {
    @Autowired
    private IMemberUserMapper memberUserMapper;
    @Value("${sms.url}")
    private String url;
    @Value("${sms.mobile}")
    private String mobile;
    @Value("${sms.templateid}")
    private String templateid;
    @Value("${sms.AppKey}")
    private String appKey;
    @Value("${sms.AppSecret}")
    private String appSecret;

    /**
     * 会员注册
     * @param memberUser
     */
    public ServerResponse addMenberUser(MemberUser memberUser) {
        //判断验证码不为空
        if(null == memberUser.getCode()){
            return ServerResponse.error(ResponseEnum.SMS_CODE_IS_NULL);
        }
        //验证验证码是否正确
        String code = RedisUtil.get(KeyUtil.buildSMSKey(memberUser.getPhoneNum()));
        if(!code.equalsIgnoreCase(memberUser.getCode())){
            return ServerResponse.error(ResponseEnum.SMS_CODE_MISTAKE);
        }
        //验证是否过期
        boolean exists = RedisUtil.exists(KeyUtil.buildSMSKey(memberUser.getPhoneNum()));
        if(!exists){
            return ServerResponse.error(ResponseEnum.SMS_CODE_TIME_OUT);
        }
        memberUserMapper.addMenberUser(memberUser);
        return ServerResponse.success();
    }

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    public MemberUser getUser(String userName) {
        return memberUserMapper.getUser(userName);
    }


    /**
     * 登陆验证
     * @param memberUser
     * @return
     */
    @Override
    public ServerResponse login(MemberUser memberUser) {
        String memberName = memberUser.getUserName();
        String password = memberUser.getUserPwd();
        //判断用户名密码是否为空
        if(memberName == null || password == null){
            return ServerResponse.error(ResponseEnum.USERNAME_PASSWORD);
        }
        //判断用户名是否存在
        MemberUser user = getUser(memberName);
        if(user == null){
            return ServerResponse.error(ResponseEnum.USERNAME_ERROR);
        }
        //判断密码是否正确
        if(!password.equals(user.getUserPwd())){
            return ServerResponse.error(ResponseEnum.PASSWORD_ERROR);
        }
        //PO转VO
        MemberVo memberVo = new MemberVo();
        memberVo.setMemberId(user.getId());
        memberVo.setMenberName(user.getUserName());
        memberVo.setTrueName(user.getTrueName());
        //设置UUID
        String userUUID =UUID.randomUUID().toString().replace("-","");
        memberVo.setUuid(userUUID);
        //将VO信息转化为json格式
        String memberJson = JSONObject.toJSONString(memberVo);
        //将用户VO信息进行64位编码
        String memberBase64 = Base64.getEncoder().encodeToString(memberJson.getBytes());
        //将用户VO信息和密钥进行加密生成签名
        String sign = Md5Util.md5(memberBase64, ConstantResponse.SECRET_KEY);
        //将签名转换为json
        //String signJson = JSONObject.toJSONString(sign);
        //将签名进行base64编码
        String signBase64 = Base64.getEncoder().encodeToString(sign.getBytes());
		//设置cookid生存时间  因为工具类必须要有value所以就随便设置一个 这个value没用
        RedisUtil.setEx(KeyUtil.buildMemberKey(user.getUserName(),userUUID),ConstantResponse.LOGIN_USER_LIFECYCLE,"1");
        //将用户Vo信息和base64位编码返回前台
        return ServerResponse.success(memberBase64+"."+ signBase64);
    }

    /**
     * 查询用户名唯一
     * @param userName
     */
    @Override
    public ServerResponse queryUserName(String userName) {
        MemberUser memberUser = memberUserMapper.queryUserName(userName);
        if(memberUser == null){
            return ServerResponse.success();
        }
        return ServerResponse.success(1100);
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @Override
    public ServerResponse saedCode(String phone) {
        //判断是否为空
        if(StringUtils.isEmpty(phone)){
            return ServerResponse.error(ResponseEnum.SMS_PHONE_IS_NULL);
        }
        //判断手机号码长度为11
        if(phone.length() != ConstantResponse.PHONE_LENGTH){
            return ServerResponse.error(ResponseEnum.SMS_PHONE_LENGTH_ERROR);
        }
        //判断为数字
        if(!phone.matches("^((15[0-9])|(18[0-9]))\\d{8}$")){
            return ServerResponse.error(ResponseEnum.SMS_FORMAT_ERROR);
        }
        //判断redis里有没有指定key
        boolean exists = RedisUtil.exists(KeyUtil.buildSMSKey(phone));
        if(exists){
            return ServerResponse.error(ResponseEnum.SMS_REPEAT_SEND);
        }
        //开始调用远程接口
        //准备普通参数
        Map<String,String> params = new HashMap<>();
        params.put("mobile",mobile);
        params.put("templateid",templateid);
        //准备头信息
        Map<String,String> headers = new HashMap<>();
        headers.put("AppKey",appKey);
        String uuidInfo = UUID.randomUUID().toString()+"";
        headers.put("Nonce",uuidInfo);
        String time = new Date().getTime() + "";
        headers.put("CurTime",time);
        headers.put("CheckSum",Sha1Util.getCheckSum(appSecret,uuidInfo,time));
        String str = HttpClientUtil.httpPost(url, params, headers);
        //将获取的响应内容转换为指定的java对象
        SmsResponse smsResponse = JSONObject.parseObject(str, SmsResponse.class);
        Integer code = smsResponse.getCode();
        //判断是否执行成功
        if(code != 200){
            return ServerResponse.error(ResponseEnum.SMS_CODE_ERROR);
        }
        //成功后将验证码放入Redis中并设定声明周期
        String obj = smsResponse.getObj();
        RedisUtil.setEx(KeyUtil.buildSMSKey(phone),60,obj);
        return ServerResponse.success();
    }
}
