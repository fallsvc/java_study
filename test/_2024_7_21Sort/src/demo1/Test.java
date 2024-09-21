package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/21  8:53
 */
public class Test {
    public static void main1(String[] args) {
        System.out.println(1_0);
    }
    public static void main(String[] args) {

        int[] array={10,9,3,4,5,1,2,3,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(array));
//        Sort.selectSort(array);
//        Sort.selectFasterSort(array);
//        Sort.heapSort(array);
//        Sort.quickSort(array);
        Sort.mergeSort(array);
//        Sort.mergeSortNor(array);
//        Sort.countSort(array);
        System.out.println(Arrays.toString(array));
    }
}
