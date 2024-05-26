package ioperation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  23:04
 */
public class AddBook implements IO{
    @Override
    public void work(BookList bookList) {
        //判满
        int currentSize=bookList.getBookSize();//获得已经存放书的本数
        //bookList.getBooks().length书架的最大容量
        if(currentSize==bookList.getBooks().length){
            System.out.println("书架满了不能放书");
            return;
        }

        System.out.println("*****新增图书*****");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要添加书的名字");
        String name=scanner.nextLine();
        //图书是否已经存在
        for (int i = 0; i < currentSize; i++) {
            Book book=bookList.getBook(i);//获得下标为i的图书
            //book.getName().equals(name)比较name是否相同
            if(book.getName().equals(name)){
                System.out.println(name+"这本书已经存在。。。");
                return;
            }
        }

        System.out.println("请输入作者名字：");
        String author=scanner.nextLine();
        System.out.println("请输入书的类型：");
        String type=scanner.nextLine();
        System.out.println("请输入价格：");
        double price=scanner.nextDouble();

        //创建新书对象
        Book book=new Book(name,author,price,type);

        //插入这本书
        bookList.setBook(currentSize,book);//尾插图书
        bookList.setBookSize(currentSize+1);//书的数量加一

        System.out.println("增加成功");

    }
}
