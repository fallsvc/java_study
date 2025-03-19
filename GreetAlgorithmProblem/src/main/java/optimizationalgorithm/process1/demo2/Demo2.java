package optimizationalgorithm.process1.demo2;

import java.util.*;

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
    //https://leetcode.cn/problems/peak-index-in-a-mountain-array/
    //    山峰问题
    public int peakIndexInMountainArray(int[] arr) {
        int left=0,right=arr.length-1;
        // 找右端点
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(arr[mid]>arr[mid-1]) left=mid;
            else right=mid-1;
        }
        return left;
    }
//https://leetcode.cn/problems/find-peak-element/
public int findPeakElement(int[] nums) {
    int left=0,right=nums.length-1;
    while(left<right){
        int mid=left+(right-left)/2;
        if(nums[mid]>nums[mid+1]){
            right=mid;
        }else{
            left=mid+1;
        }
    }
    return left;
}
//https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
    // 右边点为判断条件
public int findMin(int[] nums) {
    int n=nums.length;
    int left=0,right=n-1;
    // 分成大于nums[n-1] 部分和小于等于它的部分
    while(left<right){
        int mid=left+(right-left)/2;
        if(nums[mid]>nums[n-1]) left=mid+1;
        else right=mid;
    }
    return nums[left];
}
    // 以左边点为判断条件
    public int findMin2(int[] nums) {
        int n=nums.length;
        // 处理边界
        if(nums[0]<nums[n-1]) return nums[0];
        int left=0,right=n-1;
        //
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=nums[0]) left=mid+1;
            else right=mid;
        }
        return nums[left];
    }
//    https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/submissions/
//    以下标和对应值是否相等来分两个区间,所缺值为不相等区间的左端点值
public int takeAttendance(int[] records) {
    int left=0,right=records.length; // 这里right 防止records={0} 解决需要返回1这种情况
    while(left<right){
        int mid=left+(right-left)/2;
        if(mid==records[mid]) left=mid+1;
        else right=mid;
    }
    return left;
}
//    https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=binary-search
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;

        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[left]){
                if(target>=nums[left]&&target<nums[mid]) right=mid-1;
                else left=mid+1;
            }else{
                if(target<=nums[right]&&target>nums[mid]) left=mid+1;
                else right=mid-1;
            }
        }

        return -1;
    }
//    https://www.nowcoder.com/practice/99eb8040d116414ea3296467ce81cbbc?tpId=230&tqId=2023819&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        long[][] dp = new long[n + 1][m + 1];
        // 初始化dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] =dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+arr[i][j];
            }
        }
        while(q>0){
            int x1=in.nextInt(),y1=in.nextInt(),x2=in.nextInt(),y2=in.nextInt();
            long ret =dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
            System.out.println(ret);
            q--;
        }
    }

    public static void main(String[] args) {

        HashSet<Integer> hashSet=new HashSet<>();
        HashMap<Integer,String> hashMap=new HashMap<>();
//       String  s ="qqqqqqqqqq";
//        String[] words ={"qq","qq"};
//        System.out.println(findSubstring(s, words));
        int n=2147395599;
//        System.out.println(mySqrt(n));
        System.out.println(Integer.MIN_VALUE);
    }
}
