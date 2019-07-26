package com.fh.shop.api.brand.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Brand implements Serializable {
    private static final long serialVersionUID = -2894040290449337997L;
    private Integer brandId;
    private String brandName;
    @DateTimeFormat(pattern = "yyyy-00-00")
    private Date dateTime;
    private String brandLogo;
    private Integer runking;//排序字段
    private Integer isRecommend;//是否推荐 ==1 推荐 =0 未推荐

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public Integer getRunking() {
        return runking;
    }

    public void setRunking(Integer runking) {
        this.runking = runking;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }
}
