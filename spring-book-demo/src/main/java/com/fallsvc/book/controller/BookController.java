package com.fallsvc.book.controller;

import com.fallsvc.book.model.BookInfo;
import com.fallsvc.book.model.PageRequest;
import com.fallsvc.book.model.ResponseResult;
import com.fallsvc.book.service.BookService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/7  11:13
 */
@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
//    @RequestMapping("/getList")
//    public List<BookInfo> getList(){
//
//        return bookService.getList();
//    }


    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        log.info("添加图书，request：{}",bookInfo);
        if(!StringUtils.hasLength(bookInfo.getBookName())
                ||!StringUtils.hasLength(bookInfo.getAuthor())
                ||!StringUtils.hasLength(bookInfo.getPublish())
                ||bookInfo.getCount()==null
                ||bookInfo.getPrice()==null
                ||bookInfo.getStatus()==null
                ) {
            log.error("参数不合法");
            return "参数不合法";
        }
        try{
            bookService.addBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("添加图书异常");
            return "添加图书异常";
        }
    }

    @RequestMapping("/getListByPage")
    public ResponseResult<BookInfo> getListByPage(PageRequest pageRequest){
        ResponseResult<BookInfo> listByPage=bookService.getListByPage(pageRequest);

        return listByPage;
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId){
        log.info("查询图书id："+bookId);
        return bookService.queryBookById(bookId);
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo){
        log.info("修改图书：{}",bookInfo);
        try{
            bookService.updateBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("修改图书错误 e:",e);
            return "修改图书错误";
        }
    }
}
