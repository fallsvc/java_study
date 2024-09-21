package demo1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/30  9:16
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student=new Student();
        Student student1=(Student) student.clone();
        student.id.id=20;
        System.out.println(student);
        System.out.println(student1);
    }
    public static void main2(String[] args) {
        Deque<Integer> stack=new LinkedList<>();
        stack.offer(1);
        stack.offer(2);
        System.out.println(stack.pop());//1
    }
    //
    public static void main1(String[] args) {
        Deque<Integer> stack=new ArrayDeque<>();
        stack.offer(10);
        stack.offer(10);
        stack.push(12);
        stack.push(11);
        Deque<Integer> s=new LinkedList<>();
        System.out.println(stack.pop());
        System.out.println(stack.poll());
    }
}
