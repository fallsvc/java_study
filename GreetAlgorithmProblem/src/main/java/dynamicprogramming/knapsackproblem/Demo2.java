package dynamicprogramming.knapsackproblem;

import java.util.PriorityQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/12  15:24
 */
public class Demo2 {
    class Solution1 {
//        https://leetcode.cn/problems/ones-and-zeroes/
//        1 和 0
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][][] dp=new int[len+1][m+1][n+1];// [i][j][k] i个元素 最多j个0 k个1的子集中元素个数

            for (int i = 1;i <= len;i++) {
                int a=0,b=0;// a 0的个数 b 1的个数
                for (char x : strs[i-1].toCharArray()) {
                    if (x == '0') {
                        a++;
                    }else {
                        b++;
                    }
                }
                for (int j = 0;j <= m;j++) {
                    for (int k = 0;k <= n;k++) {
                        // 填表
                        dp[i][j][k]=dp[i-1][j][k];
                        if (j >= a && k >= b ) {
                            dp[i][j][k]=Math.max(dp[i][j][k],dp[i-1][j-a][k-b]+1);
                        }
                    }
                }
            }
            return dp[len][m][n];
        }
//        降维
        public int findMaxForm2(String[] strs, int m, int n) {
            int len = strs.length;
            int[][] dp=new int[m+1][n+1];// [i][j][k] i个元素 最多j个0 k个1的子集中元素个数
            for (int i = 1;i <= len;i++) {
                int a = 0,b = 0;// a 0的个数 b 1的个数
                for (char x : strs[i-1].toCharArray()) {
                    if (x == '0') a++;
                    else b++;
                }
                for (int j = m;j >= a;j--) // 注意一定要从右到左填写 （需要用到上一层dp[j-a][k-b]的值）
                    for (int k = n;k >= b;k--) // 注意一定要从右到左填写
                        // 填表
                        dp[j][k]=Math.max(dp[j][k],dp[j-a][k-b]+1);
            }
            return dp[m][n];

        }
    }
    class Solution2 {
//        https://leetcode.cn/problems/profitable-schemes/description/
//        盈利计划  （二模完全背问题）
        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            int mod=(int)(1e9+7);
            int len=group.length;
            // [i][j][k] 前i个任务 人数小于j 利润不少于k 的总选法
            int[][][] dp=new int[len+1][n+1][minProfit+1];

            // 初始化 0个任务利润0  人数为j的选任务法有1种 （都不选）
            for(int j=0;j<=n;j++) {
                dp[0][j][0]=1;
            }
            //
            for(int i=1;i<=len;i++) {
                for(int j=0;j<=n;j++) {
                    for(int k=0;k<=minProfit;k++) {
                        dp[i][j][k]=dp[i-1][j][k];// 不选i任务
                        if(j>=group[i-1]) // 选i任务 k-profit[i-1]<0时说明 i任务的利润已经超过需要利润 所以可以选剩下的利润至少为0的选法个数
                            dp[i][j][k]+=dp[i-1][j-group[i-1]][Math.max(0,k-profit[i-1])];
                        dp[i][j][k]%=mod;// 防止溢出
                    }
                }
            }
            return dp[len][n][minProfit];
        }
//        滚动数组降维
        public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
            int mod=(int)(1e9+7);
            int len=group.length;
            // [i][j][k] 前i个任务 人数小于j 利润不少于k 的总选法
            int[][] dp=new int[n+1][minProfit+1];

            // 初始化 0个任务利润0  人数为j的选任务法有1种 （都不选）
            for(int j=0;j<=n;j++) {
                dp[j][0]=1;
            }
            //
            for(int i=1;i<=len;i++) {
                for(int j=n;j>=group[i-1];j--) {
                    for(int k=minProfit;k>=0;k--) {
                        // 选i任务 k-profit[i-1]<0时说明 i任务的利润已经超过需要利润 所以可以选剩下的利润至少为0的选法个数
                        dp[j][k]+=dp[j-group[i-1]][Math.max(0,k-profit[i-1])];
                        dp[j][k]%=mod;// 防止溢出
                    }
                }
            }
            return dp[n][minProfit];
        }
    }

}
