package com.fallsvc.book.controller;

import com.fallsvc.book.model.BookInfo;
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
    @RequestMapping("/getList")
    public List<BookInfo> getList(){

        return bookService.getList();
    }

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        if(!StringUtils.hasLength(bookInfo.getBookName())
                ||!StringUtils.hasLength(bookInfo.getAuthor())
                ||!StringUtils.hasLength(bookInfo.getPublish())
                ||bookInfo.getCount()==null
                ||bookInfo.getPrice()==null
                ||bookInfo.getStatus()==null
                ) {
            return "参数不合法";
        }
        try{
            bookService.addBook(bookInfo);
            return "";
        }catch (Exception e){
            return "添加图书异常";
        }
    }


}
