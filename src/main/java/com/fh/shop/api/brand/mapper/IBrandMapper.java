package com.fh.shop.api.brand.mapper;

import com.fh.shop.api.brand.po.Brand;

import java.util.List;

public interface IBrandMapper {

    /**
     * 查询推荐品牌
     * @param isRecommend
     * @return
     */
    List<Brand> findBrandList(Integer isRecommend);
}
