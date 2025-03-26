package dynamicprogramming.houserobberproblem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/19  17:52
 */
public class Demo1 {
//    https://leetcode.cn/problems/the-masseuse-lcci/description/
    public int massage(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int[] f=new int[n];// 选当前节点最大时间
        int[] g=new int[n];// 不选当前节点的最大时间

        f[0]=nums[0];
        for(int i=1;i<n;i++){
            f[i]=g[i-1]+nums[i];
            g[i]=Math.max(g[i-1],f[i-1]);
        }

        return Math.max(g[n-1],f[n-1]);
    }

//    https://leetcode.cn/problems/house-robber-ii/
    public int rob(int[] nums){

        int n=nums.length;

        return Math.max(nums[0]+rob1(nums,2,n-2),rob1(nums,1,n-1));
    }

    public int rob1(int[] nums,int left,int right) {
        if(left>right) return 0;
        int n=nums.length;
        int[] f=new int[n];// f选择这点最大值
        int[] g=new int[n];// g不选这点
        f[left]=nums[left++];
        while(left<=right){
            f[left]=nums[left]+g[left-1];
            g[left]=Math.max(f[left-1],g[left-1]);
            left++;
        }
        return Math.max(f[right],g[right]);
    }

    public int rob1plus(int[] nums,int left,int right) {
        int pre =0,cur=0,tmp;
        while(left<=right){
            tmp=cur;
            cur=Math.max(pre+nums[left],cur);
            pre=tmp;
            left++;
        }
        return cur;
    }
//    https://leetcode.cn/problems/delete-and-earn/
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int x:nums) max=Math.max(max,x);
        int[] a=new int[max+1];
        // 把下标等于该值的加在该值等同下标
        for(int x:nums) a[x]+=x;

        // 打家劫舍
        int pre=0,cur=0;
        for(int x:a){
            int tmp=cur;
            cur=Math.max(cur,pre+x);
            pre=tmp;
        }

        return cur;
    }
    public int deleteAndEarn2(int[] nums) {
        int max=0;
        for(int x:nums) max=Math.max(max,x);
        int[] a=new int[max+1];
        // 把下标等于该值的加在该值等同下标
        for(int x:nums) a[x]+=x;

        // 打家劫舍
        int[] f=new int[max+1];// 选这个的最大
        int[] g=new int[max+1];// 不选这个的最大
        f[0]=a[0];
        for(int i=1;i<=max;i++){
            f[i]=g[i-1]+a[i];
            g[i]=Math.max(g[i-1],f[i-1]);
        }

        return Math.max(f[max],g[max]);
    }
//    https://leetcode.cn/problems/JEj789/submissions/614779823/
    public int minCost(int[][] costs) {
        int m=costs.length;
        int n=3;
        int[][] dp=new int[m+1][3];
        for(int i=1;i<=m;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i-1][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i-1][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+costs[i-1][2];
        }
        return Math.min(Math.min(dp[m][0],dp[m][1]),dp[m][2]);
    }

}
