package com.fh.shop.api.book.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Liu
 * @Date: 2019/7/15 19:07
 * @Description:
 */
@Data
public class PageVo implements Serializable {

    private static final long serialVersionUID = -7148089636574534470L;

    private Integer draw;

    private Integer totalCount;

    private List<?> dataList;
}
