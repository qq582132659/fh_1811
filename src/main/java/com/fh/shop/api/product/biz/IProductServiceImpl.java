package com.fh.shop.api.product.biz;

import com.alibaba.fastjson.JSONObject;
import com.fh.shop.api.product.mapper.IProductMapper;
import com.fh.shop.api.product.po.Product;
import com.fh.shop.api.product.vo.ProductVo;
import com.fh.shop.api.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductMapper productMapper;

    /**
     * 普通查询
     * @return
     */
    public List<ProductVo> findProductList(Integer sellWell) {
        Product product = new Product();
        product.setSellWell(sellWell);
        String hotProductList = RedisUtil.get("hotProductList");
        if(null != hotProductList){
            //String转Java
            List<ProductVo> productVoList = JSONObject.parseArray(hotProductList, ProductVo.class);
            return productVoList;
        }
        List<Product> productList = productMapper.findProductList(product);
        //PO转VO
        List<ProductVo> productVoList = convertData(productList);
        //对象转JSON
        RedisUtil.setEx("hotProductList",2*60,JSONObject.toJSONString(productVoList));
        return productVoList;
    }

    private List<ProductVo> convertData(List<Product> productList){
        List<ProductVo> productVoList = new ArrayList<ProductVo>();
        for (Product product : productList) {
            ProductVo productVo = new ProductVo();
            productVo.setId(product.getId());
            productVo.setPhotoUrl(product.getPhotoUrl());
            productVo.setPrice(product.getPrice());
            productVo.setProductName(product.getProductName());
            productVoList.add(productVo);
        }
        return productVoList;
    }
}
