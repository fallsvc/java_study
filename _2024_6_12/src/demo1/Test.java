package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/12  9:48
 */
public class Test {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,3,2,3,5};
        int[] b=a.clone();
        System.out.println(Arrays.toString(b));
    }
}
