package SortImplimentation;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/15  11:33
 */
public class Test {
    public static void sort(int[] array){
        long start=System.currentTimeMillis();

//        Sort.insertSort(array);
//        Sort.shellSort(array);
//        Sort.selectSort(array);

//        Sort.selectSort2(array);
//        Sort.heapSort(array);
//        Sort.bubbleSort(array);
        Sort.quickSort(array);

        long end=System.currentTimeMillis();

        System.out.println(end-start);

    }
    public static void main(String[] args) {
        int[] array={11,12,13,12,14,16,9,8,7,6,5,4,3,2,1};
        int[] array1={1,2,3,4,5,6,7,8,9,10,11,12,13};
        sort(array1);

        System.out.println(Arrays.toString(array1));

    }
}
