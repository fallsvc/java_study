package recursivesearchbacktrackin.grouptotal;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    // https://leetcode.cn/problems/combination-sum/

    // 方式1，一个一个选

//    int sum;
//    List<Integer> path;
//    List<List<Integer>> ret;
//    public List<List<Integer>> combinationSum(int[] candidates, int target){
//        path=new ArrayList<>();
//        ret=new ArrayList<>();
//        dfs(candidates,0,target);
//
//        return ret;
//    }
//    public void dfs(int[] candidates,int pos,int target){
//        if(target==sum) ret.add(new ArrayList(path));
//
//        if(sum>target||pos==candidates.length) return;
//
//        for(int i=pos;i<candidates.length;i++){
//            // 选
//            sum+=candidates[i];
//            path.add(candidates[i]);
//            dfs(candidates,i,target);
//            // 回溯
//            sum-=candidates[i];
//            path.remove(path.size()-1);
//        }
//
//    }


    // 方式2   先一个数选 0 - n个
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();

    }


    int target;
    List<Integer> path;
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int _target){
        target=_target;
        path=new ArrayList<>();
        ret=new ArrayList<>();
        dfs(candidates,0,0);

        return ret;
    }
    public void dfs(int[] candidates,int pos,int sum){
        if(target==sum){
            ret.add(new ArrayList<>(path));
            return;
        }

        if(sum>target||pos==candidates.length) return;

        for(int k=0;k*candidates[pos]+sum<=target;k++){
            if(k!=0) path.add(candidates[pos]);
            dfs(candidates,pos+1,sum+k*candidates[pos]);
        }
        for(int k=1;k*candidates[pos]+sum<=target;k++){
            path.remove(path.size()-1);
        }
    }

}