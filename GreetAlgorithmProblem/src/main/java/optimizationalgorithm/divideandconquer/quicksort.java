package optimizationalgorithm.divideandconquer;

import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/15  17:37
 */
public class quicksort {
    class Solution1 {
//        /
        // https://leetcode.cn/problems/sort-colors/
        //        颜色分类
//       采用三指针法

        public void sortColors(int[] nums) {
            // [0-left] 为0区间  [left+1,i-1] 1区间 [right,len-1] 2区间
            int left=-1,i=0,right=nums.length;
            while(i<right){
                if(nums[i]==0){
                    swap(nums,i++,++left);
                }else if(nums[i]==1){
                    i++;
                }else{
                    swap(nums,i,--right);
                }
            }
        }
        public void swap(int[] nums,int i,int j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }

    public static void main(String[] args) {
        Random random=new Random();
        System.out.println(random.nextInt(2));
    }
}
