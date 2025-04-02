package recursivesearchbacktrackin.synthesisproblem;

class Solution8 {
	//https://leetcode.cn/problems/beautiful-arrangement/
    boolean[] check;
    int count;
    int path=1;
    public int countArrangement(int n) {
        check=new boolean[n+1];
        dfs(n);
        return count;
    }
    public void dfs(int n){
        if(path==n+1) {
            count++;
            return ;
        }
        for(int i=1;i<=n;i++){
            if(check[i]==false&&(i%path==0||path%i==0)){
                check[i]=true;
                path+=1;
                dfs(n);
                // 回溯
                check[i]=false;
                path-=1;
            }
        }
    }
}