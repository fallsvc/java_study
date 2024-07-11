package demo1;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/4  22:13
 */
public class Test {
    public void fun(int x,int y){

    }
    public void fun(int x,double y){

    }
    public void fun(double y,int x){

    }
    public void fun(int x,int y,int z){

    }
    public static boolean isLeapYear(int year){
        if((year%4==0&&year%100!=0)||year%400==0){
            return true;
        }
        return false;
    }

    public static int factor(int n){
        if(n==1){
            return 1;//出口
        }
        return n*factor(n-1);
    }
    public static void main(String[] args) {

    }
    public static void main4(String[] args) {

//        String name=scanner.nextLine();//输入字符串
//        int age=scanner.nextInt();//数人int整数
//        String s=scanner.next();

        Scanner scanner=new Scanner(System.in);
        int sum=0;
        while(scanner.hasNextInt()){
            int n=scanner.nextInt();
            sum+=n;
        }
        System.out.println(sum);
//        System.out.print(1);//不带换行
//        System.out.printf(format,msg);//格式化输出 与c语言基本一致
//        System.out.println(mas);//输出一个字符串带换行
    }
    public static void main3(String[] args) {
        int n=4;
        int sum=0;//计算阶乘和
        int tmp=1;//计算阶乘
        for (int i = 1; i <= n; i++) {
            tmp*=i;
            sum+=tmp;
        }
        System.out.println(sum);
    }
    public static void main2(String[] args) {
        int i=0;
        while(i<5){

            if(i==3){
                i++;//while中一定要写继续条件，不然会导致i没有+1,产生死循环
               continue;//i==3时跳过此次循环，不打印i
            }
            System.out.println(i);
            i++;
        }
    }
    public static void main1(String[] args) {
        int n=3;
        int sum=0;
        int num=1;
        //外层求和
        while(num<=n){
            int i=1;
            int tmp=1;
            //计算阶乘
            while(i<=num){
                tmp*=i;
                i++;
            }
            sum+=tmp;
            num++;
        }
        System.out.println(sum);
    }
}
