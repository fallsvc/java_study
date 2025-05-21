package dynamicprogramming.knapsackproblem;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/13  15:58
 */
public class Demo3 {
    class Solution1 {
//        https://leetcode.cn/problems/combination-sum-iv/
//        排列总和
        public int combinationSum42(int[] nums, int target) {
            int n= nums.length;
            int[] dp=new int[target+1]; // [i] 凑成i 的排列个数
            dp[0]=1;

            for(int i=1;i<=target;i++) {
                for(int j=0;j<n;j++) { // 选一个排列
                    if(i>=nums[j]) // 能凑i 且最后一个元素是nums[j]
                        dp[i]+=dp[i-nums[j]];
                }
            }
            return dp[target];
        }
        // 代码优化
        public int combinationSum4(int[] nums, int target) {
            int[] dp=new int[target+1]; // [i] 凑成i 的排列个数
            dp[0]=1;

            for(int i=1;i<=target;i++) {
                for(int x : nums) { // 选一个排列
                    if(i>=x) // 能凑i 且最后一个元素是x
                        dp[i]+=dp[i-x];
                }
            }
            return dp[target];
        }
    }
    class Solution2 {
//        https://leetcode.cn/problems/unique-binary-search-trees/
//        不同的二叉搜索树
        public int numTrees(int n) {
            int[] dp=new int[n+1];
            dp[0]=1;

            for(int i=1;i<=n;i++) { // 依次计算i个节点的不同二叉搜索树的个数
                for(int j=1;j<=i;j++) { // j为头节点
                    dp[i]+=dp[j-1]*dp[i-j];
                }
            }
            return dp[n];
        }
    }
}
