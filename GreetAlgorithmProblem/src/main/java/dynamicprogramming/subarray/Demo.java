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

//https://leetcode.cn/problems/maximum-product-subarray/submissions/616281026/
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int[] f=new int[n];// 到此点的最大乘积
        int[] g=new int[n];// 最小
        f[0]=g[0]=nums[0];
        int ret=f[0];
        for(int i=1;i<n;i++){
            f[i]=Math.max(nums[i]*g[i-1],Math.max(nums[i],nums[i]*f[i-1]));
            g[i]=Math.min(nums[i]*f[i-1],Math.min(nums[i],nums[i]*g[i-1]));
            ret=Math.max(ret,f[i]);
        }

        return ret;
    }

//    https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product/
    public int getMaxLen(int[] nums) {
        int n=nums.length;
        int[] f=new int[n+1];// 以下标为尾结点的最大正数乘积的长度
        int[] g=new int[n+1];// 负数
        int len=0;
        for(int i=1;i<=n;i++){
            int x=nums[i-1];
            if(x<0){
                f[i]=g[i-1]== 0 ? 0 : g[i-1]+1;
                g[i]=f[i-1]+1;
            }else if(x>0){
                f[i]=f[i-1]+1;
                g[i]=g[i-1] ==0 ? 0 : g[i-1]+1;
            }
            len=Math.max(len,f[i]);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] n={0,1,-2,-3,-4};
//        System.out.println(getMaxLen(n));
    }
    
}
