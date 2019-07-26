package com.fh.shop.api.brand.biz;

import com.fh.shop.api.brand.vo.BrandVo;

import java.util.List;

public interface IBrandService {

    /**
     * 查询推荐品牌
     * @param isRecommend
     * @return
     */
    List<BrandVo>  findBrandList(Integer isRecommend);
}
