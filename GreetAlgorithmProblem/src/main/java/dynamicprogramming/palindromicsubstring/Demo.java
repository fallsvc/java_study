package dynamicprogramming.palindromicsubstring;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/7  13:56
 */
public class Demo {
//    https://leetcode.cn/problems/palindromic-substrings/
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];// 确定dp[i][j] i->j 的区间字符串是不是回文字符串

        int ret=0;// 统计
        // 从下到上填表（必须）  从右到左填表（也可以左到右填表）
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                // 概括三个判断 当i,j 对应字符相等时 如果 i==j or i+1==j --> true
                //                                      如果i+1<j dp[i+1][j-1] 为回文 dp[i][j]就为回文
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=i+1<j?dp[i+1][j-1]:true;
                }
                if(dp[i][j]) ret++;
            }
        }

        return ret;
    }


//    https://leetcode.cn/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int len=0,x=0,y=0;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                // 判断是否为回文串
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=i+1<j?dp[i+1][j-1]:true;
                // 回文串中找最大
                if(dp[i][j]==true){
                    if(len<j-i+1){
                        len=j-i+1;
                        x=i;
                        y=j;
                    }
                }
            }
        }

        return s.substring(x,y+1);
    }

//https://leetcode.cn/problems/palindrome-partitioning-iv/
    public boolean checkPartitioning(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=i+1<j?dp[i+1][j-1]:true;
            }
        }
        // 中间字符串i->j
        for(int i=1;i<n-1;i++){
            for(int j=i;j<n-1;j++){
                if(dp[0][i-1]&&dp[i][j]&&dp[j+1][n-1])
                    return true;
            }
        }
        return false;
    }


    //    https://leetcode.cn/problems/palindrome-partitioning-ii/
    public int minCut(String s) {
        int n=s.length();
        boolean[][] dp1=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp1[i][j]=i+1<j?dp1[i+1][j-1]:true;
                }
            }
        }
        int[] dp=new int[n];// 下标为结尾时最小分割次数
        for(int i=1;i<n;i++) dp[i]=Integer.MAX_VALUE;

        for(int i=1;i<n;i++){
            if(dp1[0][i]) dp[i]=0;
            else{
                for(int j=1;j<=i;j++){
                    if(dp1[j][i]){
                        dp[i]=Math.min(dp[i],dp[j-1]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}
