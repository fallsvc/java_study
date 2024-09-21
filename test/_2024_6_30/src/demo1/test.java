package demo1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/30  21:30
 */
public class test {
    public static void main(String[] args) {
        byte a=1;
        short b=2;
        int c=10;
        long d=10L;//or 10l  默认数字为四个字节
        float e=1.0F;//or 1.0f  默认小数为双精度浮点型
        double f=2.0;
        char g='h';
        boolean h=true;
    }
    public static void main1(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2=new ArrayList<>(list1);
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        Iterator<Integer> it = list1.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println(list2);
    }
}
