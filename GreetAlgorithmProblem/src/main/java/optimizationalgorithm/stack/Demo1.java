package optimizationalgorithm.stack;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/6  14:06
 */
public class Demo1 {
    class Solution1 {
//        https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
//        删除相邻重复字符
        public String removeDuplicates(String ss) {
            StringBuilder stringBuilder=new StringBuilder();
            char[] s=ss.toCharArray();
            int tailIndex=-1;// 模拟栈顶元素
            for(char i:s){
                if(tailIndex>=0&&stringBuilder.charAt(tailIndex)==i){
                    stringBuilder.deleteCharAt(tailIndex);
                    tailIndex--;
                }else{
                    stringBuilder.append(i);
                    tailIndex++;
                }
            }
            return stringBuilder.toString();
        }
    }

    class Solution2 {
//        /https://leetcode.cn/problems/backspace-string-compare/
//        # 退格字符
        public boolean backspaceCompare(String s, String t) {
            return changeStr(s).equals(changeStr(t));
        }
        public String changeStr(String s){
            char[] ch= s.toCharArray();
            StringBuilder stringBuilder=new StringBuilder();/// 模拟栈操作
            int tailIndex=-1;
            for(char c:ch){
                if(c=='#'){
                    if(tailIndex>=0)
                        stringBuilder.deleteCharAt(tailIndex--);// 出栈
                }else{
                    stringBuilder.append(c); // 入栈
                    tailIndex++;
                }
            }
            return stringBuilder.toString();
        }
    }
    public static void main2(String[] args) {
        StringBuilder stringBuilder=new StringBuilder("asdfg");
        StringBuilder stringBuilder1=new StringBuilder("asdfg");
        System.out.println(stringBuilder.delete(1,2));
        Stack<Integer> stack=new Stack<>();
        stack.pop();
        stack.isEmpty();

    }
    public static int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char[] ss=s.toCharArray();
        char sign='+';

        for(int i=0;i<ss.length;){
            if(ss[i]>='0'&&ss[i]<='9'){
                int tmp=0;
                while(i<ss.length&&ss[i]>='0'&&ss[i]<='9'){
                    tmp=tmp*10+(ss[i]-'0');
                    i++;
                }
                if(sign=='+'){
                    stack.push(tmp);
                }else if(sign=='-'){
                    stack.push(-tmp);
                }else if(sign=='*'){
                    stack.push(stack.pop()*tmp);
                }else{
                    stack.push(stack.pop()/tmp);
                }
            }else{
                sign=ss[i++];
            }
        }
        int ret=0;
        while(!stack.isEmpty()){
            ret+=stack.pop();
        }
        return ret;
    }

    public static void main1(String[] args) {
        System.out.println(calculate("3/2"));
    }
    class Solution3 {
//        https://leetcode.cn/problems/basic-calculator-ii/
//        基本计算器II
        public int calculate(String s) {
            // 先算乘除  把加减全改为最后相加  最后把栈的所有元素相加返回结果
            Deque<Integer> stack=new ArrayDeque<>(); // ArrayDeque数组形式（LinkedList 链表） 线程不安全 ，但是效率比线程安全的Stack高
            char[] ss=s.toCharArray();
            char sign='+';

            for(int i=0;i<ss.length;){
                if(ss[i]==' '){
                    i++;
                }else if(ss[i]>='0'&&ss[i]<='9'){
                    int tmp=0;
                    while(i<ss.length&&ss[i]>='0'&&ss[i]<='9'){
                        tmp=tmp*10+(ss[i]-'0');
                        i++;
                    }
                    if(sign=='+'){
                        stack.push(tmp);
                    }else if(sign=='-'){
                        stack.push(-tmp);
                    }else if(sign=='*'){
                        stack.push(stack.pop()*tmp);
                    }else{
                        stack.push(stack.pop()/tmp);
                    }
                }else{
                    sign=ss[i++];
                }
            }
            // 统计结果
            int ret=0;
            while(!stack.isEmpty()){
                ret+=stack.pop();
            }
            return ret;
        }
    }
    class Solution4 {
//        https://leetcode.cn/problems/decode-string/
//        字符串解码
        public String decodeString(String s) {
            Deque<StringBuilder> stringStack=new ArrayDeque<>();
            stringStack.push(new StringBuilder()); //放入一个空串
            Deque<Integer> intStack=new ArrayDeque<>();
            char[] ss=s.toCharArray();
            for(int i=0;i<ss.length;){
                // 为数字存入整数栈
                if(ss[i]>='0'&&ss[i]<='9'){
                    int tmp=0;
                    while(i<ss.length&&ss[i]>='0'&&ss[i]<='9'){
                        tmp=tmp*10+(ss[i++]-'0');
                    }
                    intStack.push(tmp);
                }else if(ss[i]==']'){ // 进行解码
                    StringBuilder stringBuilder=stringStack.pop();
                    int count=intStack.pop();
                    StringBuilder newS=new StringBuilder();
                    for(int j=0;j<count;j++){
                        newS.append(stringBuilder);
                    }
                    // 添加前面的字符串
                    stringStack.push(stringStack.pop().append(newS));

                    i++;

                }else if(ss[i]=='['){
                    // 需解码字符串入栈
                    i++;
                    StringBuilder stringBuilder=new StringBuilder();
                    while(i<ss.length&&ss[i]>='a'&&ss[i]<='z'){
                        stringBuilder.append(ss[i++]);
                    }
                    stringStack.push(stringBuilder);
                }else{
                    // 无需解码字符串 直接拼接
                    StringBuilder stringBuilder=new StringBuilder();
                    while(i<ss.length&&ss[i]>='a'&&ss[i]<='z'){
                        stringBuilder.append(ss[i++]);
                    }
                    stringStack.peek().append(stringBuilder);
                }
            }

            return stringStack.pop().toString();
        }
    }
}
