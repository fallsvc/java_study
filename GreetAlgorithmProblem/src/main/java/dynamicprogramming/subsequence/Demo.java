package dynamicprogramming.subsequence;

import java.util.Arrays;

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
        int ret=1;
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) dp[i]=Math.max(dp[i],dp[j]+1);
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

//https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
//    https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] len=new int[n];// 下标对应最大增序列长度
        int[] count=new int[n];// 以这个下标结尾的最大增序列的个数
        for(int i=0;i<n;i++)
            len[i]=count[i]=1;
        int max=nums[0];
        int retLen=1,retCount=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(len[j]+1==len[i]) count[i]+=count[j];
                    else if(len[j]+1>len[i]){
                        len[i]=len[j]+1;
                        count[i]=count[j];
                    }
                }
            }
            // 计算返回最大长度的count值之和
            if(retLen==len[i]) retCount+=count[i];
            else if(retLen<len[i]) {
                retLen=len[i];
                retCount=count[i];
            }
        }
        return retCount;
    }

//    https://leetcode.cn/problems/maximum-length-of-pair-chain/
    public int findLongestChain(int[][] pairs) {
        // 预处理
        Arrays.sort(pairs,(a, b)->a[0]-b[0]);

        //
        int n=pairs.length;
        int col=pairs[0].length;
        int[] dp=new int[n];// 此下标时的最长数对链
        for(int i=0;i<n;i++) dp[i]=1;

        int ret=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][col-1]<pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }

}
