package optimizationalgorithm.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/19  14:25
 */
public class Demo1 {
    class Solution1 {
//        https://leetcode.cn/problems/flood-fill/
//        图像渲染
//        bfs 宽度遍历  队列
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int key=image[sr][sc];// 存需要修改颜色
            if(key==color) return image;// 需要修改和修改的结果一致 -》不用修改

            int m=image.length;
            int n=image[0].length;

            // 使用队列bfs 宽度遍历需要修改节点
            Queue<int[]> q=new ArrayDeque<>();
            boolean[][] visit=new boolean[m][n];
            q.offer(new int[]{sr,sc});
            while(!q.isEmpty()) {
                int size=q.size();
                for(int i=0;i<size;i++) {
                    // 修改当前节点
                    int[] tmp=q.poll();
                    int a=tmp[0],b=tmp[1];
                    image[a][b]=color;
                    visit[a][b]=true;
                    // 添加下一层未改节点
                    for(int k=0;k<4;k++){
                        int x=a+dx[k],y=b+dy[k];
                        if(x>=0 && x<m && y>=0 && y<n &&
                                image[x][y]==key&&visit[x][y]==false ){
                            q.offer(new int[]{x,y});
                        }
                    }
                }
            }
            return image;
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
    }

    public static void main(String[] args) {
        char[][] a={{'1','2','3'},{'2','2'}};
        System.out.println(a.length);

    }

    class Solution2 {
//  https://leetcode.cn/problems/number-of-islands/submissions/630906466/
//        岛屿数量
        boolean[][] visit;
        int m;
        int n;
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public int numIslands(char[][] grid) {
            m=grid.length;
            n=grid[0].length;
            visit=new boolean[m][n];


            int blockNum=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]=='1'&& visit[i][j]==false){
                        bfs(grid,i,j);
                        blockNum++;
                    }
                }
            }
            return blockNum;
        }
        public void bfs(char[][] grid,int i,int j) {
            Queue<int[]> q=new ArrayDeque<>();
            q.offer(new int[]{i,j});
            visit[i][j]=true;

            while(!q.isEmpty()) {
                int size=q.size();

                for(int a=0;a<size;a++) {
                    int[] p=q.poll();

                    for(int k=0;k<4;k++) {
                        int x=dx[k]+p[0],y=dy[k]+p[1];
                        if(x>=0 && x<m && y>=0 && y<n && grid[x][y]=='1' && visit[x][y]==false) {
                            q.offer(new int[]{x,y});
                            visit[x][y]=true;
                        }
                    }
                }
            }
        }
    }

    class Solution3 {
//        https://leetcode.cn/problems/max-area-of-island/
//        岛屿的最大面积
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

                        count=bfs(grid,i,j);
                        ret=Math.max(ret,count);
                    }
                }
            }
            return ret;
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public int bfs(int[][] grid,int i,int j){
            Queue<int[]> q=new ArrayDeque<>();
            q.offer(new int[]{i,j});
            visit[i][j]=true;

            int ret=0;
            while(!q.isEmpty()) {
                int size=q.size();
                for(int a=0;a<size;a++) {
                    int[] t=q.poll();
                    ret++;
                    for(int k=0;k<4;k++){
                        int x=dx[k]+t[0],y=dy[k]+t[1];
                        if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1&&visit[x][y]==false){
                            q.offer(new int[]{x,y});
                            visit[x][y]=true;
                        }
                    }
                }
            }

            return ret;
        }
    }

    class Solution4 {
//        https://leetcode.cn/problems/surrounded-regions/
//        被包围的区域  'O' ->  'x'
        // 1.先把边缘不需要覆盖的'O' 改为 '.'
        // 2.遍历数组把 'O' -> 'X'
        //              '.' -> 'O'
        int m;
        int n;
        public void solve(char[][] board) {
            m=board.length;
            n=board[0].length;

            for(int i=0;i<n;i++){
                if(board[0][i]=='O'){
                    bfs(board,0,i);
                }
                if(board[m-1][i]=='O'){
                    bfs(board,m-1,i);
                }
            }
            for(int i=0;i<m;i++){
                if(board[i][0]=='O'){
                    bfs(board,i,0);
                }
                if(board[i][n-1]=='O'){
                    bfs(board,i,n-1);
                }
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]=='O') board[i][j]='X';
                    if(board[i][j]=='.') board[i][j]='O';// 这句不能在前面
                }
            }
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public void bfs(char[][] board,int i,int j){
            Queue<int[]> q=new ArrayDeque<>();
            board[i][j]='.';
            q.offer(new int[]{i,j});

            while(!q.isEmpty()) {
                int size=q.size();
                for(int a=0;a<size;a++) {
                    int[] t=q.poll();

                    for(int k=0;k<4;k++){
                        int x=dx[k]+t[0],y=dy[k]+t[1];
                        if(x>=0&&x<m&&y>=0&&y<n&&board[x][y]=='O'){
                            q.offer(new int[]{x,y});
                            board[x][y]='.';
                        }
                    }
                }
            }
        }
    }
}
