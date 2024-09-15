package SortImplimentation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/15  11:33
 */
public class Sort {
    //直接插入排序
    //时间复杂O(N^2)
    //空间复杂度O(1)
    //越有序越快
    //   稳定的排序
    public static void insertSort(int[] array){

        for (int i = 1; i < array.length; i++) {
            int tmp=array[i];//存该值
            int j=0;
            for(j=i-1;j>=0;j--){
                if(tmp<array[j]){
                    array[j+1]=array[j];//把大的值放在后面
                }else{
                    break;
                }
            }
            array[j+1]=tmp;//插入存的值
        }
    }
    //希尔排序
    //时间复杂度O(N^2)
    //
    public static void shellSort(int[] array){
        int gap=array.length;
        while(gap>1){
            gap/=2;//gap=gap/3+1;
            shell(array,gap);
        }
    }

    /**
     *
     * @param array
     * @param gap 分组元素间隔
     */
    private static void shell(int[] array, int gap) {
        //从第二个元素开始在对应的分组进行排序
        for (int i = gap; i <array.length ; i++) {
            int tmp=array[i];
            int j=i-gap;
            for (; j >=0; j-=gap) {
                if(tmp<array[j]){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    //选择排序
    //时间复杂度O(N^2)
    //空间复杂度O(1)
    //不稳定
    // 与数组是否有序无关
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <array.length ; j++) {
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    //两边找
    public static void selectSort2(int[] array){
        int left=0;
        int right=array.length-1;
        for (int i = 0; i <=right; i++) {
            int minIndex=left;
            int maxIndex=right;
            for (int j = left; j <=right ; j++) {
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
                if(array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }
            swap(array,left,minIndex);
            if(maxIndex==left){
                maxIndex=minIndex;
            }
            swap(array,right,maxIndex);
            left++;
            right--;
        }
    }
    // 堆排
    //时间复杂度O(nlogn)
    //  不稳定
    public static void heapSort(int[] array){

        //创大根堆
        createHeap(array);
        //排序
        int end=array.length-1;
        while(end>0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    private static void createHeap(int[] array) {
        for (int parent = (array.length-2)/2; parent >=0 ; parent--) {
            shiftDown(array,parent,array.length);
        }
    }

    private static void shiftDown(int[] array, int parent, int length) {
        int child=parent*2+1;
        while(child<length){
            if(child+1<length&&array[child+1]>array[child]){
                child++;
            }
            if(array[parent]<array[child]){
                swap(array,parent,child);
            }else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] array){

        for (int i = 0; i < array.length-1; i++) {//优化2
            boolean flag=false;//改良1
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }
        }
    }
    //快排
    //
    public static void quickSort(int[] array){
//        quick(array,0,array.length-1);
        quickNor(array,0,array.length-1);//非递归
    }

    private static void quickNor(int[] array,int start,int end) {

        int pivot=partition2(array,start,end);
        Deque<Integer> stack=new ArrayDeque<>();
        if(start+1<pivot){
            stack.push(start);
            stack.push(pivot-1);
        }
        if(end-1>pivot){
            stack.push(pivot+1);
            stack.push(end);
        }
        while(stack.isEmpty()){
            end=stack.pop();
            start=stack.pop();
            pivot=partition2(array,start,end);
            if(start+1<pivot){
                stack.push(start);
                stack.push(pivot-1);
            }
            if(end-1>pivot){
                stack.push(pivot+1);
                stack.push(end);
            }
        }

    }

    private static void quick(int[] array, int start,int end) {

        if(start>end) return;
        //小于10的用直接插入排序//减小递归次数
        if(end-start+1<=10){
            insertSortRange(array,start,end);
            return;
        }

        //优化 三数取中法
        int middleIndex=getMiddleIndex(array,start,end);
        swap(array,0,middleIndex);

        int pivot=partition3(array,start,end);
        if(pivot==-1) return;

        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }

    private static void insertSortRange(int[] array, int start, int end) {

        for (int i = start+1; i <=end ; i++) {
            int tmp=array[i];
            int j = i-1;
            for (; j >=start ; j--) {
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    array[j+1]=tmp;
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }

    private static int getMiddleIndex(int[] array, int start, int end) {
        int midIndex=(start+end)/2;
        if(array[start]<array[end]){
            if(array[midIndex]<array[start]){
                return start;
            }else if(array[midIndex]>array[end]){
                return end;
            }else {
                return midIndex;
            }
        }else{
            if(array[midIndex]<array[end]){
                return end;
            }else if(array[midIndex]>array[start]){
                return start;
            }else {
                return midIndex;
            }
        }
    }

    //Hoare法
    private static int partition(int[] array, int start, int end) {
        int tmp=array[start];
        int tmpLeft=start;

        while(start<end){
            //一定要先找右
            while(start<end&&array[end]>=tmp){
            end--;
             }
            while(start<end&&array[start]<=tmp){
                start++;
            };

           swap(array,start,end);
        }
        swap(array,tmpLeft,start);

        return start;
    }
    //挖坑法
    private static int partition2(int[] array,int left,int right){
        int tmp=array[left];
        while (left<right){
            while(left<right&&array[right]>=tmp){
                right--;
            }
            array[left]=array[right];
            while(left<right&&array[left]<=tmp){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=tmp;
        return left;
    }

    //前后指针法
    private static int partition3(int[] array,int left,int right){

        int prev=left;
        int cur=left+1;
        while(cur<=right){
            //找到比array[left]小的且prev!=cur
            if(array[cur]<array[left]&&array[++prev]!=array[cur]){
                swap(array,cur,prev);
            }
            cur++;
        }
        swap(array,prev,left);
        return prev;
    }

}
