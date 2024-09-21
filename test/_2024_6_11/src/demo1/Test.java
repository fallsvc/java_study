package demo1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/11  17:57
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("hhh");
        arrayList.add("ppp");
        arrayList.add("kkk");
        ArrayList<String> arrayList1=new ArrayList<>();
        arrayList1.addAll(arrayList);
        System.out.println(arrayList1.toString());
    }
    public static void main4(String[] args) {
        long start=System.currentTimeMillis();
        StringBuilder stringBuilder=new StringBuilder("hehe");

        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
        }

        long end=System.currentTimeMillis();

        System.out.println(stringBuilder);
        System.out.println(end-start);

    }
    public static void main3(String[] args) {
        int n=new Integer(10);
        System.out.println(n);
        Integer m=10;
        int c=m;
        System.out.println(c);
        System.out.println(m.equals(n));

        Integer r=20;
        System.out.println(r);
    }
    public static void main2(String[] args) {
        int a=1;
        if(a==1){
            throw new AForOneException("a==1");
        }
    }
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        while(true){
            int ret=random.nextInt(2);
            System.out.println(ret);
            int r=scanner.nextInt();
        }
    }
}
