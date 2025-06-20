package dynamicprogramming.twoarray;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/9  15:44
 */
public class Demo1 {
    //    https://leetcode.cn/problems/longest-common-subsequence/
    class Solution1 {
        public int longestCommonSubsequence(String text1, String text2) {
            text1 = " " + text1;
            text2 = " " + text2;
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m][n];// 0->i(text1) 和0->j(text2) 的最大公共子序列
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (text1.charAt(i) == text2.charAt(j))// 结尾位置相同
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 不同时找前面已填最大值
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    //    https://leetcode.cn/problems/uncrossed-lines/
    class Solution2 {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[][] dp = new int[m + 1][n + 1];// nums1 0->i nums2 0->j 的最大公共子序列长度
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {  // 相同时以不包含i,j为结尾的最大长度+1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 不相同 就等于i结尾或者j结尾的最大值
                    }
                }
            }
            return dp[m][n];
        }
    }

    class Solution3 {
        public int numDistinct(String s, String t) {
            s = " " + s;
            t = " " + t;
            int m = t.length();
            int n = s.length();
            int[][] dp = new int[m][n];
            // 初始化 t为null时始终有一个
            for (int j = 0; j < n; j++) dp[0][j] = 1;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1];// 加上前面有的个数
                    if (t.charAt(i) == s.charAt(j)) {
                        dp[i][j] += dp[i - 1][j - 1]; // 以这个结尾加上前面串能找到的个数
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    //    https://leetcode.cn/problems/wildcard-matching/
//    字符匹配
    public boolean isMatch(String ss, String pp) {
        ss = " " + ss;
        pp = " " + pp;
        int m = ss.length();
        int n = pp.length();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化
        for (int j = 1; j < n; j++) {
            if (p[j] == '*') dp[0][j] = true;
            else break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s[i] == p[j] || p[j] == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p[j] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    //    https://leetcode.cn/problems/regular-expression-matching/description/
    // 正则表达式匹配
    public boolean isMatch1(String ss, String pp) {
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int m = s.length;
        int n = p.length;

        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;

        for (int j = 2; j < n; j += 2) {
            if (p[j] == '*') dp[0][j] = true;
            else break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p[j] == '*')
                    dp[i][j] = dp[i][j - 2] || (p[j - 1] == '.' || p[j - 1] == s[i]) && dp[i - 1][j];
                else
                    dp[i][j] = (p[j] == s[i] || p[j] == '.') && dp[i - 1][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
