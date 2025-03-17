package com.fallsvc.book.mapper;

import com.fallsvc.book.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/16  23:52
 */
@Mapper
public interface BookMapper {
    @Insert("insert into book_info (book_name,author,count,price,publish,status)" +
            "values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer addBook(BookInfo bookInfo);
}
