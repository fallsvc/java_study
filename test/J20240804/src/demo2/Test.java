package demo2;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/5  15:58
 */

public class Test {
    public static void mySort(Comparable[] comparables){
        for (int i = 0; i < comparables.length - 1; i++) {
            for (int j = 0; j < comparables.length-1-i; j++) {
                if(comparables[j].compareTo(comparables[j+1])>0){
                    Comparable tmp=comparables[j];
                    comparables[j]=comparables[j+1];
                    comparables[j+1]=tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Cat[] cats={
                new Cat(2,"小红"),
                new Cat(1,"小白"),
                new Cat(3,"小黑"),
                new Cat(4,"小蓝")
        } ;
//        Arrays.sort(cats);
        mySort(cats);
        System.out.println(Arrays.toString(cats));
    }
}
