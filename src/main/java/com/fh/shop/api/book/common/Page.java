package com.fh.shop.api.book.common;

import lombok.Data;

import java.io.Serializable;


@Data
public class Page implements Serializable {

    private static final long serialVersionUID = 7859597990849298982L;

    private Integer draw;

    private Integer start;

    private Integer length;
}
