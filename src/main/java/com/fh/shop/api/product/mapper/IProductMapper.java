package com.fh.shop.api.product.mapper;

import com.fh.shop.api.product.po.Product;

import java.util.List;

public interface IProductMapper {


    /**
     * 普通查询
     * @return
     */
        List<Product> findProductList(Product product);
}
