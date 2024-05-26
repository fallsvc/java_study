import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  21:52
 */
public class Main {
    //实现登录方法
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        String name = scanner.nextLine();
        System.out.println("************************");
        System.out.println("******0.exit************");
        System.out.println("******1.管理员用户*******");
        System.out.println("******2.普通用户 ********");
        System.out.println("************************");
        System.out.println("1 or 2 :");
        int input = scanner.nextInt();
        //返回用户类型
        if (input == 1) {
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }
    }


    public static void main(String[] args) {
        BookList bookList=new BookList();//创建一个书架
        User user=login();//获得用户类型
            //循环操作书架
            while (true) {
                int ret=user.menu();
                user.doIoperation(ret,bookList);
            }
    }
}
