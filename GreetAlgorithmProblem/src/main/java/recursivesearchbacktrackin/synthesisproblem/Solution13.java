package recursivesearchbacktrackin.synthesisproblem;

class Solution13 {
//    https://leetcode.cn/problems/unique-paths-iii/
    boolean[][] visit;
    int m;
    int n;
    int count;
    int pathCount;
    public int uniquePathsIII(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visit=new boolean[m][n];

        int x=0,y=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count++;
                }else if(grid[i][j]==1){
                    x=i;
                    y=j;
                }  
            }
        }
        count+=2;// 算上起始和结束位置
        visit[x][y]=true;
        dfs(grid,x,y,1);
        return pathCount;
    }
    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};
    public void dfs(int[][] grid,int i,int j,int path){
        if(grid[i][j]==2){
            if(path==count){
                pathCount++;
            }
             return;
        }

        for(int k=0;k<4;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x>=0&&x<m&&y>=0&&y<n&&visit[x][y]==false&&grid[x][y]!=-1){
                visit[x][y]=true;
                dfs(grid,x,y,path+1);
                //回溯
                visit[x][y]=false;
            }
        }

    }
}