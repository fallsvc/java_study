package user;

import ioperation.*;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  23:27
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        //创建用户功能
        ios=new IO[]{new Exit(),new FindBook(),new BorrowBook(),new ReturnBook(),new ShowBooks()};
    }

    @Override
    public int menu() {
        System.out.println("**********************");
        System.out.println("******0.exit**********");
        System.out.println("******1.FindBook*******");
        System.out.println("******2.BorrowBook****");
        System.out.println("******3.Return********");
        System.out.println("**********************");

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您的操作：");
        int choice=scanner.nextInt();
        return choice;//返回选择值
    }
}
