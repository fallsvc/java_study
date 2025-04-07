package recursivesearchbacktrackin.synthesisproblem;

class Solution11 {


//    https://leetcode.cn/problems/word-search/
    boolean[][] visit;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        visit=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    visit[i][j]=true;
                    if(dfs(board,i,j,word,1)) return true;
                    visit[i][j]=false;// 回溯
                }
            }
        }
        return false;
    }
    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};

    public boolean dfs(char[][] board,int i,int j,String word,int pos){

        if(pos==word.length()) return true;

        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x>=0&&x<m&&y>=0&&y<n&&visit[x][y]==false&&board[x][y]==word.charAt(pos)){
                visit[x][y]=true;
                if(dfs(board,x,y,word,pos+1)) return true;
                // 回溯
                visit[x][y]=false;
            }
        }
        return false;
    }




//    boolean[][] visit;
//    public boolean exist(char[][] board, String word) {
//        int m=board.length;
//        int n=board[0].length;
//        visit=new boolean[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(board[i][j]==word.charAt(0)){
//                    if(dfs(board,i,j,word,0)) return true;
//                }
//            }
//        }
//        return false;
//    }
//    public boolean dfs(char[][] board,int i,int j,String word,int pos){
//        // 找到了
//        if(pos==word.length()) return true;
//        // 位置不合法
//        if(i<0||i>=board.length||j<0||j>=board[0].length) return false;
//        if(visit[i][j]==false&&board[i][j]==word.charAt(pos)) {
//            visit[i][j]=true;
//            // 上
//            if(dfs(board,i-1,j,word,pos+1) ) return true;
//            // 下
//            if(dfs(board,i+1,j,word,pos+1) ) return true;
//            // 左
//            if(dfs(board,i,j-1,word,pos+1) ) return true;
//            // 右
//            if(dfs(board,i,j+1,word,pos+1) ) return true;
//
//            // 回溯
//            visit[i][j]=false;
//        }
//        return false;
//    }
}