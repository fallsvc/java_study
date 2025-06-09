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


//    https://leetcode.cn/problems/sort-the-people/submissions/635511393/
//    按身高排序
    public String[] sortPeople(String[] names, int[] heights) {
        int n=names.length;
//        创建下标数组
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++) {
            index[i]=i;
        }
//        按身高进行下标数组排序
        Arrays.sort(index,(a,b)->{
           return heights[b]-heights[a];
        });
//        提取结果
        String[] ret=new String[n];
        for (int i=0;i<n;i++) {
            ret[i]=names[index[i]];
        }
        return ret;
    }

//    https://leetcode.cn/problems/advantage-shuffle/submissions/635657864/
//    优势洗牌
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n=nums1.length;

        Integer[] index2=new Integer[n];
        Arrays.sort(nums1);
        for(int i=0;i<n;i++) {
            index2[i]=i;
        }
        Arrays.sort(index2,(a,b)->{
            return nums2[a]-nums2[b];
        });

        int l1=0,r1=n-1;

        int[] ret=new int[n];

        for(int x:nums1) {
            if(x>nums2[index2[l1]]) {
                ret[index2[l1]]=x;
                l1++;
            }else {
                ret[index2[r1]]=x;
                r1--;
            }
        }
        //

        return ret;
    }

    public static void main(String[] args) {
        int[] arr1={12,24,8,32};
        int[] arr2={13,25,32,11};
        advantageCount(arr1,arr2);
    }
    public static void main1(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
//        priorityQueue
    }
}
