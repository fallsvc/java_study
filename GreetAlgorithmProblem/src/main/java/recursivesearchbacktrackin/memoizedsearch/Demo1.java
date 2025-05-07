package recursivesearchbacktrackin.memoizedsearch;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/28  14:25
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] a=new int[]{1,1};
        Arrays.fill(a,-1);
        System.out.println(a[0]);
    }
    class Solution1 {
//        https://leetcode.cn/problems/fibonacci-number/
//        斐波那契
        int[] memory;// 记录已经计算过的
        public int fib(int n) {
            memory=new int[31];
            Arrays.fill(memory,-1);
            return dfs(n);
        }

        public int dfs(int n){
            // 是否已经计算
            if(memory[n]!=-1) return memory[n];

            if(n==0||n==1){
                memory[n]=n;
                return n;
            }
            // 存入返回值
            memory[n]=dfs(n-1)+dfs(n-2);
            return memory[n];
        }

        // 动态规划
        public int fib2(int n) {
            int[] dp=new int[31];
            dp[1]=1;
            for(int i=2;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
    }

    class Solution2 {
//        https://leetcode.cn/problems/unique-paths/
//        不同路径
        public int uniquePaths(int m, int n) {
            int[][] memo=new int[m+1][n+1];
            return dfs(m,n,memo);
        }
        public int dfs(int m,int n,int[][] memo){
            if(memo[m][n]!=0) return memo[m][n];

            if(m==0||n==0) return 0;
            if(m==1&&n==1){
                memo[m][n]=1;
                return 1;
            }
            memo[m][n]=dfs(m-1,n,memo)+dfs(m,n-1,memo);
            return memo[m][n];
        }
    }

    class Solution3 {
//        https://leetcode.cn/problems/longest-increasing-subsequence/
//        最长递增子序列
        public int lengthOfLIS(int[] nums) {
            int ret=0;
            int len=nums.length;
            int[] memo=new int[len];

            for(int i=0;i<len;i++){
                ret=Math.max(ret,dfs(i,nums,memo));
            }
            return ret;
        }
        public int dfs(int pos,int[] nums,int[] memo){
            if(memo[pos]!=0) return memo[pos];

            int ret=1;
            for(int i=pos+1;i<nums.length;i++){
                if(nums[i]>nums[pos])
                    ret=Math.max(ret,dfs(i,nums,memo)+1);
            }

            memo[pos]=ret;
            return ret;
        }
//      动态规划
        public int lengthOfLIS2(int[] nums) {
            int ret=0;
            int len=nums.length;
            int[] dp=new int[len];
            Arrays.fill(dp,1);
            for(int i=len-1;i>=0;i--){
                for(int j=i+1;j<len;j++){
                    if(nums[i]<nums[j])
                        dp[i]=Math.max(dp[i],dp[j]+1);
                }
                ret=Math.max(ret,dp[i]);
            }

            // int[] memo=new int[len];

            // for(int i=0;i<len;i++){
            //     ret=Math.max(ret,dfs(i,nums,memo));
            // }
            return ret;
        }
    }

    class Solution4 {
//        https://leetcode.cn/problems/guess-number-higher-or-lower-ii/
//        猜数字大小II
        public int getMoneyAmount(int n) {
            int[][] memo=new int[n+1][n+1];
            return dfs(0,n,memo);
        }
        public int dfs(int left,int right,int[][] memo){
            if(left>=right) return 0;
            if(memo[left][right]!=0)
                return memo[left][right];

            int ret=Integer.MAX_VALUE;
            for(int i=left;i<=right;i++){
                int l=dfs(left,i-1,memo);
                int r=dfs(i+1,right,memo);
                ret=Math.min(Math.max(l,r)+i,ret);
            }

            memo[left][right]=ret;
            return ret;
        }
    }

    class Solution5 {
//        https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
//        矩阵中的最长递增路径
        int m;
        int n;
        int[][] memo;

        public int longestIncreasingPath(int[][] matrix) {
            m=matrix.length;
            n=matrix[0].length;
            memo=new int[m][n];
            int ret=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    ret=Math.max(dfs(i,j,matrix),ret);
                }
            }
            return ret;
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public int dfs(int i,int j,int[][] matrix){
            if(memo[i][j]!=0) return memo[i][j];

            int ret=1;
            for(int k=0;k<4;k++){
                int x=dx[k]+i,y=dy[k]+j;
                if(x>=0&&x<m&&y>=0&&y<n&&matrix[x][y]>matrix[i][j]){
                    ret=Math.max(dfs(x,y,matrix)+1,ret);
                }
            }

            memo[i][j]=ret;
            return ret;

        }
    }
}
