package optimizationalgorithm.hash;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/27  14:07
 */
public class Demo1 {
    class Solution1 {
//        https://leetcode.cn/problems/two-sum/
        // 两数之和
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hash=new HashMap<>();//<nums[i],i>

            for(int i=0;i<nums.length;i++){
                int val=target-nums[i];
                if(hash.containsKey(val)){
                    return new int[]{i,hash.get(val)};
                }
                hash.put(nums[i],i);
            }
            return new int[]{-1,-1};
        }
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        HashSet<Integer> hashSet=new HashSet<>();

    }

    class Solution2 {
//        https://leetcode.cn/problems/check-permutation-lcci/
//        判断是否为字符串重排
        public boolean CheckPermutation(String ss1, String ss2) {
            if(ss1.length()!=ss2.length()) return false;
            int[] hash=new int[26];
            char[] s1=ss1.toCharArray();
            char[] s2=ss2.toCharArray();
            for(char ch:s1){
                hash[ch-'a']++;
            }
            for(char ch:s2){
                int val=ch-'a';
                hash[val]--;
                if(hash[val]<0) return false;
            }
            return true;
        }
    }
    class Solution3 {
//        https://leetcode.cn/problems/contains-duplicate/
//        存在重复元素
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for(int x:nums){
                if(set.contains(x)) return true;
                set.add(x);
            }
            return false;
        }
    }
    class Solution4 {
//        https://leetcode.cn/problems/contains-duplicate-ii/
//        存在重复元素
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer,Integer> hash=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(hash.containsKey(nums[i])&&(i-hash.get(nums[i]))<=k)
                    return true;
                hash.put(nums[i],i);
            }

            return false;
        }
    }
    class Solution5 {
//        https://leetcode.cn/problems/group-anagrams/
//        字母异位词分组
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,List<String>> hash=new HashMap<>();
            // 1. 分组
            for(String s:strs){
                char[] tmp=s.toCharArray();
                Arrays.sort(tmp);
                String n=new String(tmp);
                if(!hash.containsKey(n)) hash.put(n,new ArrayList());

                hash.get(n).add(s);
            }
            // 2. 组合

            return new ArrayList<>(hash.values());
        }
    }


}
