package ioperation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  23:07
 */
public class ReturnBook implements IO{
    @Override
    public void work(BookList bookList) {
        System.out.println("Return Book  ");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要还的书名 ");
        String name=scanner.nextLine();
        //遍历书架找对应图书
        for (int i = 0; i < bookList.getBookSize(); i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setStatus(false);//归还图书，状态设为false（未借出）
                return;
            }
        }
        System.out.println("没有您要归还的图书  ");
    }
}
