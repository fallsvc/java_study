package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/4  15:34
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(-1,10);
    }
    public static void main1(String[] args) {

        int[] a=new int[10];
        System.out.println(Arrays.toString(a));

        int i=0;
        Integer b=10;
        System.out.println(b.equals(10));
    }
}
