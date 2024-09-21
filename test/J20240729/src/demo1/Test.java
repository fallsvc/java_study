package demo1;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/29  10:59
 */
class Integercmp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
public class Test {
    public static void main(String[] args) {


    }
    public static void main2(String[] args) {
//        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1,o2) ->o2.compareTo(o1));
//        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1,o2) -> {
//            return o2.compareTo(o1);
//        });
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Integercmp());
        priorityQueue.offer(10);
        priorityQueue.offer(9);
        priorityQueue.offer(11);
        System.out.println(priorityQueue.peek());

    }
    public static void main1(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.offer(9);
        priorityQueue.offer(8);
        priorityQueue.offer(10);
        priorityQueue.offer(11);
        priorityQueue.offer(8);
        priorityQueue.offer(10);
        priorityQueue.offer(11);

        Iterator<Integer> iterator=priorityQueue.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("====================");
        Integer[] arr=priorityQueue.toArray(new Integer[0]);
        Arrays.sort(arr);
        for (Integer x :
                arr) {
            System.out.println(x);
        }
    }
}
