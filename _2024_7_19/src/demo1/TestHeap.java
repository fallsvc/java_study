package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/19  19:56
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap(int[] elem) {
        this.elem = elem;
    }

    public TestHeap(){
        this.elem=new int[10];
    }
    public void setElem(int[] a){
        for (int i = 0; i < a.length; i++) {
            elem[i]=a[i];
            usedSize++;
        }
    }
    public void createHeap(){
        for (int parent = (this.usedSize-1-1)/2; parent >=0 ; parent--) {
            shiftDown(parent,this.usedSize);
        }
    }

    public void swap(int parent,int child){

        int tmp=elem[child];
        elem[child]=elem[parent];
        elem[parent]=tmp;

    }
    public void shiftDown(int parent,int usedSize){
        int child=parent*2+1;//第一个子节点
        while(child<usedSize){
            //找到最大子节点
            if(child+1<usedSize && elem[child]<elem[child+1]){
                child++;
            }
            if(elem[parent]<elem[child]){
                swap(parent,child);
                parent=child;
                child=parent*2+1;
            }else{
                break;
            }
        }
    }
    public boolean isFull(){
        if(elem.length==usedSize) return true;

        return false;
    }
    public void extendCapacity(){
        elem=Arrays.copyOf(elem,elem.length*2);
    }
    public void push(int val){
        if(isFull()){
            extendCapacity();
        }
        elem[usedSize]=val;
        shiftUp(usedSize);
        usedSize++;
    }

    private void shiftUp(int child) {
        int parent=(child-1)/2;
        while (parent>=0){
            if(elem[parent]<elem[child]){
                swap(parent,child);
                child=parent;
                parent=(parent-1)/2;
            }else{
                break;
            }
        }
    }

    public int poll(){
        int val=elem[0];
        swap(0,usedSize-1);
        shiftDown(0,usedSize-1);
        usedSize--;
        return val;
    }
    public int peek(){
        return elem[0];
    }
    public void heapSort(){
        int end=usedSize-1;
        while(end>0){
            swap(0,end);
            shiftDown(0,end);
            end--;
        }
    }
    @Override
    public String toString() {
        return "TestHeap{" +
                "elem=" + Arrays.toString(elem) +
                '}';
    }
}
