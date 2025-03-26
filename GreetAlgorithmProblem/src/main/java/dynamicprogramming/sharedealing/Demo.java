package dynamicprogramming.sharedealing;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  10:29
 */
public class Demo {
    //    https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][3];// 0 买入 1可交易 2 冷冻期
        dp[0][0]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2]=dp[i-1][0]+prices[i];
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        // 划分两种状态 考虑状态变化过程
        int[] f=new int[n];// 买入
        int[] g=new int[n];// 卖出
        f[0]=-prices[0];
        for(int i=1;i<n;i++){
            f[i]=Math.max(f[i-1],g[i-1]-prices[i]);
            g[i]=Math.max(g[i-1],f[i-1]+prices[i]-fee);
        }
        return Math.max(f[n-1],g[n-1]);
    }
//    https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/submissions/615659045/
    public int maxProfit2(int[] prices) {
        int n=prices.length;
        int[][] f=new int[n][3];// 买入状态,0-2次交易
        int[][] g=new int[n][3];// 卖出状态
        // 初始化
        for(int i=0;i<3;i++)
            f[0][i]=g[0][i]=Integer.MIN_VALUE/2;// 防止溢出
        f[0][0]=-prices[0];
        g[0][0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                f[i][j]=Math.max(f[i-1][j],g[i-1][j]-prices[i]);
                g[i][j]=g[i-1][j];
                if(j-1>=0)
                    g[i][j]=Math.max(g[i][j],f[i-1][j-1]+prices[i]);// 卖出
            }
        }
        int max=Integer.MIN_VALUE/2;
        for(int i=0;i<3;i++)
            max=max<g[n-1][i]?g[n-1][i]:max;

        return max;
    }
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] f=new int[n][k+1];// 买入状态0-k次交易
        int[][] g=new int[n][k+1];// 卖出状态
        int M=0x3f3f3f3f;// 防溢出
        for(int i=0;i<=k;i++)
            f[0][i]=g[0][i]=-M;
        f[0][0]=-prices[0];
        g[0][0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                f[i][j]=Math.max(f[i-1][j],g[i-1][j]-prices[i]);
                g[i][j]=g[i-1][j];
                if(j-1>=0) g[i][j]=Math.max(g[i][j],f[i-1][j-1]+prices[i]);
            }
        }
        // 找最大值
        int max=-M;
        for(int i=0;i<=k;i++)
            max=max>g[n-1][i]?max:g[n-1][i];

        return max;
    }


}
