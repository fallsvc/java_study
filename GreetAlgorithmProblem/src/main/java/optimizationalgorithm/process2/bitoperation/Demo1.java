package optimizationalgorithm.process2.bitoperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/23  12:18
 */
public class Demo1 {
//    https://leetcode.cn/problems/counting-bits/
    public static int[] countBits(int n) {
        int[] ret=new int[n+1];
        for(int i=0;i<=n;i++){
            int count=0;
            int j=i;
            while(j!=0){
                if(j%2==1) count++;
                j/=2;
            }
            ret[i]=count;
        }
        return ret;  
    }

    public static int[] countBits2(int n) {
        int[] ret=new int[n+1];
        ret[0]=0;
        for(int i=1;i<=n;i++){
            if(i%2==1){
                ret[i]=ret[i-1]+1;
            }else{
                ret[i]=ret[i/2];
            }
        }
        return ret;
    }

//    https://leetcode.cn/problems/single-number-iii/solutions/6620/cai-yong-fen-zhi-de-si-xiang-jiang-wen-ti-jiang-we/
public int[] singleNumber(int[] nums) {
    HashMap<Integer,Integer> hash=new HashMap<>();
    for(int x:nums){
        if(hash.containsKey(x)) hash.remove(x);
        else hash.put(x,1);
    }
    int[] ret=new int[2];
    Iterator<Integer> iterator=hash.keySet().iterator();
    int i=0;
    while(iterator.hasNext()){
        ret[i]=iterator.next();
        i++;
    }
    return ret;
}

    public int[] singleNumber2(int[] nums) {
        int xor=0;
        for(int x:nums) xor^=x;

        int mask=xor&(-xor); // 两数这个位不同

        //把数分为两个这个位为1的和为0的分别找一个数
        int[] ret=new int[2];
        for(int x:nums) {
            if((mask&x)==0) ret[0]^=x;
            else ret[1]^=x;
        }
        return ret;
    }
    public static void main1(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        Iterator<Integer> iterator=map.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(Arrays.toString(countBits(10)));
    }
//https://leetcode.cn/problems/is-unique-lcci/

    public boolean isUnique(String astr) {
        char[] str=astr.toCharArray();
        int n=str.length;
        if(n>26) return false; // 长度大于26一定有重复

        // 使用位图存储数据
        int arr=0;
        for(int i=0;i<n;i++){
            int ch=str[i]-'a';
            if(((arr>>>ch)&1)==1) return false;
            else arr|=1<<ch;
        }
        return true;
    }
//    https://leetcode.cn/problems/sum-of-two-integers/
    public int getSum(int a, int b) {
        int c=a^b;
        int d=((a&b)<<1); // 进位
        while(d!=0){
            int tmp=c^d;
            d=((c&d)<<1);
            c=tmp;
        }
        return c;
    }
//    https://leetcode.cn/problems/single-number-ii/submissions/614755632/
    public int singleNumber3(int[] nums) {
        int ret=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int x:nums){
                count+=(x>>i)&1;
            }
            count%=3;
            if(count==1) ret+=1<<i;
        }
        return ret;
    }
//    https://leetcode.cn/problems/missing-two-lcci/submissions/614764756/

    public int[] missingTwo(int[] nums) {
        int xor=0;
        for(int x:nums) xor^=x;
        for(int i=1;i<=nums.length+2;i++) xor^=i;
        xor&=(-xor); // 找到两个出现一次的数的左边二进制第一个不同位
        // 把数分为两组 ^  这个位为1 和不为1 的
        int[] ret=new int[2];
        for(int x:nums) {
            if((x&xor)==0) ret[0]^=x;
            else ret[1]^=x;
        }
        for(int i=1;i<=nums.length+2;i++){
            if((i&xor)==0) ret[0]^=i;
            else ret[1]^=i;
        }
        return ret;
    }

    public int[] missingTwo2(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for(int x:nums){
            hashSet.add(x);
        }
        int[] ret=new int[2];
        int k=0;
        for(int i=1;i<=nums.length+2;i++){
            if(!hashSet.contains(i)){
                ret[k++]=i;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        String s;
        System.out.println('a'-'a');
        System.out.println();
        HashSet<Integer> hashSet=new HashSet<>();
    }
}
