package demo2Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/20  14:56
 */
public class Test {
    public static void orderArray(int[] array){
        for (int i = 0; i < array.length; i++) {
//            array[i]=i;
            array[i]=array.length-i;
        }
    }
    public static void notOrderArray(int[] array){
        Random random=new Random();
        for (int i = 0; i < array.length; i++) {
            array[i]=random.nextInt(100);
        }
    }
    public static void testInsertSort(int[] array){
        array=Arrays.copyOf(array,array.length);
        long start=System.currentTimeMillis();
        insertSort(array);
        long end=System.currentTimeMillis();
        System.out.println("查入排序"+(end-start));
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array){
        int gap=array.length;
        while (gap>1){
            gap=gap/3+1;
            shell(array,gap);
        }
    }

    private static void shell(int[] array, int gap) {
        for (int i = gap; i <array.length ; i++) {
            int tmp=array[i];
            int j = i-gap;
            for (; j >=0 ; j-=gap) {
                if(array[j]>tmp){
                    array[j+gap]=array[j];
                }else{
                    array[j+gap]=tmp;
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }

    public static void testSort(){
        int[] array=new int[10];
        orderArray(array);
        System.out.println(Arrays.toString(array));
        testInsertSort(array);
        System.out.println("=============");
        testShellSort(array);
    }

    private static void testShellSort(int[] array) {
        array=Arrays.copyOf(array,array.length);
        long start=System.currentTimeMillis();
        shellSort(array);
        long end=System.currentTimeMillis();
        System.out.println("shellSort:"+(end-start));
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        testSort();
    }
    public static void main1(String[] args) {
        int[] array={10,2,4,8,7};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    //插入排序
    //时间复杂度O(N^2)
    // 空间O(1)
    public static void insertSort(int[] array){

        for (int i = 1; i <array.length ; i++) {
            int tmp=array[i];
            int j = i-1;
            for (; j >=0 ; j--) {
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    array[j+1]=tmp;
                    break;
                }
            }
            array[j+1]=tmp;
        }

    }
}
