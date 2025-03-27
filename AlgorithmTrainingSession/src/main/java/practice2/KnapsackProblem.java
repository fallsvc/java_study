package practice2;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/24  19:32
 */
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {

    public static void main(String[] args) {
        int n = 5; // 物品数量
        int W = 22; // 背包容量
        int[] w = {3, 5, 7, 8, 9}; // 物品重量
        int[] v = {4, 6, 7, 9, 10}; // 物品价值

        // 调用背包算法
        KnapsackResult result = knapsack(n, W, w, v);

        // 输出结果
        System.out.println("最大价值: " + result.maxValue);
        System.out.print("选择的物品索引: ");
        for (int i : result.selectedItems) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("选择的物品重量: ");
        for (int i : result.selectedItems) {
            System.out.print(w[i] + " ");
        }
        System.out.println();

        System.out.print("选择的物品价值: ");
        for (int i : result.selectedItems) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    // 定义结果类，包含最大价值和选择的物品索引
    static class KnapsackResult {
        int maxValue;
        List<Integer> selectedItems;

        public KnapsackResult(int maxValue, List<Integer> selectedItems) {
            this.maxValue = maxValue;
            this.selectedItems = selectedItems;
        }
    }

    public static KnapsackResult knapsack(int n, int W, int[] w, int[] v) {
        // 初始化动态规划表
        int[][] dp = new int[n + 1][W + 1];

        // 填充动态规划表
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 回溯找出选择的物品
        int res = dp[n][W];
        int j = W;
        List<Integer> selectedItems = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if (res <= 0) {
                break;
            }
            if (res == dp[i - 1][j]) {
                continue;
            } else {
                selectedItems.add(i - 1);
                res -= v[i - 1];
                j -= w[i - 1];
            }
        }

        return new KnapsackResult(dp[n][W], selectedItems);
    }
}