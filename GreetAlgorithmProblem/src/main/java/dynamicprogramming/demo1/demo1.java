package dynamicprogramming.demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/12  15:20
 */
public class demo1 {
//    https://leetcode.cn/problems/three-steps-problem-lcci/submissions/609523705/
    public int waysToStep(int n) {
        // 处理无法进入公式
        if(n<=3){
            if(n==1) return 1;
            if(n==2) return 2;
            if(n==3) return 4;
        }
        int MOD=(int)1e9+7;// 题目要求防止溢出

        // 移动数组优化空间利用
        int a=1,b=2,c=4,d=0;
        for(int i=4;i<=n;i++){
            d=((a+b)%MOD+c)%MOD;
            a=b;
            b=c;
            c=d;
        }
        return d;
    }
//    https://leetcode.cn/problems/min-cost-climbing-stairs/submissions/609539299/
    public int minCostClimbingStairs2(int[] cost) {
        // 从左往右
        int len=cost.length;
        int[] dp=new int[len+1];
        for(int i=2;i<=len;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[len];
    }
    // 从右往左遍历
    public int minCostClimbingStairs3(int[] cost) {
        int len=cost.length;
        int[] dp=new int[len+1];
        dp[len-1]=cost[len-1];
        dp[len-2]=cost[len-2];
        for(int i=len-3;i>=0;i--){
            dp[i]=Math.min(dp[i+1],dp[i+2])+cost[i];
        }
        return Math.min(dp[0],dp[1]);
    }
    // 空间优化
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        int a=0,b=0,c=0;
        for(int i=2;i<=len;i++){
            c=Math.min(a+cost[i-2],b+cost[i-1]);
            a=b;
            b=c;
        }
        return c;
    }
//    https://leetcode.cn/problems/decode-ways/
    public int numDecodings(String ss) {
        char[] s=ss.toCharArray();
        int len=s.length;
        int[] dp=new int[len];

        if(s[0]!='0') dp[0]+=1;
        if(len==1) return dp[0];

        if(s[0]!='0'&&s[1]!='0') dp[1]+=1;
        int num=(s[0]-'0')*10+(s[1]-'0');
        if(num>=10&&num<=26) dp[1]+=1;
        if(len==2) return dp[1];

        for(int i=2;i<len;i++){
            if(s[i]!='0') dp[i]+=dp[i-1];
            int n=(s[i-1]-'0')*10+(s[i]-'0');
            if(n>=10&&n<=26) dp[i]+=dp[i-2];
        }
        return dp[len-1];
    }
    public int numDecodings2(String ss) {
        char[] s=ss.toCharArray();
        int len=s.length;
        int[] dp=new int[len+1];

        if(s[0]!='0') dp[1]+=1;
        if(len==1) return dp[1];
        dp[0]=1;

        for(int i=1;i<len;i++){
            if(s[i]!='0') dp[i+1]+=dp[i];
            int n=(s[i-1]-'0')*10+(s[i]-'0');
            if(n>=10&&n<=26) dp[i+1]+=dp[i-1];
        }
        return dp[len];
    }
}
