package recursivesearchbacktrackin.synthesisproblem;

class Solution6 {
//    int count;
//    int sum;
//    public int findTargetSumWays(int[] nums, int target) {
//        dfs(nums,0,target);
//        return count;
//    }
//
//    public void dfs(int[] nums,int pos, int target){
//        if(pos==nums.length){
//            if(sum==target) count++;
//            return;
//        }
//        // +
//        sum+=nums[pos];
//        dfs(nums,pos+1,target);
//        // 回溯
//        sum-=nums[pos];
//
//        // -
//        sum-=nums[pos];
//        dfs(nums,pos+1,target);
//        // 回溯
//        sum+=nums[pos];
//    }


    int count;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0,0,target);
        return count;
    }

    public void dfs(int[] nums,int pos,int sum, int target){
        if(pos==nums.length){
            if(sum==target) count++;
            return;
        }
        // +
        dfs(nums,pos+1, sum+nums[pos],target);
        // -
        dfs(nums,pos+1,sum-nums[pos],target);

    }
}