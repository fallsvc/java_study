package recursivesearchbacktrackin.floodfill;

class Solution7 {
    //https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
     // 整理衣柜
    int m,n,cnt;
    int count;
    boolean[][] visit;

    public int wardrobeFinishing(int _m, int _n, int _cnt) {
        m=_m;
        n=_n;
        cnt=_cnt;
        visit=new boolean[m][n];
        dfs(0,0);

        return count;
    }
    int[] dx={0,1};
    int[] dy={1,0};
    public void dfs(int i,int j){
        visit[i][j]=true;
        count++;

        for(int k=0;k<2;k++){
            int x=dx[k]+i,y=dy[k]+j;
            if(x<m&&y<n&&visit[x][y]==false&&check(x,y)){
                dfs(x,y);
            }
        }
    }

    public boolean check(int x,int y){
        int tmp=0;
        while(x!=0){
            tmp+=x%10;
            x/=10;
        }
        while(y!=0){
            tmp+=y%10;
            y/=10;
        }
        return tmp<=cnt;
    }
}