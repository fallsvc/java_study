package recursivesearchbacktrackin.floodfill;

class Solution2 {

    boolean[][] visit;
    int m;
    int n;
    public int numIslands(char[][] grid) {
//        https://leetcode.cn/problems/number-of-islands/
        m=grid.length;
        n=grid[0].length;
        visit=new boolean[m][n];

        int blockNum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&visit[i][j]==false){
                    dfs(grid,i,j);
                    blockNum++;
                }
            }
        }

        return blockNum;
    }
    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};

    public void dfs(char[][] grid,int i,int j){
        visit[i][j]=true;

        for(int k=0;k<4;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]=='1'&&visit[x][y]==false){
                dfs(grid,x,y);
            }
        }
    }
}