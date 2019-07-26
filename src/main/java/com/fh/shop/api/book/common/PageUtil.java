package com.fh.shop.api.book.common;


import java.util.List;

/**
 * @Auther: Liu
 * @Date: 2019/7/15 19:09
 * @Description:
 */
public class PageUtil {

    public static PageVo DisposePageVo(List<?> list, Integer count, Integer draw){
        PageVo pageVo = new PageVo();
        pageVo.setDraw(draw);
        pageVo.setTotalCount(count);
        pageVo.setDataList(list);
        return pageVo;
    }
}
