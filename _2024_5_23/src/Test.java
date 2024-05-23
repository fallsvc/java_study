import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  20:41
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String age=sc.nextLine();
        String name=sc.nextLine();
        int a=Integer.parseInt(age);

        int b=Integer.valueOf(age);
//        int age=sc.nextInt();
//        String name=sc.next();
//        int a=Integer.parseInt(age);
        System.out.println(age+name);
        System.out.println(a);
        System.out.println(b);
    }
}
