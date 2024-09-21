package demo2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/10  8:32
 */
class Cmp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
public class Test {

    public static int[] sm(int[] arr,int k){
        int[] ret=new int[k];
        if(k==0) return ret;
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ret[i]=arr[i];
        }
        return ret;
    }
    public static int[] smallestK(int[] arr, int k) {
        int[] ret=new int[k];
        if(k<=0) return ret;
        //建立大跟堆
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o2.compareTo(o1);
            }
        });
        //放入k个元素
        for(int i=0;i<k;i++){
            queue.offer(arr[i]);
        }
        //放入小的取k个最小值
        for(int i=k;i<arr.length;i++){
            int tmp=queue.peek();
            if(tmp>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        //循环打印

        for(int i=0;i<k;i++){
            ret[i]=queue.poll();
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr={6,7,5,1,3,5,8};
        int[] ret=smallestK(arr,3);
        for (int x :
                ret) {
            System.out.println(x);
        }
    }
    public static void main2(String[] args) {
        //小根堆到大根堆传一个比较器
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Cmp());
        PriorityQueue<Integer> priorityQueue1=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        System.out.println(priorityQueue.poll());
    }
    public static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public static int poll(int[] array,int size){
        int tmp=array[0];
        array[0]=array[--size];
        shiftDown(array,size,0);
        return tmp;
    }

    private static void shiftDown(int[] array,int size, int parent) {
        int child=parent*2+1;
        while(child<size){
            if(child+1<size&&array[child+1]>array[child]){
                child++;
            }
            if(array[parent]<array[child]){
                swap(array,parent,child);
                parent=child;
                child=parent*2+1;
            }else{
                break;
            }

        }
    }

    public static void shiftUp(int[] array,int child){
        //找双亲
        int parent=(child-1)>>1;

        while(child>=0){
            if(array[parent]>=array[child]){
                break;
            }else {
                swap(array,parent,child);
            }
            child=parent;
            parent=(child-1)>>1;
        }

    }
    public static void main1(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>();
        PriorityQueue<Integer> queue1=new PriorityQueue<>();
        queue .offer(2);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(4);
        System.out.println(queue.poll());
    }
}
