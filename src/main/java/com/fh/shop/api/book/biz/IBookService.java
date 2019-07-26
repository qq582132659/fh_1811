package com.fh.shop.api.book.biz;

import com.fh.shop.api.book.common.RequestEnum;
import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.vo.BookVo;

import java.util.List;

/**
 * @Auther: Liu
 * @Date: 2019/7/15 17:55
 * @Description:
 */
public interface IBookService {

    /*新增*/
    RequestEnum addBook(Book book);

    /*删除*/
    RequestEnum deleteBook(long id);

    /*回显*/
    RequestEnum toUpdateBookId(long id);

    /*修改*/
    RequestEnum updateBook(long id, Book book);

    /*分页查询*/
    RequestEnum findPageBook(BookVo bookVo);

    /*批量删除*/
    RequestEnum deleteBooks(List<Long> ids);
}
