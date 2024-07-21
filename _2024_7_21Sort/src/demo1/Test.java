package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/21  8:53
 */
public class Test {
    public static void main(String[] args) {

        int[] array={7,6,5,4,3,2};
        System.out.println(Arrays.toString(array));
//        Sort.selectSort(array);
//        Sort.selectFasterSort(array);
//        Sort.heapSort(array);
        Sort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
