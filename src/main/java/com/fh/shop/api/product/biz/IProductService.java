package com.fh.shop.api.product.biz;

import com.fh.shop.api.product.vo.ProductVo;

import java.util.List;

public interface IProductService {

    /**
     * 普通查询
     * @return
     */
    List<ProductVo> findProductList(Integer sellWell);
}
