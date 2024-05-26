package ioperation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  23:06
 */
public class BorrowBook implements IO{
    @Override
    public void work(BookList bookList) {

        System.out.println("*****借图书*****");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要借书的名字");
        String name=scanner.nextLine();
        //图书是否已经存在
        for (int i = 0; i <bookList.getBookSize() ; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                if(book.getStatus()){ //判断这本书是不是已经被借出
                    System.out.println("已经被借出  ");
                }else{
                    book.setStatus(true);//借出后让图书状态为ture
                    System.out.println("借阅成功");
                }
                return;
            }
        }
        System.out.println("未找到图书 ");
    }
}
