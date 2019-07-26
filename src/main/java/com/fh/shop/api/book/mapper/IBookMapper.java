package com.fh.shop.api.book.mapper;

import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.vo.BookVo;

import java.util.List;


public interface IBookMapper {

    /*新增*/
   void addBook(Book book);

   /*删除*/
    void deleteBook(long id);

    /*回显*/
    Book toUpdateBookId(long id);

    /*修改*/
    void updateBook(Book book);

    /*查询总条数*/
    Integer findCount(BookVo bookVo);

    /*查询数据*/
    List<Book> findList(BookVo bookVo);

    /*批量删除*/
    void deleteBooks(List<Long> list);
}
