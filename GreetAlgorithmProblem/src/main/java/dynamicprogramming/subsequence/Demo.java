package dynamicprogramming.subsequence;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  16:43
 */
public class Demo {
//    https://leetcode.cn/problems/longest-increasing-subsequence/
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];// 此下标最大递增子序列长度
        for(int i=0;i<n;i++) dp[i]=1;// 初始化

        // 填表
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i]) dp[i]=Math.max(dp[i],dp[j]+1);

        int ret=0;
        for(int i=0;i<n;i++){
            ret=Math.max(ret,dp[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] ret={10,9,2,5,3,7,101,18};
//        lengthOfLIS(ret);
    }

//    https://leetcode.cn/problems/wiggle-subsequence/submissions/617169211/
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        int[] f=new int[n];// 上升状态
        int[] g=new int[n];// 下降状态
        for(int i=0;i<n;i++) f[i]=g[i]=1;

        int ret=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]) f[i]=Math.max(g[j]+1,f[i]);
                else if(nums[i]<nums[j]) g[i]=Math.max(f[j]+1,g[i]);
            }
            ret=Math.max(ret,Math.max(f[i],g[i]));
        }
        return ret;
    }
}
