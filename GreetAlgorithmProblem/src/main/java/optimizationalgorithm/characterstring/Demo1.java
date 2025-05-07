package optimizationalgorithm.characterstring;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/29  15:39
 */
public class Demo1 {
    class Solution1{
        //        https://leetcode.cn/problems/longest-common-prefix/
//        1. 两两找前缀 合并
        public String longestCommonPrefix(String[] strs) {
            String ret=strs[0];
            // 两两找前缀
            for(int i=1;i<strs.length;i++){
                ret=findCommon(ret,strs[i]);
            }

            return ret;
        }
        public String findCommon(String s1,String s2){
            int i=0;
            int length=Math.min(s1.length(),s2.length());
            while(i<length&&s1.charAt(i)==s2.charAt(i)) i++;

            return s1.substring(0,i);
        }

        public String longestCommonPrefix2(String[] strs) {
            // 统一比较
            char[] s=strs[0].toCharArray();
            for(int i=0;i<s.length;i++){
                char ch=s[i];
                for(int j=1;j<strs.length;j++){
                    if(i==strs[j].length()||strs[j].charAt(i)!=ch){
                        return strs[0].substring(0,i);
                    }
                }
            }
            return strs[0];
        }
    }

    class Solution2 {
//        https://leetcode.cn/problems/longest-palindromic-substring/
//        最长回文子串
        // 1. 动态规划
        public String longestPalindrome(String s) {
            int n=s.length();
            boolean[][] dp=new boolean[n][n]; // [i][j] i-j 是否为回文
            int len=0,x=0,y=0;
            for(int i=n-1;i>=0;i--){
                for(int j=n-1;j>=i;j--){
                    // 判断是否为回文串
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=i+1<j?dp[i+1][j-1]:true;
                    // 回文串中找最大
                    if(dp[i][j]==true){
                        if(len<j-i+1){
                            len=j-i+1;
                            x=i;
                            y=j;
                        }
                    }
                }
            }

            return s.substring(x,y+1);
        }
        // 2. 中心扩展算法
//        https://leetcode.cn/problems/longest-palindromic-substring/
//        最长
        public String longestPalindrome2(String ss) {
            char[] s=ss.toCharArray();
            int n=s.length;
            int left=0,right=0;
            int len=0,x=0,y=0;
            for(int i=0;i<n;i++){ // 固定中间点
                left=i-1;
                right=i+1;
                // 1.回文串为奇数个字符
                while(left>=0&&right<n&&s[left]==s[right]){
                    left--;
                    right++;
                }
                // 更新
                if(len<right-left-1){
                    len=right-left-1;
                    x=left+1;
                    y=right-1;
                }
                // 2. 偶数个
                left=i;
                right=i+1;
                while(left>=0&&right<n&&s[left]==s[right]){
                    left--;
                    right++;
                }
                // 更新
                if(len<right-left-1){
                    len=right-left-1;
                    x=left+1;
                    y=right-1;
                }
            }
            return ss.substring(x,y+1);
        }

    }

    class Solution3 {
//        https://leetcode.cn/problems/add-binary/
//        二进制求和
        public String addBinary(String aa, String bb) {
            char[] a=aa.toCharArray();
            char[] b=bb.toCharArray();
            int i=a.length-1;
            int j=b.length-1;
            int t=0;// 进位
            StringBuilder stringbuilder=new StringBuilder();
            while(i>=0||j>=0||t!=0){
                if(i>=0) t+=a[i--]-'0';
                if(j>=0) t+=b[j--]-'0';
                stringbuilder.append((char)(t%2+'0'));
                t/=2;
            }
            return stringbuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
//        longestPalindrome("aba");
        System.out.println('1'-'0');
        String a=new String();
        char[] b={'a','b'};
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(1);

        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder.substring(0));
    }
    class Solution4 {
//        https://leetcode.cn/problems/multiply-strings/
//          字符串相乘
        public String multiply(String num1, String num2) {
            if(num1.charAt(0)=='0'||num2.charAt(0)=='0') return "0";// 处理前导0
            // 逆序字符串
//            char[] n1=new StringBuilder(num1).reverse().toString().toCharArray();
//            char[] n2=new StringBuilder(num2).reverse().toString().toCharArray();
            char[] n1=reverseToCharArray(num1);
            char[] n2=reverseToCharArray(num2);
            int len1=n1.length;
            int len2=n2.length;
            int[] sum=new int[len1+len2-1];
            // 逆序后，无进位 相乘再相加   先把计算到这个位相加 （先不进位）
            for(int i=0;i<len1;i++){
                for(int j=0;j<len2;j++){
                    sum[i+j]+=(n1[i]-'0')*(n2[j]-'0');
                }
            }
            // 进位计算
            StringBuilder str=new StringBuilder();
            int t=0,cur=0;
            while(cur<len1+len2-1||t!=0){
                if(cur<len1+len2-1) t+=sum[cur++];
                str.append((char)(t%10+'0'));
                t/=10;
            }

            return str.reverse().toString();
        }
        // 可以自己写 逆序函数  字符串转字符数组逆序
        public char[] reverseToCharArray(String s){
            char[] tmp=s.toCharArray();
            int left=0,right=tmp.length-1;
            while(left<right){
                char t=tmp[left];
                tmp[left]=tmp[right];
                tmp[right]=t;
                left++;
                right--;
            }
            return tmp;
        }
    }


}
