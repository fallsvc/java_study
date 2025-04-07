package recursivesearchbacktrackin.synthesisproblem;

class Solution12 {
//    https://leetcode.cn/problems/path-with-maximum-gold/
    boolean[][] visit;
    int m;
    int n;
    int ret;
    public int getMaximumGold(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visit=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    visit[i][j]=true;
                    dfs(grid,i,j,grid[i][j]);
                    visit[i][j]=false;
                }
            }
        }
        return ret;
    }
    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};
    public void dfs(int[][] grid,int i,int j,int path){
        ret=Math.max(path,ret);
        for(int k=0;k<4;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x>=0&&x<m&&y>=0&&y<n&&visit[x][y]!=true&&grid[x][y]!=0){
                visit[x][y]=true;
                dfs(grid,x,y,path+grid[x][y]);

                visit[x][y]=false;// 回溯
            }
             
        }
    }
}