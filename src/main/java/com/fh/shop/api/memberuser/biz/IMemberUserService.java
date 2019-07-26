package com.fh.shop.api.memberuser.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.memberuser.po.MemberUser;

public interface IMemberUserService {
    /**
     * 会员注册
     * @param memberUser
     */
    ServerResponse addMenberUser(MemberUser memberUser);

    MemberUser getUser(String userName);

    /**
     * 登陆验证
     * @param memberUser
     * @return
     */
    ServerResponse login(MemberUser memberUser);

    /**
     * 查询用户名唯一
     * @param userName
     */
    ServerResponse queryUserName(String userName);

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    ServerResponse saedCode(String phone);
}
