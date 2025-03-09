package com.fallsvc.book.controller;

import com.fallsvc.book.model.BookInfo;
import com.fallsvc.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("getList")
    public List<BookInfo> getList(){

        return bookService.getList();
    }

}
