package user;

import book.BookList;
import ioperation.IO;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  22:06
 */
public abstract class User {
    protected String name;//用户名字
    public IO[] ios;// 功能接口 存放用户功能
    public User(String name) {
        this.name = name;
    }

    //访问私有成员name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int menu();//抽象方法，子类必须实现

    //执行功能，操作书架bookList
    public void doIoperation(int choice, BookList bookList){
        ios[choice].work(bookList);
    }
}
