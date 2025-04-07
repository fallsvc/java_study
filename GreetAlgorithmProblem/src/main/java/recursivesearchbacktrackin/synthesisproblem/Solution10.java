package recursivesearchbacktrackin.synthesisproblem;

class Solution10 {
//    https://leetcode.cn/problems/sudoku-solver/
    boolean[][] row;
    boolean[][] col;
    boolean[][][] grid;
    public void solveSudoku(char[][] board) {
        int n=board.length;
        row=new boolean[n][10];
        col=new boolean[n][10];
        grid=new boolean[3][3][10];
        // 初始化
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j]-'0';
                    row[i][num]=col[j][num]=grid[i/3][j/3][num]=true;
                }
            }
        }
        dfs(board);
    }
    public boolean dfs(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(int k=1;k<=9;k++){
                        if(row[i][k]==false&&col[j][k]==false&&grid[i/3][j/3][k]==false){
                            board[i][j]=(char)(k+'0');
                            row[i][k]=col[j][k]=grid[i/3][j/3][k]=true;
                            // 
                            boolean ret=dfs(board);
                            if(ret==true) return true;// 填对
                            // 回溯
                            board[i][j]='.';
                            row[i][k]=col[j][k]=grid[i/3][j/3][k]=false;     
                        }
                    }
                    return false;// 没有数可以填
                }
            }
        }
        return true;// 填完
    }
}