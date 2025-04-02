package recursivesearchbacktrackin.synthesisproblem;

import java.util.ArrayList;
import java.util.List;


//https://leetcode.cn/problems/combinations/
class Solution5 {
    int k,n;
    List<Integer> path;
    List<List<Integer>> ret;
    public List<List<Integer>> combine(int _n, int _k) {
        k=_k;
        n=_n;
        path=new ArrayList<>();
        ret=new ArrayList<>();
        dfs(1);
        return ret;
    }
    public void dfs(int pos){
        
        if(path.size()==k){
            ret.add(new ArrayList(path));
            return;
        }

        for(int i=pos;i<=n;i++){
            // 选i
            path.add(i);
            dfs(i+1);
            // 回溯
            path.remove(path.size()-1);
        }
    }
}