package com.fallsvc.book.service;

import com.fallsvc.book.dao.BookDao;
import com.fallsvc.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  11:23
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    public List<BookInfo> getList(){
        // 未学数据库，mock数据
        List<BookInfo> list=bookDao.mockData();
        // 二次处理
        for (BookInfo bookInfo:list){
            if(bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return list;
    }
}
