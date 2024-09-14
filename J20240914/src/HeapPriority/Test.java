package HeapPriority;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/14  14:41
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>();
        int[] array={5,3,2,7,2,7};
        MyPriorityQueue myPriorityQueue=new MyPriorityQueue(array);


        myPriorityQueue.createHeap();
        myPriorityQueue.offer(9);
    }
}
