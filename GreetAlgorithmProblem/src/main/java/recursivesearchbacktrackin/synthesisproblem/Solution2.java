package recursivesearchbacktrackin.synthesisproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.cn/problems/permutations-ii/description/
class Solution2 {
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] f;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        f=new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return ret;
    }
    public void dfs(int[] nums){
        if(path.size()==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            // 剪枝  同层0下标可以选,不和前面相等可以选，和前面相等且前面为上层可选
            if(f[i]==false&&(i==0||nums[i]!=nums[i-1]||f[i-1]==true)){
                f[i]=true;
                path.add(nums[i]);
                dfs(nums);
                // 回溯
                f[i]=false;
                path.remove(path.size()-1);
            }
        }
    
    }
}