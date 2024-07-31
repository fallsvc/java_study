package SortTest;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/31  22:16
 */
public class Test {
    public static void main(String[] args) {
        int[] arr={4,3,6,7,2,1};
        int[] arr1=new int[10];
        Sort.insertSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
