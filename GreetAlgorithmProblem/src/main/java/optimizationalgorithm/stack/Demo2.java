package optimizationalgorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/7  15:09
 */
public class Demo2 {
    class Solution1 {
//        https://leetcode.cn/problems/validate-stack-sequences/
//        验证栈序列
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack=new ArrayDeque<>();
            int i=0;
            int n=popped.length;
//          入栈时出能出栈 的元素
            for(int x:pushed){
                stack.push(x);
                while(!stack.isEmpty()&&i<n&&popped[i]==stack.peek()){
                    stack.pop();
                    i++;
                }
            }
            return i==n;
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        System.out.println(stack.peek());
    }
}
