package recursivesearchbacktrackin.floodfill;

class Solution3 {
//    https://leetcode.cn/problems/max-area-of-island/
    boolean[][] visit;
    int m;
    int n;
    int count;


    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visit=new boolean[m][n];
        int ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&visit[i][j]==false){
                    count=0;
                    dfs(grid,i,j);
                    ret=Math.max(ret,count);
                }
            }
        }
        return ret;
    }
    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};
    public void dfs(int[][] grid,int i,int j){
        count++;
        visit[i][j]=true;

        for(int k=0;k<4;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1&&visit[x][y]==false){
                dfs(grid,x,y);
            }
        }
    }
}