package dynamicprogramming.test1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/12  18:17
 */
public class Test1 {
//    https://leetcode.cn/problems/delete-and-earn/solutions/?envType=study-plan-v2&envId=dynamic-programming
public static int deleteAndEarn(int[] nums) {
    int mx = 0;
    for (int x : nums) {
        mx = Math.max(mx, x);
    }

    int[] a = new int[mx + 1];
    for (int x : nums) {
        a[x] += x; // 统计等于 x 的元素之和
    }

    return rob(a);
}

    // 198. 打家劫舍
    private static int rob(int[] nums) {
        int f0 = 0;
        int f1 = 0;
        for (int x : nums) {
            int newF = Math.max(f1, f0 + x);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }


    public static void main(String[] args) {
        int[] nums ={2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }
}
