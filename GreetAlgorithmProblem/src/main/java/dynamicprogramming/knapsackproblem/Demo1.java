package dynamicprogramming.knapsackproblem;

import java.util.Map;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/23  15:48
 */
public class Demo1 {
    class Solution1 {
//        https://leetcode.cn/problems/partition-equal-subset-sum/
        // 分两个大小和相等数组
        public boolean canPartition(int[] nums) {

            int n=nums.length;
            int sum=0;
            for(int x:nums) sum+=x;
            if(sum%2==1) return false;
            int t=sum/2;
            boolean[][] dp=new boolean[n+1][t+1];// [i][j] i个元素 能不能到达和为j
            // 初始化
            for(int i=0;i<=n;i++) dp[i][0] =true;

            for(int i=1;i<=n;i++){
                for(int j=1;j<=t;j++){
                    dp[i][j]=dp[i-1][j];
                    if(j-nums[i-1]>=0&&dp[i][j]==false) dp[i][j]=dp[i-1][j-nums[i-1]];
                }
            }

            return dp[n][t];
        }

        // 空间优化
        public boolean canPartition2(int[] nums) {
            int n=nums.length;
            int sum=0;
            for(int x:nums) sum+=x;
            if(sum%2==1) return false;
            int t=sum/2;
            boolean[] dp=new boolean[t+1];// [i][j] i个元素 能不能到达和为j
            // 初始化
            dp[0] =true;

            for(int i=1;i<=n;i++){
                for(int j=t;j>=nums[i-1];j--){
                    dp[j]=dp[j]||dp[j-nums[i-1]];
                }
            }
            return dp[t];
        }
    }

    class Solution2 {
//https://leetcode.cn/problems/target-sum/
//  目标和
        public int findTargetSumWays(int[] nums, int target) {

            // 转化为找sum+target的一半（+）
            int n=nums.length;
            int sum=0;
            for(int x:nums) sum+=x;
            sum+=target;

            int t=(sum)/2;
            if(t<0||sum%2==1) return 0;
            int[][] dp=new int[n+1][t+1];// [i][j] 前i个元素和为j的排列
            dp[0][0]=1;
            for(int i=1;i<=n;i++){
                for(int j=0;j<=t;j++){
                    dp[i][j]=dp[i-1][j];// 不选择i
                    if(j-nums[i-1]>=0) dp[i][j]+=dp[i-1][j-nums[i-1]];// 选择
                }
            }
            return dp[n][t];
        }
        // 降维
        public int findTargetSumWays2(int[] nums, int target) {

            // 转化为找sum+target的一半（+）
            int n=nums.length;
            int sum=0;
            for(int x:nums) sum+=x;
            sum+=target;

            int t=(sum)/2;
            if(t<0||sum%2==1) return 0;
            int[] dp=new int[t+1];// [i][j] 前i个元素和为j的排列
            dp[0]=1;
            for(int i=1;i<=n;i++){
                for(int j=t;j>=nums[i-1];j--){
                    dp[j]+=dp[j-nums[i-1]];// 选择
                }
            }
            return dp[t];
        }

    }

    class Solution3 {
//        https://leetcode.cn/problems/last-stone-weight-ii/
//        最后一块石头重量
        public int lastStoneWeightII(int[] stones) {
            int sum=0;
            int n=stones.length;
            for(int i=0;i<n;i++){
                sum+=stones[i];
            }
            int t=sum/2;
            int[][] dp=new int[n+1][t+1];// [i][j] 前i个元素 组合成小于等于j的最大和

            for(int i=1;i<=n;i++){
                for(int j=0;j<=t;j++){
                    dp[i][j]=dp[i-1][j];
                    if(j-stones[i-1]>=0){
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                    }
                }
            }
            return sum-2*dp[n][t];
        }
    }
//
public class Main1 {
//        https://www.nowcoder.com/practice/237ae40ea1e84d8980c1d5666d1c53bc?tpId=230&tqId=2032575&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196
//    完全背包问题
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int V = in.nextInt();
            int[] v=new int[n];
            int[] w=new int[n];
            for(int i=0;i<n;i++){
                v[i]=in.nextInt();
                w[i]=in.nextInt();
            }
            kp(n,V,v,w);
        }
    }
    public static void kp(int n,int V,int[] v,int[] w){
        int[][] dp1=new int[n+1][V+1];//[i][j] 前i个元素 装体积小于等于j的 最大值价值
        int[][] dp2=new int[n+1][V+1];//[i][j] 前i个元素 装体积等于j的 最大值价值
        for(int i=1;i<=V;i++) dp2[0][i]=-1;// -1 无法到达

        for(int i=1;i<=n;i++){
            for(int j=0;j<=V;j++){
                dp1[i][j]=dp1[i-1][j];
                if(j-v[i-1]>=0) dp1[i][j]=Math.max(dp1[i][j],dp1[i][j-v[i-1]]+w[i-1]);

                dp2[i][j]=dp2[i-1][j];
                if(j-v[i-1]>=0&&dp2[i][j-v[i-1]]!=-1)dp2[i][j]=Math.max(dp2[i][j],dp2[i][j-v[i-1]]+w[i-1]);
            }
        }
        System.out.println(dp1[n][V]);
        System.out.println(dp2[n][V]==-1?0:dp2[n][V]);// 处理返回值

    }
}
    public class Main2 {
//         使用滚动数组降维
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                int n = in.nextInt();
                int V = in.nextInt();
                int[] v=new int[n];
                int[] w=new int[n];
                for(int i=0;i<n;i++){
                    v[i]=in.nextInt();
                    w[i]=in.nextInt();
                }
                kp(n,V,v,w);
            }
        }
        public static void kp(int n,int V,int[] v,int[] w){
            int[] dp1=new int[V+1];
            int[] dp2=new int[V+1];
            for(int i=1;i<=V;i++) dp2[i]=-1;

            for(int i=1;i<=n;i++){
                for(int j=v[i-1];j<=V;j++){

                    dp1[j]=Math.max(dp1[j],dp1[j-v[i-1]]+w[i-1]);


                    if(dp2[j-v[i-1]]!=-1)dp2[j]=Math.max(dp2[j],dp2[j-v[i-1]]+w[i-1]);
                }
            }
            System.out.println(dp1[V]);
            System.out.println(dp2[V]==-1?0:dp2[V]);

        }
    }

    class Solution4 {
//        https://leetcode.cn/problems/coin-change/
//        零钱兑换
        public int coinChange(int[] coins, int amount) {
            int m=coins.length,n=amount;
            int[][] dp=new int[m+1][n+1]; // [i][j] 前i个元素恰好凑成j元 的最小硬币数
            for(int j=1;j<=n;j++)
                dp[0][j]=0x3f3f3f3f; // 表示不能凑成


            for(int i=1;i<=m;i++){
                for(int j=0;j<=n;j++){
                    dp[i][j]=dp[i-1][j];
                    if(j-coins[i-1]>=0)
                        dp[i][j]=Math.min(dp[i][j],dp[i][j-coins[i-1]]+1);
                }
            }
            return dp[m][n]==0x3f3f3f3f?-1:dp[m][n];
        }
//      滚动数组优化 降成1维
        public int coinChange2(int[] coins, int amount) {
            int m=coins.length,n=amount;
            int[] dp=new int[n+1]; // [i][j] 前i个元素恰好凑成j元 的最小硬币数
            for(int j=1;j<=n;j++)
                dp[j]=0x3f3f3f3f; // 表示不能凑成


            for(int i=1;i<=m;i++){
                for(int j=coins[i-1];j<=n;j++){
                    dp[j]=Math.min(dp[j],dp[j-coins[i-1]]+1);
                }
            }
            return dp[n]==0x3f3f3f3f?-1:dp[n];
        }
    }
    class Solution5 {
//        https://leetcode.cn/problems/coin-change-ii/
//        零钱问题II
        public int change(int amount, int[] coins) {
            int n=coins.length;
            int[][] dp=new int[n+1][amount+1];// [i][j] i个硬币能凑成j 的种数
            for(int i=0;i<=n;i++) dp[i][0]=1;

            for(int i=1;i<=n;i++){
                for(int j=1;j<=amount;j++){
                    dp[i][j]=dp[i-1][j];// 前面能凑成j的种数
                    if(j-coins[i-1]>=0){
                        dp[i][j]+=dp[i][j-coins[i-1]];
                    }
                }
            }
            return dp[n][amount];
        }
        // 滚动数组降维
        public int change2(int amount, int[] coins) {
            int n=coins.length;
            int[] dp=new int[amount+1];
            dp[0]=1;

            for(int i=1;i<=n;i++)
                for(int j=coins[i-1];j<=amount;j++)
                    dp[j]+=dp[j-coins[i-1]];
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(2));
    }
    class Solution6 {
//        https://leetcode.cn/problems/perfect-squares/
//        完全平方数
        public int numSquares(int n) {
            int sqrtN=(int)Math.sqrt(n);
            int[][] dp=new int[sqrtN+1][n+1];// [i][j] 前i个数能凑成的j的最小平方数个数
            int INF=0x3f3f3f3f;
            for(int i=1;i<=n;i++) dp[0][i]=INF;// 不能凑成i

            for(int i=1;i<=sqrtN;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j]=dp[i-1][j];
                    if(j-i*i>=0){
                        dp[i][j]=Math.min(dp[i][j],dp[i][j-i*i]+1);
                    }
                }
            }
            return dp[sqrtN][n];
        }

        public int numSquares2(int n) {
            int sqrtN=(int)Math.sqrt(n);
            int[] dp=new int[n+1];// [i][j] 前i个数能凑成的j的最小平方数个数
            int INF=0x3f3f3f3f;
            for(int i=1;i<=n;i++) dp[i]=INF;// 不能凑成i

            for(int i=1;i<=sqrtN;i++){
                for(int j=i*i;j<=n;j++){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
            return dp[n];
        }
    }
}
