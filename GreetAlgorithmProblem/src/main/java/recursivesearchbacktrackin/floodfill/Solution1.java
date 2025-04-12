package recursivesearchbacktrackin.floodfill;

class Solution1 {
    int orinal;// 需要修改值
    // m,n 设置为全局防止 多次计算
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image; // 无需修改


        orinal=image[sr][sc];
        //
        m=image.length;
        n=image[0].length;


        dfs(image,sr,sc,color);
        return image;
    }
    // 坐标数组
    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};
    public void dfs(int[][] image,int i,int j,int color){
        image[i][j]=color;// 符合条件直接赋值

        // 上下左右在符合条件的值
        for(int k=0;k<4;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x>=0&&x<m&&y>=0&&y<n&&image[x][y]==orinal)
                dfs(image,x,y,color);
        }
    }
}