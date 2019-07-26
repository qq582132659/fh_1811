package com.fh.shop.api.brand.biz;

import com.fh.shop.api.brand.mapper.IBrandMapper;
import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.brand.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("brandService")
public class IBrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandMapper brandMapper;
    /**
     * 查询推荐品牌
     * @param isRecommend
     * @return
     */
    @Override
    public List<BrandVo>  findBrandList(Integer isRecommend) {
        List<Brand> brandList = brandMapper.findBrandList(isRecommend);
        List<BrandVo> brandVoList = new ArrayList<>();
        //PO转VO
        for (Brand brand : brandList) {
            BrandVo brandVo = new BrandVo();
            brandVo.setBrandId(brand.getBrandId());
            brandVo.setBrandName(brand.getBrandName());
            brandVo.setBrandLogo(brand.getBrandLogo());
            brandVoList.add(brandVo);
        }
        return brandVoList;
    }
}
