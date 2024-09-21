package demoStack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/29  20:22
 */
public class Test {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("ads");
        stack.push("11s");
        stack.push("23ds");

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
