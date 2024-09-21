package demo;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/9  22:13
 */
public class Test {
    public static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public  static void shiftDown(int[] array,int parent){
        int child=parent*2+1;
        int size=array.length;
        while(child<size){
            if(child+1<size&&array[child]<array[child+1]){
                child++;
            }
            if(array[child]>array[parent]){
                swap(array,child,parent);
            }else{
                break;
            }

            parent=child;
            child=parent*2+1;
        }
    }
    public static void creap(int[] array){
        int root=(array.length-2)>>1;
        while(root>=0){
            shiftDown(array,root);
            root--;
        }
    }

    public static void main(String[] args) {
        int[] array={7,3,1,4,6,8,9,0};
        creap(array);
    }
    public static int myStack(Queue<Integer> queue,Queue<Integer> queue2){
        if(queue.isEmpty()){
            int size=queue2.size();
            while(size>1){
                queue.offer(queue2.poll());
                size--;
            }
            return queue2.poll();
        }else{
            int size=queue.size();
            while(size>1){
                queue2.offer(queue.poll());
                size--;
            }
            return queue.poll();
        }
    }

    public static void main3(String[] args) {
        Queue<Integer> queue=new LinkedList<>();//
        Deque<Integer> queue2=new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(myStack(queue, queue2));
    }
    public static void main2(String[] args) {
        Queue<Integer> queue=new LinkedList<>();//
        Deque<Integer> queue2=new ArrayDeque<>();
        queue2.push(1);
        queue2.push(2);
        if(queue.isEmpty()){
            int size=queue2.size();
            while(size>1){
                queue.offer(queue2.poll());
                size--;
            }
        }else{
            int size=queue.size();
            while(size>1){
                queue2.offer(queue.poll());
                size--;
            }
        }
        System.out.println(queue2.poll());
    }
    public static void main1(String[] args) {
        Stack<Integer> stack=new Stack<>();
        Deque<Integer> stack1=new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            stack1.push(i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
            System.out.println(stack1.pop());
        }

    }
}
