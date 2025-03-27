package practice2;

import java.util.Arrays;

public class MinCoinProblem {

    public static void main(String[] args) {
        int[] T = {1,}; // 硬币面值
        int[] Coins = {100}; // 每种硬币的可用数量
        int m = 100; // 需要找零的金额
        
        int result = minCoinsSpaceOptimized(T, Coins, m);

        System.out.println(result);
    }

    public static int minCoinsSpaceOptimized(int[] T, int[] Coins, int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 0; j < T.length; j++) {
            while (Coins[j] > 0) {
                for (int i = m; i >= T[j]; i--) {
                    if (dp[i - T[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - T[j]] + 1);
                    }
                }
                Coins[j]--;
            }
        }

        return dp[m] == Integer.MAX_VALUE ? -1 : dp[m];
    }
}