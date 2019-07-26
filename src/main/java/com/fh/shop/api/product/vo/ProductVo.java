package com.fh.shop.api.product.vo;

import java.io.Serializable;

public class ProductVo implements Serializable {
    private static final long serialVersionUID = 5118489978924172512L;

    private Integer id;
    private String productName;
    private String photoUrl;
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
