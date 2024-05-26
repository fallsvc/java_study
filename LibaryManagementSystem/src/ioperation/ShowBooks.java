package ioperation;

import book.Book;
import book.BookList;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  23:05
 */
public class ShowBooks implements IO{
    @Override
    public void work(BookList bookList) {
        System.out.println("Show Books!!!");
        //遍历打印每一本书
        for (int i = 0; i < bookList.getBookSize(); i++) {
            Book book=bookList.getBook(i);
            System.out.println(book);
        }
    }
}
