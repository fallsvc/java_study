package dynamicprogramming.pathproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/17  16:12
 */
public class Demo1 {
//    https://leetcode.cn/problems/unique-paths/
    public int uniquePaths(int m, int n) {
        // 创建dp表
        int[][] arr=new int[m+1][n+1];
        arr[0][1]=1;// 初始化
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m][n];
    }
//    https://leetcode.cn/problems/unique-paths-ii/
    // 有障碍物的路径
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] dp=new int[row+1][col+1];
        dp[0][1]=1;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(obstacleGrid[i-1][j-1]!=1) dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }

        return dp[row][col];
    }
//https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
    // 宝石价值最大值问题
    public int jewelleryValue(int[][] frame) {
        int row=frame.length,col=frame[0].length;
        int[][] dp=new int[row+1][col+1];
        for(int i=1;i<=row;i++)
            for(int j=1;j<=col;j++)
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+frame[i-1][j-1];
        return dp[row][col];
    }

//    https://leetcode.cn/problems/minimum-falling-path-sum/
    //
    public static int minFallingPathSum(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] dp=new int[m+1][n+2];
        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i][n+1]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]))+matrix[i-1][j-1];
            }
        }
        // 遍历最后一行找最小值
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++){
            min=Math.min(dp[m][i],min);
        }
        return min;
    }

//    https://leetcode.cn/problems/minimum-path-sum/submissions/612277641/
    public int minPathSum(int[][] grid) {
        int m =grid.length,n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        // 初始化dp表
        for(int j=0;j<=n;j++) dp[0][j]=Integer.MAX_VALUE;
        for(int i=2;i<=m;i++) dp[i][0]=Integer.MAX_VALUE;
        dp[0][1]=dp[1][0]=0;
        // 赋值
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
//    https://leetcode.cn/problems/dungeon-game/submissions/612295500/
public int calculateMinimumHP(int[][] dungeon) {
    int m=dungeon.length,n=dungeon[0].length;
    int[][] dp=new int[m+1][n+1];
    for(int i=0;i<=m;i++) dp[i][n]=Integer.MAX_VALUE;
    for(int j=0;j<=n;j++) dp[m][j]=Integer.MAX_VALUE;
    dp[m][n-1]=dp[m-1][n]=1;
    for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
            dp[i][j]=Math.max(dp[i][j],1);
        }
    }
    return dp[0][0];
}
//https://leetcode.cn/problems/triangle/solutions/?envType=study-plan-v2&envId=dynamic-programming
    public static int minimumTotal(List<List<Integer>> triangle) {

        int m=triangle.size();
        if(m==1) return triangle.get(0).get(0);
        int n=triangle.get(m-1).size();
        int[][] dp=new int[m+1][n+1];
        // 初始化
        for(int i=0;i<=m;i++) dp[i][0]=Integer.MAX_VALUE;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j>i) dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[0][0]=0;
        //
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i>=j) dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i-1).get(j-1);
            }
        }

        // 找到最小值
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=n;j++){
            min=Math.min(min,dp[n][j]);
        }
        return min;
    }
//https://leetcode.cn/problems/find-pivot-index/
    // 中心点
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] f=new int[n];
        int[] g=new int[n];
        // 初始化f表
        f[0]=0;
        for(int i=1;i<n;i++) f[i]=f[i-1]+nums[i-1];
        // 初始化g表
        g[n-1]=0;
        for(int i=n-2;i>=0;i--) g[i]=g[i+1]+nums[i+1];
        for(int i=0;i<n;i++) if(f[i]==g[i]) return i;
//       没有找到
        return -1;
    }
    public static void main4(String[] args) {
//        int[][] m={{2,1,3},{6,5,4},{7,8,9}};
//        minFallingPathSum(m);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        a.add(2);
        list.add(a);
        List<Integer> b=new ArrayList<>();
        b.add(3);
        b.add(4);
        list.add(b);
        List<Integer> c=new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        list.add(c);
        List<Integer> d=new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        list.add(d);

        System.out.println(minimumTotal(list));
    }
//    https://leetcode.cn/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] f=new int[n];
        int[] g=new int[n];
        f[0]=nums[0];
        for(int i=1;i<n;i++) f[i]=f[i-1]*nums[i];
        g[n-1]=nums[n-1];
        for(int j=n-2;j>=0;j--) g[j]=g[j+1]*nums[j];
        int[] ret=new int[n];
        ret[0]=g[1];
        ret[n-1]=f[n-2];
        for(int i=1;i<n-1;i++)  ret[i]=f[i-1]*g[i+1];
        return ret;
    }
//    https://leetcode.cn/problems/subarray-sum-equals-k/submissions/612852484/
    public int subarraySum(int[] nums, int k) {
        int sum=0;// 记录当前前缀和
        HashMap<Integer,Integer> hash=new HashMap<>();// 记录所有前缀和
        hash.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int sub=sum-k;
            count+=hash.getOrDefault(sub,0);// 记录以当前位置为结尾的和为k的总子串个数
            // 采用sum-k=前面的前缀和
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
//        System.out.println(productExceptSelf(arr));
    }
}
