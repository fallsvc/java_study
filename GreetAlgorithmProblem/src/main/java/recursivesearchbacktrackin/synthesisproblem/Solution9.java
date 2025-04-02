package recursivesearchbacktrackin.synthesisproblem;

import java.util.ArrayList;
import java.util.List;

class Solution9 {
	//https://leetcode.cn/problems/n-queens/
    boolean[] col;
    boolean[] dig1;
    boolean[] dig2;// 主对角线 
    List<List<String>> ret;
    char[][] path;
    public List<List<String>> solveNQueens(int n) {
        col=new boolean[n];
        dig1=new boolean[2*n];
        dig2=new boolean[2*n];
        path=new char[n][n];
        ret=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                path[i][j]='.';
            }
        }

        dfs(n,0);
        return ret;
    }

    public void dfs(int n,int row){
        if(row==n) {
            List<String> tmp=new ArrayList<>();
            for(int i=0;i<n;i++){
                tmp.add(new String(path[i]));
            } 
            ret.add(tmp);
            return;
        }

        for(int j=0;j<n;j++){
            if(col[j]==false&&dig1[row-j+n]==false&&dig2[row+j]==false){
                col[j]=dig1[row-j+n]=dig2[row+j]=true;
                path[row][j]='Q';
                dfs(n,row+1);
                // 回溯
                col[j]=dig1[row-j+n]=dig2[row+j]=false;
                path[row][j]='.';
            }
        }
    }
    //https://leetcode.cn/problems/valid-sudoku/
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][10];
        boolean[][] col=new boolean[9][10];
        boolean[][][] b=new boolean[3][3][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int n=board[i][j]-'0';
                    if(row[i][n]||col[j][n]||b[i/3][j/3][n]){
                        return false;
                    }
                    row[i][n]=col[j][n]=b[i/3][j/3][n]=true;
                }
            }
        }
        return true;
    }
}