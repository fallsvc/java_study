package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/20  20:45
 */
public class MyPriorityQueue {
        public int[] elem;
        public int usedSize;

        public MyPriorityQueue() {
                this.elem=new int[10];
        }

        /**
         * 建堆的时间复杂度：
         *
         * @param array
         */
        public void createHeap(int[] array) {
                for (int parent = (usedSize-2)/2; parent>=0 ; parent--) {
                        shiftDown(parent,usedSize);
                }
        }

        /**
         *
         * @param root 是每棵子树的根节点的下标
         * @param len  是每棵子树调整结束的结束条件
         * 向下调整的时间复杂度：O(logn)
         */
        private void shiftDown(int root,int len) {
                int child=root*2+1;
                while(child<len){
                        if(child+1<len&&elem[child]<elem[child+1]){
                                child++;
                        }
                        if(elem[child]>elem[root]){
                                swap(child,root);
                                root=child;
                                child=root*2+1;
                        }else {
                                break;
                        }

                }
        }


        public void addCapacity(){
                elem= Arrays.copyOf(elem,usedSize*2);
        }
        /**
         * 入队：仍然要保持是大根堆
         * @param val
         */
        public void push(int val) {
                if(isFull()){
                        addCapacity();
                }
                elem[usedSize]=val;
                shiftUp(usedSize);
                usedSize++;
        }

        private void shiftUp(int child) {
                int root=(child-1)>>>1;
                while(root>=0){
                        if(elem[child]>elem[root]){
                                swap(child,root);
                                child=root;
                                root=(root-1)>>>1;
                        }else{
                                break;
                        }
                }
        }

        public boolean isFull() {
                return elem.length==usedSize;
        }

        public void swap(int i,int j){
                int tmp=elem[i];
                elem[i]=elem[j];
                elem[j]=tmp;
        }
        /**
         * 出队【删除】：每次删除的都是优先级高的元素
         * 仍然要保持是大根堆
         */
        public void pollHeap() {
                swap(0,usedSize-1);
                shiftDown(0,usedSize-1);
                usedSize--;
        }

        public boolean isEmpty() {
                if(elem==null){
                        return true;
                }
                return false;
        }

        /**
         * 获取堆顶元素
         * @return
         */
        public int peekHeap() {
                return elem[0];
        }
}
