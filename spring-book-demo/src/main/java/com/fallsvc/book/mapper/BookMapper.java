package com.fallsvc.book.mapper;

import com.fallsvc.book.model.BookInfo;
import com.fallsvc.book.model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("select * from book_info where `status` != 0 limit #{offset},#{pageSize}")
    List<BookInfo> selectByPage(PageRequest pageRequest);
    @Select("select count(1) from book_info where `status` != 0")
    Integer count();

    @Select("select * from book_info where id=#{bookId}")
    BookInfo queryBookById(Integer bookId);


    Integer updateBook(BookInfo bookInfo);
}
