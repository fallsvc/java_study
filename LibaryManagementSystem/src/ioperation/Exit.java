package ioperation;

import book.BookList;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  23:06
 */
public class Exit implements IO{
    @Override
    public void work(BookList bookList) {
        System.out.println("exit Library System");
        System.exit(0);//结束程序 0
    }
}
