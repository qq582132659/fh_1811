package com.fh.shop.api.memberuser.vo;

import java.io.Serializable;

public class MemberVo  implements Serializable {
    private static final long serialVersionUID = 5395226112627686004L;
    private Integer memberId;
    private String menberName;
    private String trueName;
    private String uuid;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMenberName() {
        return menberName;
    }

    public void setMenberName(String menberName) {
        this.menberName = menberName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
