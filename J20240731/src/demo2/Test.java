package demo2;


import jdk.jshell.execution.Util;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/31  10:44
 */
class Tools<T>{
    public static <T> void eat(T[] array,int s,int e){
        T tmp=array[s];
        array[s]=array[e];
        array[e]=tmp;
    }
    public static void t(){
        System.out.println("asd");
    }
}
public class Test {
    public static void main(String[] args) {
        Integer[] a={3,2,1,2};
        Tools.eat(a,0,1);
        Tools.eat(a,2,3);
        Tools.t();
        System.out.println(Arrays.toString(a));
    }
}
