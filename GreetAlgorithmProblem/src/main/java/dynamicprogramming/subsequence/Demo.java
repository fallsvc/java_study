package dynamicprogramming.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static void main1(String[] args) {
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

        int retLen=1,retCount=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(len[j]+1==len[i]) count[i]+=count[j]; // 找到另一个同长度的串可能
                    else if(len[j]+1>len[i]){
                        len[i]=len[j]+1;   // 更新最大串
                        count[i]=count[j];
                    }
                }
            }
            // 计算返回最大长度的count值之和
            if(retLen==len[i]) retCount+=count[i]; // 同长度的相加
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
        Arrays.sort(pairs,(a, b)->a[0]-b[0]);// 数组的排序

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


//    https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/description/
    // Hash表就能完成
    public int longestSubsequence(int[] arr, int difference) {
        int n=arr.length;
        Map<Integer,Integer> hash=new HashMap<>();// 此下标结尾的最长定差子序列长度

        int len=1;
        for(int x:arr){
            int d=hash.getOrDefault(x-difference,0)+1;
            len=Math.max(len,d);
            hash.put(x,d);
        }

        return len;
    }


//    https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        //
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++)
            hash.put(arr[i],i);
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=2;
            }
        }
        int ret=2;
        for(int j=2;j<n;j++){
            for(int i=1;i<j;i++){
                int a=arr[j]-arr[i];
                if(a<arr[i]&&hash.containsKey(a)){
                    dp[i][j]=dp[hash.get(a)][i]+1;
                    ret=Math.max(ret,dp[i][j]);
                }
            }
        }
        return ret<3?0:ret;
    }


//    https://leetcode.cn/problems/longest-arithmetic-subsequence/
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> hash=new HashMap<>();// 存前面元素和对应下标
        int[][] dp=new int[n][n];// dp[i][j] 以i 和 j 结尾的数组 i<j
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=2;
        int len=2;
        hash.put(nums[0],0);
        // 固定i 然后hash输入
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                int b=nums[i],c=nums[j];
                if(hash.containsKey(2*b-c)){
                    dp[i][j]=dp[hash.get(2*b-c)][i]+1;
                    len=Math.max(len,dp[i][j]);

                }
            }
            hash.put(nums[i],i);
        }
        return len;
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();

    }

//    https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];
        Map<Long, ArrayList<Integer>> hash=new HashMap<>();

        for(int i=0;i<n;i++){
            long a=(long)(nums[i]);
            if(!hash.containsKey(a)){
                hash.put(a,new ArrayList<Integer>());
            }
            hash.get(a).add(i);
        }

        int ret=0;
        for(int j=2;j<n;j++){
            for(int i=1;i<j;i++){
                long a=2L*(long)nums[i]-(long)nums[j];
                if(hash.containsKey(a)){
                    for(int x:hash.get(a)){
                        if(x<i) dp[i][j]+=dp[x][i]+1;
                        else break;
                    }
                }
                ret+=dp[i][j];
            }
        }
        return ret;
    }
}
