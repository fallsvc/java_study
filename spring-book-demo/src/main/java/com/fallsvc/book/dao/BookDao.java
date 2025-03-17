package com.fallsvc.book.dao;

import com.fallsvc.book.model.BookInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  11:22
 */

@Repository
public class BookDao {

    public List<BookInfo> mockData(){
        List<BookInfo> list=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo=new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setCount(new Random().nextInt(100));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(199)));
            bookInfo.setPublish("出版社"+i);
            bookInfo.setStatus(i%5==0?2:1);// 1可借阅 2不可借阅
            list.add(bookInfo);
        }
        return list;
    }
}
