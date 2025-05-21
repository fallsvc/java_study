package optimizationalgorithm.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

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

    public static void main1(String[] args) {
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

    class Solution5 {
//        https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/
//        最近迷宫出口

        int m;
        int n;
        boolean[][] visit;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        public int nearestExit(char[][] maze, int[] entrance) {
            m=maze.length;
            n=maze[0].length;
            visit=new boolean[m][n];// 是否经过

            return  bfs(maze,entrance);
        }
        public int bfs(char[][] maze,int[] entrance) {
            int count=-1;

            Queue<int[]> q=new ArrayDeque<>();
            visit[entrance[0]][entrance[1]]=true;
            q.offer(new int[]{entrance[0],entrance[1]});

            while(!q.isEmpty()) {
                count++;
                int size=q.size();
                for(int i=0;i<size;i++) {
                    int[] t=q.poll();
                    for(int k=0;k<4;k++) {
                        int x=dx[k]+t[0],y=dy[k]+t[1];
                        if(x>=0 && x<m &&y>=0 && y<n) {
                            // 是否能再走
                            if(maze[x][y]=='.' &&visit[x][y]==false)
                                q.offer(new int[]{x,y});
                            visit[x][y]=true;
                        }else{ // 下一个越界
                            //能出
                            if(count!=0) return count;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main2(String[] args) {
        char[] arr={'a','a'};
        StringBuilder stringBuilder=new StringBuilder("asd");
        String s="asd";
        System.out.println(stringBuilder.toString().equals(s));
        Set<Integer> set=new HashSet<>();
        System.out.println(arr.toString());

    }

    public static void main(String[] args) {
        String[] a={"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"};
//        minMutation("AACCGGTT","AAACGGTA",a);
    }
    class Solution6 {
//        https://leetcode.cn/problems/minimum-genetic-mutation/
//        最小基因变化
        char[] ge={'A','C','G','T'};
        public int minMutation(String startGene, String endGene, String[] bank){
            if(bank.length==0) return -1;// 边界
            Queue<String> q=new ArrayDeque<>();
            q.offer(startGene);
            char[] end=endGene.toCharArray();
            // 存放bank
            Set<String> set=new HashSet();
            // 已经遍历过的
            Set<String> set2=new HashSet();
            set2.add(startGene);

            for(String x : bank) {
                set.add(x);
            }
            int count=0;// 返回值

            while(!q.isEmpty()) {
                count++;
                int size=q.size();
                for(int j=0;j<size;j++) {
                    String t=q.poll();
                    char[] tmp=t.toCharArray();
                    for(int i=0;i<end.length;i++) {
                        for(int k=0;k<4;k++) {
                            if(tmp[i]!=ge[k]) {
                                char ch=tmp[i];// 等下用于还原数组
                                tmp[i]=ge[k];
                                String a=new String(tmp);
                                if(set.contains(a)&&!set2.contains(a)) {
                                    // 判断返回
                                    if(endGene.equals(a)) {
                                        return count;
                                    }
                                    q.offer(a);
                                    set2.add(a);
                                }
                                tmp[i]=ch;// 不能在过程中continue 不然会使本来可以复原的数据 无法复原
                            }
                        }
                    }
                }

            }
            return -1;
        }
    }
}
