package demo1;

import java.sql.Array;
import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/1  9:41
 */
public class Test {
    public static int binarySearch(int[] array,int k){
        int left=0;
        int right=array.length-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(array[mid]==k){
                return mid;
            }else if(array[mid]<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return 1;
    }
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3};
        System.out.println(Arrays.binarySearch(a, 2));

    }
}
