package HeapPriority;

import java.util.Arrays;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/14  14:36
 */
public class MyPriorityQueue {
    public int[] elem;
    public int usedSize=10;

    public MyPriorityQueue(){
        this.elem=new int[10];
    }
    public MyPriorityQueue(int[] arr){
        this.elem=arr;
        this.usedSize=arr.length;
    }

    //o(n)
    public void createHeap(){

        for (int parent=(usedSize-2)/2; parent >=0 ; parent--) {
            shiftDown(parent,usedSize);
        }
    }

    //向下调整
    private void shiftDown(int parent, int usedSize) {
        int child=parent*2+1;
        while(child<usedSize){
            //是否有左孩子
            if(child+1<usedSize&&elem[child]<elem[child+1]){
                child++;
            }

            if(elem[parent]<elem[child]){
                swap(parent,child);
                parent=child;
                child=parent*2+1;
            }else {
                break;
            }

        }
    }

    //交换元素
    private void swap(int parent, int child) {
        int tmp=elem[parent];
        elem[parent]=elem[child];
        elem[child]=tmp;
    }
    //添加元素
    public boolean offer(int val){
        if(isFull()) {
            elem= Arrays.copyOf(elem,elem.length*2);
        }
        elem[usedSize++]=val;
        boolean ret=shiftUp(usedSize);

        return ret;
    }

    private boolean isFull() {
//        if(elem.length==usedSize){
//            return true;
//        }else {
//            return false;
//        }
        return usedSize==elem.length;
    }

    //向上调整
    private boolean shiftUp(int usedSize) {
        int child=usedSize-1;
        int parent=(child-1)/2;
        while(parent>=0){
            if(elem[child]>elem[parent]){
                swap(parent,child);
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
        return true;
    }
    //出列
    public int poll(){
        if(isEmpty()){
            return -1;//可以抛异常
        }
        int tmp=elem[0];
        swap(0,usedSize-1);
        usedSize--;
        shiftDown(0,usedSize);

        return tmp;
    }

    //是否为空
    private boolean isEmpty() {
        if(usedSize==0){
            return true;
        }else{
            return false;
        }
    }
    //峰值
    public int peek(){
        if(isEmpty()){
            return -1 ;
        }

        return elem[0];
    }
    //堆排  先建立大根堆
    public void heapSort(int[] array){
        int end=usedSize-1;
        while(end>0){
            swap(0,end);
            shiftDown(0,end);
            end--;
        }
    }

}
