package dynamicprogramming.twoarray;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/16  15:28
 */
public class Demo2 {
    class Solution1 {
        //        https://leetcode.cn/problems/interleaving-string/
        public boolean isInterleave(String ss1, String ss2, String ss3) {
            if (ss1.length() + ss2.length() != ss3.length()) return false;
            // 行列增加1 方便填表
            ss1 = " " + ss1;
            ss2 = " " + ss2;
            ss3 = " " + ss3;
            // 使用数组更快 时间优化
            char[] s1 = ss1.toCharArray();
            char[] s2 = ss2.toCharArray();
            char[] s3 = ss3.toCharArray();

            int m = s1.length;
            int n = s2.length;
            boolean[][] dp = new boolean[m][n];
            // 初始化
            dp[0][0] = true;       // dp[0][j] 表示s1 为空 全由s2来匹配
            for (int i = 1; i < m; i++) {
                if (s1[i] == s3[i]) dp[i][0] = true;
                else break;
            }
            for (int j = 1; j < n; j++) {
                if (s2[j] == s3[j]) dp[0][j] = true;
                else break;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // 分为两部分, s1[i] 和s3[i+j]匹配 和s2[j] 和s3[i+j] 匹配
                    dp[i][j] = (s1[i] == s3[i + j] && dp[i - 1][j]) || (s2[j] == s3[i + j] && dp[i][j - 1]);
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    class Solution2 {
        //        https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/
//       两个字符串最小ASCII删除和
        public int minimumDeleteSum(String ss1, String ss2) {
            // 增加一行一列 方便填表
            ss1 = " " + ss1;
            ss2 = " " + ss2;
            char[] s1 = ss1.toCharArray();
            char[] s2 = ss2.toCharArray();
            int m = s1.length;
            int n = s2.length;
            int[][] dp = new int[m][n];// i,j 结尾的公共子序列的最大ASCII值 (不需要删除的)

            // 填表
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (s1[i] == s2[j]) dp[i][j] = dp[i - 1][j - 1] + s1[i];
                    else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
            int max = 0;
            for (int i = 1; i < m; i++) max += s1[i];
            for (int j = 1; j < n; j++) max += s2[j];

            return max - 2 * dp[m - 1][n - 1]; // 总的-不需要删除的
        }
    }


}
