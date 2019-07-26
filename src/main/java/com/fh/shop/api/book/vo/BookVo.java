package com.fh.shop.api.book.vo;

import com.fh.shop.api.common.PageBean;
import lombok.Data;

import java.io.Serializable;


@Data
public class BookVo extends PageBean implements Serializable {

    private static final long serialVersionUID = -6523086444693976227L;

    private String bookName;

    private Float minPrice;

    private Float maxPrice;

}
