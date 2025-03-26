package optimizationalgorithm.process2.simulationalgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/25  14:05
 */
public class Demo1 {
//    https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/submissions/615186661/
    public String modifyString(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length;
        for(int i=0;i<n;i++){
            if(s[i]=='?'){
                for(char ch='a';ch<='z';ch++){
                    if((i==0||s[i-1]!=ch)&&(i==n-1||s[i+1]!=ch)){
                        s[i]=ch;
                        break;
                    }
                }
            }
        }
        return String.valueOf(s);
    }
//    https://leetcode.cn/problems/teemo-attacking/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n=timeSeries.length;
        int count=0;
        for(int i=1;i<n;i++){
            int x=timeSeries[i]-timeSeries[i-1]; // 此时和前一个时间差
            if(x>=duration) count+=duration;
            else count+=x;
        }
        return count+duration;// 最后一个攻击满时间
    }
//    https://leetcode.cn/problems/zigzag-conversion/submissions/615208617/
    public String convert(String ss, int numRows) {

        // 处理边界
        if(numRows==1) return ss;
        char[] s=ss.toCharArray();
        int n=s.length;
        StringBuilder stringbuilder=new StringBuilder();
        int d=2*numRows-2;// 公差
        // 第一行
        for(int i=0;i<n;i+=d){
            stringbuilder.append(s[i]);
        }
        for(int i=1;i<numRows-1;i++){
            for(int j=i;j<n;j+=d){
                stringbuilder.append(s[j]);
                int next=j+d-2*i;
                if(next<n) stringbuilder.append(s[next]);
            }
        }
        for(int i=numRows-1;i<n;i+=d){
            stringbuilder.append(s[i]);
        }
        return stringbuilder.toString();
    }

//https://leetcode.cn/problems/count-and-say/submissions/615535194/
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String a="1";
        for(int i=1;i<n;i++){
            a=countAndSay1(a);// 向下找描述
        }
        return a;
    }
    public static String countAndSay1(String n){
        StringBuilder stringBuilder=new StringBuilder();
        char[] s=n.toCharArray();
        // 双指针找相同区间
        int left=0,right=0;
        while(right<s.length){
            while(right<s.length&&s[left]==s[right]){
                right++;
            }
//            char ch=(char)((right-left)+48);
//            stringBuilder.append(ch);
            stringBuilder.append(Integer.toString(right-left));
            stringBuilder.append(s[left]);
            left=right;
        }
        return stringBuilder.toString();
    }

//    https://leetcode.cn/problems/minimum-number-of-frogs-croaking/submissions/615623961/

    public int minNumberOfFrogs(String croakOfFrogs) {
        String t="croak";
        int n=t.length();
        char[] c=croakOfFrogs.toCharArray();
        int[] hash=new int[n];// 存储字符出现次数（按顺序）
        Map<Character,Integer> map=new HashMap<>(); // 存储字符对应下标
        for(int i=0;i<n;i++) map.put(t.charAt(i),i);

        for(int i=0;i<c.length;i++){
            // 单独处理第一个字符遍历
            if(c[i]==t.charAt(0)){
                if(hash[n-1]!=0) hash[n-1]--;
                hash[0]++;
            }else{
                int index=map.get(c[i]);
                if(hash[index-1]==0)return -1;
                else{
                    hash[index-1]--;
                    hash[index]++;
                }
            }
        }
        for(int i=0;i<n-1;i++) if(hash[i]!=0) return -1;// 处理"croakcroa" 没有错位，但是差字符

        return hash[n-1];
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        char ch=1+'0';
        System.out.println(ch);
        System.out.println(Integer.MIN_VALUE / 2);
    }
//
}
