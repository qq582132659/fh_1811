package com.fh.shop.api.memberuser.controller;

import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.common.ConstantResponse;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.memberuser.biz.IMemberUserService;
import com.fh.shop.api.memberuser.po.MemberUser;
import com.fh.shop.api.memberuser.vo.MemberVo;
import com.fh.shop.api.utils.KeyUtil;
import com.fh.shop.api.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/memberUser")
public class MemberUserController {
    @Resource(name = "memberUserService")
    private IMemberUserService memberUserService;
    @Autowired
    private HttpServletRequest request;
    /**
     * 会员注册
     * @param memberUser
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ServerResponse addMenberUser(MemberUser memberUser){
             memberUserService.addMenberUser(memberUser);
        return ServerResponse.success();
    }

    /**
     * 根据用户名 查询
     * @return
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public ServerResponse getUser(MemberUser memberUser){
        ServerResponse login = memberUserService.login(memberUser);
        return login;
    }

    /**
     * 获取会员信息
     * @return
     */
    @RequestMapping(value = "/getMember",method = RequestMethod.GET)
    @Check
    public ServerResponse getMember(){
        MemberVo memberVo = (MemberVo) request.getAttribute("memberVo");
        return ServerResponse.success(memberVo);
    }

    /**
     * 验证用户名唯一
     * @return
     */
    @RequestMapping(value = "/queryUserName",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse queryUserName(String userName){
        return memberUserService.queryUserName(userName);
    }
	 /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @Check
    public ServerResponse logout(){
        MemberVo memberVo = (MemberVo) request.getAttribute(ConstantResponse.REQUEST_MEMBERVO);
        RedisUtil.del(KeyUtil.buildMemberKey(memberVo.getMenberName(),memberVo.getUuid()));
        return ServerResponse.success();
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/saedCode",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse saedCode(String phone){
        return memberUserService.saedCode(phone);
    }

}
