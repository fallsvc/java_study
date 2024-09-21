package demo1;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/20  7:53
 */
class cmp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return -o1.compareTo(o2);
    }
}
public class Test {
    //前k个最小的
    public  int[] smallestK2(int[] arr,int k){
        int[] ret=new int[k];
        if(arr==null||k<=0){
            return ret;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new cmp());
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length ; i++) {
            int a=priorityQueue.peek();
            if(a>arr[i]){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i]=priorityQueue.poll();
        }
        return ret;
    }
    //前k个小的
    public int[] smallestK(int[] arr,int k){
        Queue<Integer> priorityQueue=new PriorityQueue<>();
        //入堆
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }
        //出堆
        int[] ret=new int[k];
        for (int i = 0; i <k ; i++) {
            ret[i]=priorityQueue.poll();
        }
        return ret;
    }
    public static void main(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>(new cmp());

        queue.offer(1);
        queue.offer(20);
        System.out.println(queue.poll());
    }

}
