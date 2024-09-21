package demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/13  7:23
 */
public class Test {
    public static void main(String[] args) {
        MyTree tree=new MyTree();
        tree.createTree();
        tree.preOrder(tree.root);
        System.out.println();
//        tree.inOrder(tree.root);
//        System.out.println();
//        tree.postOrder(tree.root);
//        System.out.println();
        tree.levelOrder(tree.root);
    }
    public static void main3(String[] args) {
        MyCircularQueue m=new MyCircularQueue(3);
        m.enQueue(1);
        m.enQueue(2);
        m.enQueue(3);
        System.out.println(m.Rear());
    }
    public static void main2(String[] args) {
        QToS s=new QToS();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.top());
    }
    public static void main1(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        Queue<Integer> queue=new LinkedList<>();

    }
}
