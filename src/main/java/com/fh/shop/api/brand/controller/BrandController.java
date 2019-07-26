package com.fh.shop.api.brand.controller;

import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.brand.biz.IBrandService;
import com.fh.shop.api.brand.vo.BrandVo;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Resource(name = "brandService")
    private IBrandService brandService;

    /**
     * 查询推荐品牌
     * @param isRecommend
     * @return
     */
    @RequestMapping("getRecommendBrand")
    @ResponseBody
    @Check
    public ServerResponse getRecommendBrand(Integer isRecommend){
        List<BrandVo> brandList = brandService.findBrandList(isRecommend);
        return ServerResponse.success(brandList);
    }

}
