import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        for (int x:arr) {
            System.out.println(x);
        }
        System.out.println("====");
        String ret=Arrays.toString(arr);
        System.out.println(ret);
    }
    public static void main8(String[] args) {
        int[] a={1,2,3,4,5,6};
        int[] a1=new int[]{1,2,3,4,5,6};
//        int[] a2=new int[5]{1,4,5,3};//err
        boolean[] c=new boolean[3];
        System.out.println(a[1]);
        System.out.println(c[1]);
    }
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }
    //每位数之和
    public static int sumNumber(int n){
        if(n<10){
            return n;
        }
        return n%10+sumNumber(n/10);
    }
    public static void main7(String[] args) {
        System.out.println(sum(6));
        System.out.println(sumNumber(12345));
    }

    public static int add(int a,int b){
        return a+b;
    }
    public static double add(double a,double b){
        return a+b;
    }
    public static int fac(int n){
        if(n<=2){
            return 1;
        }
        return fac(n-2)+fac(n-1);
    }

    public static void main6(String[] args) {
        System.out.println(add(1,1.2));
        System.out.println(fac(7));
    }
    public static int fin(int x) {
        return x*2;
    }

    public static void main5(String[] args) {
        System.out.println(fin(3));
    }
    public static void main4(String[] args) {
        Random random=new Random();
        int n= random.nextInt(100);//[0,100)
//        random.nextInt(100,200);
        System.out.println(n);
    }
    //1-100多少个9
    public static void main3(String[] args) {
        Scanner scan=new Scanner(System.in);
//        String str=scan.next();//遇见空格停
        int n= scan.nextInt();
        System.out.println(n);
        scan.nextLine();
        String str= scan.nextLine();
        System.out.println(str);
    }
    public static void main2(String[] args) {
        int count=0;
        for (int i = 0; i < 100; i++) {
            if(i%10==9){
                count++;
            }
            if(i/10==9){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||i+j==n-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
//        System.out.println(10);
//        int a=10;
//        int b=20;
//        //循环10次
//        while(a<b&b==20){
//            System.out.println(1);
//            a++;
//        }
        //死循环
//        while(a<b|b==20){
//            System.out.println(1);
//            a++;
//        }
    }
}
