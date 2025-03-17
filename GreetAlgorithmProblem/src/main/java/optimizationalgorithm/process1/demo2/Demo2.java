package optimizationalgorithm.process1.demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/11  17:31
 */
public class Demo2 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list=new ArrayList<>();

        Map<String,Integer> hash1=new HashMap<>();
        Map<String,Integer> hash2=new HashMap<>();
        // words放入hash2
        for(String a:words) hash2.put(a,hash2.getOrDefault(a,0)+1);

        int len=words[0].length(),m=words.length;
        for(int k=0;k<len;k++){
            for(int left=k,right=k,count=0;right+len<=s.length();right+=len){
                // 入窗口 维护count
                String str=s.substring(right,right+len);
                hash1.put(str,hash1.getOrDefault(str,0)+1);
                if(hash1.get(str)<=hash2.getOrDefault(str,0)) count++;
                // 判断
                if(right-left+1>m*len){ // 注意大小
                    // 出窗口
                    String leftStr=s.substring(left,left+len);
                    if(hash1.get(leftStr)<=hash2.getOrDefault(leftStr,0)) count--;
                    hash1.put(leftStr,hash1.get(leftStr)-1);
                    left+=len;
                }
                if(count==m) list.add(left);
            }
            hash1.clear(); // 如果在第一层循环外这个需要清空
        }
        return list;
    }

//    https://leetcode.cn/problems/minimum-window-substring/
    public String minWindow(String s, String t) {
        int[] hash1=new int[128];// 统计t字符的频率
        int[] hash2=new int[128];// 窗口字符频率

        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int kinds=0;// t中字符有多少种
        for(char a:s2) if(hash1[a]++==0) kinds++;
        int n=s1.length;
        int len=Integer.MAX_VALUE;// 最小子串
        int minLeft=-1;
        for(int left=0,right=0,count=0;right<n;right++){
            // 入窗口
            char in=s1[right];
            hash2[in]++;
            if(hash2[in]==hash1[in]) count++;// 维护count有效字符种类
            // 判断
            while(count==kinds){
                if(len>right-left+1){
                    len=right-left+1;
                    minLeft=left;
                }
                char out=s1[left++];
                if(hash2[out]--==hash1[out]) count--;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(minLeft,minLeft+len);
    }

    // 二分查找
//    https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
    public int[] searchRange(int[] nums, int target) {
        int[] ret={-1,-1};
        if(nums==null||nums.length==0) return ret;
        int left=0,right=nums.length-1;
        // 找左端点 1.left<right
        while(left<right){
            // 2. 求mid
            int mid=left+(right-left)/2;//偶数左
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        // 3.判断是否有值
        if(nums[left]==target){
            ret[0]=right;
        }else{
            return ret;
        }
        right=nums.length-1;
        // 二分右端点
        while(left<right){
            int mid=left+(right-left+1)/2;//需找偶右点
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        ret[1]=right;

        return ret;
    }
//    https://leetcode.cn/problems/sqrtx/
    // x 的算术平方根
public int mySqrt(int x) {
    if(x<1) return 0;
    long left=1,right=x;
    while(left<right){
        long mid=left+(right-left+1)/2;
        long num=mid*mid;
        if(num>x) right=mid-1;
        else left=mid;
    }
    return (int)left;
}
//    https://leetcode.cn/problems/search-insert-position/submissions/611799448/
    // 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        // 处理边界
        if(nums[right]<target) return right+1;
        // 找左端点
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target) right=mid;
            else left=mid+1;
        }
        return left;
    }
    public static void main2(String[] args) {
//       String  s ="qqqqqqqqqq";
//        String[] words ={"qq","qq"};
//        System.out.println(findSubstring(s, words));
        int n=2147395599;
//        System.out.println(mySqrt(n));
    }
}
