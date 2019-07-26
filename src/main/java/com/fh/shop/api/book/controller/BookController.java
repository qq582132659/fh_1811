package com.fh.shop.api.book.controller;

import com.fh.shop.api.book.biz.IBookService;
import com.fh.shop.api.book.common.RequestEnum;
import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.vo.BookVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Resource(name = "bookService")
    private IBookService bookService;

    /*新增*/
    @RequestMapping(method = RequestMethod.POST)
    public RequestEnum addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    /*删除*/
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RequestEnum deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
    }

    /*批量删除*/
    @RequestMapping(method = RequestMethod.DELETE)
    public RequestEnum deleteBook(@RequestBody List<Long> ids){
        return bookService.deleteBooks(ids);
    }

    /*回显*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RequestEnum toUpdateBookId(@PathVariable long id){
        return bookService.toUpdateBookId(id);
    }

    /*修改*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RequestEnum updateBook(@PathVariable long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    /*分页条件查询*/
    @RequestMapping(method = RequestMethod.GET)
    public RequestEnum findPageBook(BookVo bookVo){
        return bookService.findPageBook(bookVo);
    }

}
