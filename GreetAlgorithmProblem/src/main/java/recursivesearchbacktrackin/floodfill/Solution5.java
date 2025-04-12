package recursivesearchbacktrackin.floodfill;

import java.util.ArrayList;
import java.util.List;

class Solution5 {
//   https://leetcode.cn/problems/pacific-atlantic-water-flow/submissions/620515204/
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        boolean[][] pV=new boolean[m][n];
        boolean[][] aV=new boolean[m][n];
        // 向上找能到的峰
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pV);
            dfs(heights,i,n-1,aV);
        }
        for(int j=0;j<n;j++){
            dfs(heights,0,j,pV);
            dfs(heights,m-1,j,aV);
        }
        // 两个洋都能到的峰
        List<List<Integer>> ret=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pV[i][j]&&aV[i][j]){
                    List<Integer> tmp= new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(j);
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }

    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};
    public void dfs(int[][] heights,int i,int j,boolean[][] v){
        v[i][j]=true;
        
        for(int k=0;k<4;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x>=0&&x<m&&y>=0&&y<n&&v[x][y]==false&&heights[x][y]>=heights[i][j]) // 这里的x,y, i, j一定要分清楚

                dfs(heights,x,y,v);
            }
    }
}