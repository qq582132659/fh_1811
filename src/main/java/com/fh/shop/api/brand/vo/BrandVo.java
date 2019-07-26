package com.fh.shop.api.brand.vo;

import java.io.Serializable;

public class BrandVo implements Serializable {
    private static final long serialVersionUID = -5255269301539067990L;
    private Integer brandId;
    private String brandName;
    private String brandLogo;

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

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }
}
