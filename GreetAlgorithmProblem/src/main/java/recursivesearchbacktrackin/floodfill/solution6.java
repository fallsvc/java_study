package recursivesearchbacktrackin.floodfill;

class solution6 {
//    https://leetcode.cn/problems/minesweeper/
    // 扫雷游戏
    int m;
    int n;
    public char[][] updateBoard(char[][] board, int[] click) {
        m=board.length;
        n=board[0].length;
        // 雷直接结束
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        // 展开
        dfs(board,click[0],click[1]);

        return board;
    }

    int[] dx={-1,-1,-1,0,0,1,1,1};
    int[] dy={-1,0,1,-1,1,-1,0,1};
    public void dfs(char[][] board,int i,int j){ 
        // 统计地雷个数
        int count=0;
        for(int k=0;k<8;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x>=0&&x<m&&y>=0&&y<n&&board[x][y]=='M'){
                count++;
            }
        }
        if(count==0){ // 没有雷
            board[i][j]='B';
            for(int k=0;k<8;k++){
                int x=dx[k]+i,y=dy[k]+j;
                if(x>=0&&x<m&&y>=0&&y<n&&board[x][y]=='E'){// 为E时进入
                    dfs(board,x,y);
                }
            }  
        }else{ // 有雷 
            board[i][j]=(char)(count + '0');
        }
    }
}