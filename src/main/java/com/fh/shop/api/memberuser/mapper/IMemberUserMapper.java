package com.fh.shop.api.memberuser.mapper;

import com.fh.shop.api.memberuser.po.MemberUser;

public interface IMemberUserMapper {

    /**
     * 会员注册
     * @param memberUser
     */
    void addMenberUser(MemberUser memberUser);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    MemberUser getUser(String userName);

    /**
     * 查询用户名唯一
     * @param userName
     */
    MemberUser queryUserName(String userName);
}
