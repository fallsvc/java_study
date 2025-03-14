package optimizationalgorithm.process1.DoublePoint;

import javax.imageio.stream.IIOByteBuffer;
import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/19  22:14
 */
public class Test {
    //移动零     https://leetcode.cn/problems/move-zeroes/description/
    public void moveZeroes(int[] nums) {
        int dest=-1;//划分非零和零
        int cur=0;//划分已经排和未排
        while(cur<nums.length){
            if(nums[cur]!=0){
                swap(nums,dest+1,cur);
                dest++;
            }
            cur++;
        }

    }
    public void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    //复写零 https://leetcode.cn/problems/duplicate-zeros/
    public void duplicateZeros(int[] arr) {
        int cur=-1;
        int dest=-1;
        //找到最后需要写的位 cur
        while(dest<arr.length-1){
            cur++;
            if(arr[cur]==0){
                dest++;
            }
            dest++;
        }
        if(dest>arr.length-1){
            cur--;
            arr[--dest]=0;
            dest--;
        }

        //从后向前写
        while(cur>=0){
            //先移动一位
            arr[dest--]=arr[cur];
            //如果arr[cur]==0,还需复写一位
            if(arr[cur]==0){
                arr[dest--]=0;
            }
            cur--;
        }
    }
    //快乐树 产生循环
    //   https://leetcode.cn/problems/happy-number/submissions/566248223/
    public static boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(true){
            slow=getNumberSquares(slow);
            fast=getNumberSquares(fast);
            fast=getNumberSquares(fast);
            if(fast==slow) break;
        }

        return slow==1;

    }
    public static int getNumberSquares(int n){
        int sum=0;
        while(n!=0){
            int w=n%10;
            sum+=w*w;
            n/=10;
        }

        return sum;
    }

    public static void main1(String[] args) {
        System.out.println(isHappy(19));
    }

//    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//            0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    你可以按 任意顺序 返回答案 。
//
//  https://leetcode.cn/problems/4sum/description/
//
//    示例 1：
//
//    输入：nums = [1,0,-1,0,-2,2], target = 0
//    输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> list=new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 定第一个数
        int len=nums.length;
        for(int i=0;i<len-3;i++){
            // 定第二个数
            for(int j=i+1;j<len-2;j++){
                long target2=(long) target-(long) nums[i]-(long)nums[j];
                int left=j+1;
                int right=len-1;
                while(left<right){
                    long sum=nums[left]+nums[right];
                    if(sum>target2){
                        right--;
                    }else if(sum<target2){
                        left++;
                    }else{
                        List<Integer> tmp=new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        list.add(tmp);
                        // 缩小区间继续查找
                        left++;
                        right--;
                        // 去重
                        while(left<right&&nums[left]==nums[left-1]) left++;
                        while(left<right&&nums[right]==nums[right+1]) right--;
                    }
                }
                // 去重
                while(j<len-2&&nums[j]==nums[j+1]) j++;
            }
            // 去重
            while(i<len-3&&nums[i]==nums[i+1]) i++;
        }
        return list;
    }

    public static void main2(String[] args) {
        int[] nums={1000000000,1000000000,1000000000,1000000000};
        int target=-294967296;
        System.out.println(fourSum(nums, target));
    }

//    给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//  https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
//    示例 1:
//
//    输入: s = "abcabcbb"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> hashSet=new HashSet<>(); // 存储字符
        int n=s.length();
        int len=0;
        int left=0,right=0;
        while(right<n){
            Character ch=s.charAt(right);
            if (!hashSet.contains(ch)){ // 进窗口
                hashSet.add(ch);
                len=Math.max(len,right-left+1);
            }else{
                // 出窗口
                while(left<right&&s.charAt(left)!=ch){
                    hashSet.remove(s.charAt(left));// 出窗口
                    left++;
                }
                left++;

            }
            right++;
        }
        return len;
    }
    public int lengthOfLongestSubstring(String ss) {
        char[] s=ss.toCharArray(); // 存储字符
        int[] hash=new int[128];// 模拟hash
        int n=s.length;
        int len=0;
        int left=0,right=0;
        while(right<n){
            // 入窗口
            hash[s[right]]++;
            while(hash[s[right]]>1)
                hash[s[left++]]--;
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
//    给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
//
//如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
//
//
//https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
//示例 1：
//
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0
    public int minOperations2(int[] nums, int x) {
        int len=0;
        int n=nums.length;
        int sum=0; // 中间数和
        int allSum=0; //所有数之和
        for(int num:nums){
            allSum+=num;
        }
        // 1判断是否整个数组之和等于x
        if(allSum==x){
            return n;
        }
        // 2计算中间数之和是否等于allSum-x
        for(int left=0,right=0;right<n;right++){
            sum+=nums[right];// 入窗口
            while(left<right&&sum>allSum-x){// 判断
                sum-=nums[left++];//出窗口
            }
            if(sum==allSum-x){
                len=Math.max(len,right-left+1);
            }
        }
        return len==0?-1:n-len;
    }
    // pro
    public int minOperations(int[] nums, int x) {
        int len=-1;// 返回数
        int n=nums.length;
        int sum=0; // 中间数和
        int allSum=0; //所有数之和
        for(int num:nums){
            allSum+=num;
        }
        int target=allSum-x;
        // 1判断是否整个数组之和<x
        if(target<0){ // 防止后面left越界
            return len;
        }
        // 2计算中间数之和是否等于allSum-x
        for(int left=0,right=0;right<n;right++){
            sum+=nums[right];// 入窗口
            while(sum>target){// 判断 如果整个数组和等于x则left会在right前面去
                sum-=nums[left++];//出窗口
            }
            if(sum==target){
                len=Math.max(len,right-left+1);
            }
        }
        return len==-1?len:n-len;
    }

//    https://leetcode.cn/problems/fruit-into-baskets/description/
    public int totalFruit2(int[] fruits) {
        Map<Integer,Integer> hash=new HashMap<>();// 存储装的水果
        int ret=0;
        for(int left=0,right=0;right<fruits.length;right++){
            // 入窗口
            Integer n=fruits[right];
            hash.put(n,hash.getOrDefault(n,0)+1);
            // 判断
            while(hash.size()>2){
                n=fruits[left++];// 出窗口
                int count=hash.get(n);
                if(count==1){
                    hash.remove(n);
                }else{
                    hash.put(n,count-1);
                }
            }
            ret=Math.max(ret,right-left+1);
        }
        return ret;
    }
    // pro 数组模拟hash表
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int[] hash=new int[n+1];// 存储装的水果
        int ret=0;
        // kinds记录总数
        for(int left=0,right=0,kinds=0;right<n;right++){
            // 入窗口
            int num=fruits[right];
            if(hash[num]++==0){
                kinds++;
            }
            // 判断
            while(kinds>2){
                num=fruits[left++];// 出窗口
                hash[num]--;
                if(hash[num]==0) kinds--;
            }
            ret=Math.max(ret,right-left+1);
        }
        return ret;
    }

//https://leetcode.cn/problems/find-all-anagrams-in-a-string/
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int[] hash1=new int[26];
        int[] hash2=new int[26];
        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();
        // p 字符放入hash
        for(char a:pp){
            hash2[a-97]++;
        }
        for(int left=0,right=0,count=0,n=p.length();right<s.length();right++){
            // 入窗口
            hash1[ss[right]-97]++;
            if(hash1[ss[right]-97]<=hash2[ss[right]-97]) count++;// 有效字符
            // 判断
            if(right-left+1>n){
                if(hash1[ss[left]-97]<=hash2[ss[left]-97])
                    count--;
                hash1[ss[left++]-97]--;// 出窗口
            }
            if(count==n) list.add(left);

        }
        return list;
    }
    public static void main(String[] args) {
        HashMap<Integer, Integer> map=new HashMap<>();
        String s="as";
        char[] ss=s.toCharArray();
        for (char a :
                ss) {
            System.out.println(a);
        }
    }
}
