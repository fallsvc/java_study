package greed.first;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/27  18:15
 */
public class Demo2 {
//    https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
//    最长递增顺序
    
    class Solution1 {
        public int findLengthOfLCIS(int[] nums) {
            int i=0,j=0;
            int ret=1;
            while(j<nums.length-1) {
                if(nums[j+1]>nums[j]) j++;
                else {
                    j++;
                    i=j;
                }
                ret=Math.max(j-i+1,ret);
            }
            return ret;
        }
    }

    class Solution2 {
//        https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
//        单次买卖股票最佳问题
        public int maxProfit(int[] prices) {

            int ret=0;
            for(int i=0,prevMin=Integer.MAX_VALUE;i<prices.length;i++) {
                //
                ret=Math.max(ret,prices[i]-prevMin);
                // 更新最小值
                prevMin=Math.min(prevMin,prices[i]);


            }

            return ret;
        }
    }

    class Solution3 {
//        https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
//        多次购买股票
        public int maxProfit(int[] prices) {
            int n=prices.length;
            // 双指针
            // int i=0,j=0;
            int sum=0;
            //1.
            // for(int i=0;i<n;i++) {
            //     int j=i;
            //     while(j+1<n&&prices[j+1]>prices[j]) j++;
            //     sum+=prices[j]-prices[i];
            //     i=j;
            // }
            //2.
            // while(j<n-1) {
            //     if(prices[j+1]>prices[j]) j++;
            //     else {
            //         sum+=prices[j]-prices[i];
            //         j++;
            //         i=j;
            //     }
            // }
            // if(j!=i) sum+=prices[j]-prices[i];

//      3.
            for(int i=0;i<n-1;i++) {
                if(prices[i+1]>prices[i])
                    sum+=prices[i+1]-prices[i];
            }

            return sum;
        }
    }
}
