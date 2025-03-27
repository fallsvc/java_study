package dynamicprogramming.subarray;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  17:01
 */
public class Demo {
// https://leetcode.cn/problems/maximum-subarray/submissions/615724836/
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++)
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);// 长度为1 or 不为1的最大值
        int ret=Integer.MIN_VALUE/2;
        for(int i=0;i<n;i++)
            ret=Math.max(ret,dp[i]);

        return ret;
    }
    public int maxSubArray2(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];

        int ret=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            dp[i]=Math.max(nums[i-1],dp[i-1]+nums[i-1]);// 长度为1 or 不为1的最大值
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }
//    https://leetcode.cn/problems/maximum-sum-circular-subarray/submissions/615741246/
    public int maxSubarraySumCircular(int[] nums) {

        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n];// 找最小子串
        dp1[0]=nums[0];
        int[] dp2=new int[n];// 找最大子串
        dp2[0]=nums[0];

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            dp1[i]=Math.min(dp1[i-1]+nums[i],nums[i]);
            min=Math.min(min,dp1[i]);
            dp2[i]=Math.max(dp2[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp2[i]);
        }
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        // 处理全为负数

        return sum==min?max:Math.max(sum-min,max);
    }
    public int maxSubarraySumCircular2(int[] nums) {

        int n=nums.length;
        int[] dp1=new int[n+1];// 找最小子串
        int[] dp2=new int[n+1];// 找最大子串

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            dp1[i]=Math.min(dp1[i-1]+nums[i-1],nums[i-1]);
            min=Math.min(min,dp1[i]);
            dp2[i]=Math.max(dp2[i-1]+nums[i-1],nums[i-1]);
            max=Math.max(max,dp2[i]);
        }
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        // 处理全为负数

        return sum==min?max:Math.max(sum-min,max);
    }


    
}
