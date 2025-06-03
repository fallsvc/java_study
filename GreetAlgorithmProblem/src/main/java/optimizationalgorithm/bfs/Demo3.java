package optimizationalgorithm.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/27  14:46
 */
public class Demo3 {

    class Solution1 {
//        https://leetcode.cn/problems/01-matrix/description/
//        01 矩阵 单源最短路问题
        int m;
        int n;
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public int[][] updateMatrix(int[][] mat) {
            m=mat.length;
            n=mat[0].length;
            int[][] dist=new int[m][n];
            // -1 未遍历到
            // !=-1 已经遍历过
            for(int i=0;i<m;i++) {
                Arrays.fill(dist[i],-1);
            }
            // 1. 加入源点
            Queue<int[]> q=new ArrayDeque<>();
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(mat[i][j]==0) {
                        q.offer(new int[]{i,j});
                        dist[i][j]=0;
                    }
                }
            }
            // 2.一层一层扩展
            while(!q.isEmpty()) {
                int size=q.size();
                while(size-- != 0) {
                    int[] t=q.poll();
                    for(int k=0;k<4;k++) {
                        int x=dx[k]+t[0],y=dy[k]+t[1];
                        if(x>=0&&x<m&&y>=0&&y<n&&dist[x][y]==-1) {
                            dist[x][y]=dist[t[0]][t[1]]+1;//赋值遍历到的点
                            q.offer(new int[]{x,y});
                        }
                    }
                }
            }

            return dist;
        }
    }

    class Solution2 {
//        https://leetcode.cn/problems/number-of-enclaves/
//         01矩阵 未被0包围的1
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};

        public int numEnclaves(int[][] grid) {

            int m=grid.length;
            int n=grid[0].length;

            Queue<int[]> q=new ArrayDeque<>();
            boolean[][] vis=new boolean[m][n];
            // 边界1 为源点 加入队列
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(i==0 ||i==m-1|| j==0 || j==n-1) {
                        if(grid[i][j]==1) {
                            q.offer(new int[]{i,j});
                            vis[i][j]=true;
                        }
                    }
                }
            }
            // 遍历未被包围
            while(!q.isEmpty()) {
                int size=q.size();

                while(size-- != 0) {
                    int[] t=q.poll();
                    int a=t[0],b=t[1];
                    for(int k=0;k<4;k++) {
                        int x=dx[k]+a,y=dy[k]+b;
                        if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1 &&vis[x][y]==false) {
                            q.offer(new int[]{x,y});
                            vis[x][y]=true;
                        }
                    }
                }
            }
            // 计算返回值
            int ret=0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j]==1 && vis[i][j]==false) ret++;
                }
            }
            return ret;
        }
    }
//    static int[] dx={0,0,-1,1};
//   static int[] dy={-1,1,0,0};
//
//    public static int numEnclaves(int[][] grid) {
//
//        int m=grid.length;
//        int n=grid[0].length;
//
//        Queue<int[]> q=new ArrayDeque<>();
//        boolean[][] vis=new boolean[m][n];
//        // 边界1 为源点 加入队列
//        for(int i=0;i<m;i++) {
//            for(int j=0;j<n;j++) {
//                if(i==0 ||i==m-1|| j==0 || j==n-1) {
//                    if(grid[i][j]==1) {
//                        q.offer(new int[]{i,j});
//                        vis[i][j]=true;
//                    }
//                }
//            }
//        }
//        // 遍历未被包围
//        while(!q.isEmpty()) {
//            int size=q.size();
//
//            while(size-- != 0) {
//                int[] t=q.poll();
//                int a=t[0],b=t[1];
//                for(int k=0;k<4;k++) {
//                    int x=dx[k]+a,y=dy[k]+b;
//                    if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1 &&vis[x][y]==false) {
//                        q.offer(new int[]{x,y});
//                        vis[x][y]=true;
//                    }
//                }
//            }
//        }
//        // 计算返回值
//        int ret=0;
//        for(int i=0;i<m;i++) {
//            for(int j=0;j<n;j++) {
//                if(grid[i][j]==1 && vis[i][j]==false) ret++;
//            }
//        }
//        return ret;
//    }


    class Solution3 {
        //        https://leetcode.cn/problems/map-of-highest-peak/
//        地图中的最高点
//        以水为源点层序遍历填写返回数组 依次填写高度
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public int[][] highestPeak(int[][] isWater) {
            int m = isWater.length;
            int n = isWater[0].length;
            boolean[][] vis=new boolean[m][n];
            int[][] dist=new int[m][n];//
            //
            // 初始化dist -1 未被搜索
            Queue<int[]> q=new ArrayDeque<>();
            for(int i=0;i < m;i++ ) {
                for(int j=0;j<n;j++) {
                    if(isWater[i][j]==1) {
                        dist[i][j]=0;
                        q.offer(new int[]{i,j});// 源点加入队列
                        vis[i][j]=true;
                    }else {
                        dist[i][j]=-1;
                    }

                }
            }
            // 多源遍历填写dist
            while(!q.isEmpty()) {
                int size=q.size();
                while(size--!=0) {
                    int[] t=q.poll();
                    int a=t[0],b=t[1];
                    for(int k=0;k<4;k++) {
                        int x=dx[k]+a,y=dy[k]+b;
                        if(x>=0&&x<m&&y>=0&&y<n&&dist[x][y]==-1&&vis[x][y]==false) {
                            q.offer(new int[]{x,y});
                            dist[x][y]=dist[a][b]+1;
                            vis[x][y]=true;
                        }
                    }
                }
            }
            return dist;
        }
    }

    class Solution4 {
        //        https://leetcode.cn/problems/as-far-from-land-as-possible/
//        地图分析
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public int maxDistance(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            boolean[][] vis=new boolean[m][n];
            int[][] dist=new int[m][n];
            // 初始化 dist -1 表示未遍历到
            // 填加源点 陆地点
            Queue<int[]> q=new ArrayDeque<>();
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j]==1) {
                        dist[i][j]=0;// 陆地
                        q.offer(new int[]{i,j});
                        vis[i][j]=true;
                    } else {
                        dist[i][j]=-1;// 海洋初始化为-1 未遍历
                    }
                }
            }
            // 宽度遍历
            int ret=-1;
            while(!q.isEmpty()) {
                int size=q.size();
                while(size--!=0) {
                    int[] t=q.poll();
                    int a=t[0],b=t[1];
                    for(int k=0;k<4;k++) {
                        int x=dx[k]+a,y=dy[k]+b;
                        if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==0&&vis[x][y]==false) {
                            dist[x][y]=dist[a][b]+1;
                            ret=Math.max(ret,dist[x][y]);
                            q.offer(new int[]{x,y});
                            vis[x][y]=true;
                        }
                    }
                }
            }
            return ret;
        }
    }
    public static void main(String[] args) {
        int[][] a={{0},{1},{1},{0},{0}};
//        numEnclaves(a);
    }
}
