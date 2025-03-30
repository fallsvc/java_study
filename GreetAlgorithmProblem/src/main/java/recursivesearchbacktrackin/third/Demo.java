package recursivesearchbacktrackin.third;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  15:09
 */
public class Demo {
    //    全排列
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();

    }

//    https://leetcode.cn/problems/permutations/
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        check=new boolean[nums.length];
        dfs(nums);
        return ret;
    }
    public void dfs(int[] nums){
        if(path.size()==nums.length){
            ret.add(new ArrayList(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(check[i]==false){
                path.add(nums[i]);
                check[i]=true;
                dfs(nums);
                // 回溯
                path.remove(path.size()-1);
                check[i]=false;
            }
        }
    }

//    https://leetcode.cn/problems/subsets/

//    List<List<Integer>> ret; // 注释防止和前面代码重名编译器报错
    List<Integer> list;
    public List<List<Integer>> subsets(int[] nums) {
        ret=new ArrayList<>();
        list=new ArrayList<>();

        dfs(nums,0);
        return ret;
    }
    public void dfs(int[] nums,int i){
        if(i==nums.length){
            ret.add(new ArrayList(list));
            return;
        }

        // 不选
        dfs(nums,i+1);
        // 选
        list.add(nums[i]);
        dfs(nums,i+1);
        // 回溯
        list.remove(list.size()-1);

    }

    // 解法二
//    List<List<Integer>> ret;
//    List<Integer> list;
//    public List<List<Integer>> subsets(int[] nums) {
//        ret=new ArrayList<>();
//        list=new ArrayList<>();
//
//        dfs(nums,0);
//        return ret;
//    }
//    public void dfs(int[] nums,int pos){
//        ret.add(new ArrayList(list));
//
//        for(int i=pos;i<nums.length;i++){
//            list.add(nums[i]);
//            dfs(nums,i+1);
//            // 回溯
//            list.remove(list.size()-1);
//        }
//
//    }

}
