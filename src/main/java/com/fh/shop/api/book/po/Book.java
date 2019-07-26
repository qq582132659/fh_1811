package com.fh.shop.api.book.po;

import lombok.Data;

import java.io.Serializable;


@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 6242045627176603126L;

    private Long id;

    private String bookName;

    private Float price;
}
