package recursivesearchbacktrackin.synthesisproblem;

import java.util.ArrayList;
import java.util.List;

//http://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/
class Solution1 {

//    https://leetcode.cn/problems/sum-of-all-subset-xor-totals/
//    int pre=0;
//    int ret=0;
//    public int subsetXORSum(int[] nums) {
//        dfs(nums,0);
//        return ret;
//    }
//    public void dfs(int[] nums,int pos){
//        ret+=pre;
//        for(int i=pos;i<nums.length;i++){
//            pre^=nums[i];
//            dfs(nums,i+1);
//            // 回溯
//            pre^=nums[i];
//        }
//    }


    int pre=0;
    int ret=0;
    public int subsetXORSum(int[] nums) {
        dfs(nums,0);
        return ret;
    }
    public void dfs(int[] nums,int pos){

        if(pos==nums.length){
            ret+=pre;
            return;
        }
        //选
        pre^=nums[pos];
        dfs(nums,pos+1);
        pre^=nums[pos];// 回溯

        dfs(nums,pos+1);
    }
    public static void main1(String[] args) {
//        Solution1 solution=new Solution1();
//        int[] ret= {1,3};
//        solution.subsetXORSum(ret);
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        list1.add(1);
        list2.add(1);
        list1.add(2);
        List<List<Integer>> list=new ArrayList<>();
        list.add(list1);
//        System.out.println(list.contains(list2));
        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());
    }

    public static void main(String[] args) {
        System.out.println('1'-'0');
        String a="adf";
        StringBuilder stringBuilder=new StringBuilder();
    }
}