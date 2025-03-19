package com.fallsvc.book.service;

import com.fallsvc.book.dao.BookDao;
import com.fallsvc.book.enums.BookStatusEnum;
import com.fallsvc.book.mapper.BookMapper;
import com.fallsvc.book.model.BookInfo;
import com.fallsvc.book.model.PageRequest;
import com.fallsvc.book.model.ResponseResult;
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
    @Autowired
    private BookMapper bookMapper;
//    public List<BookInfo> getList(){
//        // 未学数据库，mock数据
//        List<BookInfo> list=bookDao.mockData();
//        // 二次处理
//        for (BookInfo bookInfo:list){
//            if(bookInfo.getStatus()==1){
//                bookInfo.setStatusCN("可借阅");
//            }else{
//                bookInfo.setStatusCN("不可借阅");
//            }
//        }
//        return list;
//    }

    public void addBook(BookInfo bookInfo) {
        bookMapper.addBook(bookInfo);
    }

    public ResponseResult<BookInfo> getListByPage(PageRequest pageRequest){
        Integer count= bookMapper.count();
        List<BookInfo> list=bookMapper.selectByPage(pageRequest);

        // 二次处理
        for (BookInfo bookInfo:list){
           bookInfo.setStatusCN(BookStatusEnum.getStatusByCode(bookInfo.getStatus()).getDesc());
        }
        return new ResponseResult<>(count,list,pageRequest);
    }

    public BookInfo queryBookById(Integer bookId) {
       return bookMapper.queryBookById(bookId);
    }

    public void updateBook(BookInfo bookInfo) {
        bookMapper.updateBook(bookInfo);
    }
}
