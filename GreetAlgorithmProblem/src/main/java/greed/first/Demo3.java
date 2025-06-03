package greed.first;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/28  17:45
 */
public class Demo3 {
    class Solution1 {
//        https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
//        k次取反

        public int largestSumAfterKNegations(int[] nums, int k) {
            int m=0,minE=Integer.MAX_VALUE,n= nums.length;
            for(int x:nums) {
                if(x<0) m++;
                minE=Math.min(minE,Math.abs(x));
            }
            int ret=0;
            Arrays.sort(nums);
            if(m>k) {
                for(int i=0;i<k;i++) {
                    ret+=(-nums[i]);
                }
                for(int i=k;i<n;i++) {
                    ret+=nums[i];
                }
            }else {
                for(int x:nums ){
                    ret+=Math.abs(x);
                }
                if((k-m)%2!=0) {
                    ret-=minE*2;
                }
            }
            return ret;
        }
//        public int largestSumAfterKNegations(int[] nums, int k) {
//            PriorityQueue<Integer> p=new PriorityQueue<>();
//            for(int x: nums) {
//                p.add(x);
//            }
//            while(k--!=0) {
//                p.offer(-p.poll());
//            }
//
//            int sum=0;
//            while(!p.isEmpty()) {
//                sum+=p.poll();
//            }
//
//            return sum;
//
//        }
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
//        priorityQueue
    }
}
