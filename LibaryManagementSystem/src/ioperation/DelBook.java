package ioperation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  23:05
 */
public class DelBook implements IO{
    @Override
    public void work(BookList bookList) {
        System.out.println("Delete Book ");
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入您要删除的图书名字");
        String name=scanner.nextLine();

        int i=0;//记录需要删除图书的下标
        //遍历书架
        int currentSize=bookList.getBookSize();
        for (i = 0; i < currentSize; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
               break;
            }
        }
        //判断是否找到图书
        if(i==currentSize){
            System.out.println("未找到图书");
        }
        //后向前赋值遍历书架
        for (int j = i; j < currentSize-1; j++) {
            Book book=bookList.getBook(i+1);//获得下一本书
            bookList.setBook(i,book);//放入i下标位置
        }
        bookList.setBook(currentSize-1,null);//最后一本重复书置为空
        bookList.setBookSize(currentSize-1);//书的数量-1;
    }
}
