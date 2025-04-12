package dynamicprogramming.palindromicsubstring;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/8  16:25
 */
public class SubsequenceDemon {
//    https://leetcode.cn/problems/longest-palindromic-subsequence/
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];// i->j 的最长回文子序列

        for(int i=n-1;i>=0;i--){ // 从下到上
            for(int j=i;j<n;j++){ // 从左到右
                if(s.charAt(i)==s.charAt(j)){
                    if(i==j) dp[i][j]=1;
                    else if(i+1==j) dp[i][j]=2;
                    else dp[i][j]=dp[i+1][j-1]+2;
                }else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }

        return dp[0][n-1];
    }

//    https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    public int minInsertions(String s) {
        int n=s.length();
        int[][] dp=new int[n][n]; // i->j 的最小插入次数

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=i+1<j?dp[i+1][j-1]:0;
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],dp[i+1][j])+1;
                }
            }
        }
        return dp[0][n-1];
    }
}
