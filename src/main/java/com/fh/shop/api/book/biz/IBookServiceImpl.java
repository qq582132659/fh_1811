package com.fh.shop.api.book.biz;

import com.auth0.jwt.internal.org.apache.commons.codec.language.bm.Lang;
import com.fh.shop.api.book.common.ExplainEnum;
import com.fh.shop.api.book.common.PageUtil;
import com.fh.shop.api.book.common.PageVo;
import com.fh.shop.api.book.common.RequestEnum;
import com.fh.shop.api.book.mapper.IBookMapper;
import com.fh.shop.api.book.po.Book;
import com.fh.shop.api.book.vo.BookVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Liu
 * @Date: 2019/7/15 17:56
 * @Description:
 */
@Service("bookService")
public class IBookServiceImpl implements IBookService {

    @Autowired
    private IBookMapper bookMapper;

    @Override
    public RequestEnum addBook(Book book) {
        /*判断图书名不能为空*/
        if(StringUtils.isEmpty(book.getBookName())){
            return RequestEnum.UNITED(ExplainEnum.BOOK_ADD_NAME);
        }
        /*判断价格不能为空*/
        if(book.getPrice() == null){
            return RequestEnum.UNITED(ExplainEnum.BOOK_ADD_PRICE);
        }
        /*新增*/
        bookMapper.addBook(book);
        return RequestEnum.SUCCESS();
    }

    @Override
    public RequestEnum deleteBook(long id) {
        /*删除*/
        bookMapper.deleteBook(id);
        return RequestEnum.SUCCESS();
    }


    @Override
    public RequestEnum toUpdateBookId(long id) {
        Book book = bookMapper.toUpdateBookId(id);
        return RequestEnum.SUCCESS(book);
    }

    @Override
    public RequestEnum updateBook(long id, Book book) {
        book.setId(id);
        bookMapper.updateBook(book);
        return RequestEnum.SUCCESS();
    }

    @Override
    public RequestEnum findPageBook(BookVo bookVo) {
        /*查询总条数*/
        Integer count = bookMapper.findCount(bookVo);
        /*查询数据*/
        List<Book> bookList = bookMapper.findList(bookVo);
        /*bootStrap分页需要的格式转换*/
        PageVo pageVo = PageUtil.DisposePageVo(bookList, count, bookVo.getDraw());
        return RequestEnum.SUCCESS(pageVo);
    }

    @Override
    public RequestEnum deleteBooks(List<Long> list) {
        bookMapper.deleteBooks(list);
        return RequestEnum.SUCCESS();
    }
}
