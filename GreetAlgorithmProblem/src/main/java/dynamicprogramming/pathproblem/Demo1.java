package dynamicprogramming.pathproblem;

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
    public static void main(String[] args) {
        int[][] m={{2,1,3},{6,5,4},{7,8,9}};
        minFallingPathSum(m);
    }
}
