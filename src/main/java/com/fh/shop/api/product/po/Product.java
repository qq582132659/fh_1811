/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:Product.java 
 * 包名:com.fh.shop.po.product 
 * 创建日期:2019年6月4日下午9:19:16 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.product.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class Product implements Serializable{

	private static final long serialVersionUID = -5636511995112428289L;
	
	private Integer id;
	
	private String productName;
	
	private Float price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;


	private String photoUrl;

	private String typeName;

	private Integer gc1;//用于商品分类  类型1  goods 和 category首字母缩写
	private Integer gc2;//类型2
	private Integer gc3;//类型3

	private Integer sellWell;//是否热销  0为否 1 为热销



	
/*---------------------------------------*/

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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getGc1() {
		return gc1;
	}

	public void setGc1(Integer gc1) {
		this.gc1 = gc1;
	}

	public Integer getGc2() {
		return gc2;
	}

	public void setGc2(Integer gc2) {
		this.gc2 = gc2;
	}

	public Integer getGc3() {
		return gc3;
	}

	public void setGc3(Integer gc3) {
		this.gc3 = gc3;
	}

	public Integer getSellWell() {
		return sellWell;
	}

	public void setSellWell(Integer sellWell) {
		this.sellWell = sellWell;
	}
}
