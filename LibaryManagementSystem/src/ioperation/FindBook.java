package ioperation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  23:04
 */
public class FindBook implements IO{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书  ");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你要找到书名 ");
        String name=scanner.nextLine();
        //遍历书架找书
        for (int i = 0; i < bookList.getBookSize(); i++) {
            Book book=bookList.getBook(i);//获得一本书
            if(book.getName().equals(name)){ //找到书
                System.out.println(book); //相当于调用Book重写的toString方法打印
                return;
            }
        }
        System.out.println("未找到  ");
    }
}
