package thread.blockingqueue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/19  15:59
 */
public class MyBlockingQueue {
    // 循环队列
    private int[] data=null;

    // 队首元素
    private int head=0;
    // 队尾元素后一个位置
    private int tail=0;
    // 元素个数
    private int size=0;

    public MyBlockingQueue(int capacity){
        data=new int[capacity];
    }

    public synchronized void put(int val) throws InterruptedException {
        while(size>= data.length-1){
            this.wait();
        }
        data[tail]=val;
        tail++;
        if(tail>=data.length){
            tail=0;
        }
        size++;

        this.notify();
        return;
    }
    public synchronized int take() throws InterruptedException {
        while(size==0){
            this.wait();
        }
        int ret=data[head];
        head++;
        if(head>=data.length){
            head=0;
        }
        size--;

        this.notify();
        return ret;
    }
}
