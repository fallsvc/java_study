package demo1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/21  8:52
 */
public class Sort {
    //选择排序
    //时间复杂度O(N^2)
    //空间复杂度O(1)

    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <array.length ; j++) {
                if(array[minIndex]>array[j]){
                    minIndex=j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    public static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    //选择排序

    public static void selectFasterSort(int[] array){
        int left=0;
        int right=array.length-1;
        while(left<right){
            int minIndex=left;
            int maxIndex=left;
            for (int i = left+1; i <=right ; i++) {
                if(array[i]<array[minIndex]){
                    minIndex=i;
                }
                if(array[i]>array[maxIndex]){
                    maxIndex=i;
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
    //时间复杂度 O(n*log n)
    //空间复杂度 O(1)

    public static void heapSort(int[] array){

        createHeap(array);
        int end=array.length-1;
        while (end>0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }

    }
    public static void createHeap(int[] array){
        for (int parent = (array.length-2)/2; parent>= 0; parent--) {
            shiftDown(array,parent,array.length);
        }
    }

    private static void shiftDown(int[] array, int parent, int length) {
        int child=parent*2+1;
        while (child<length){
            if(child+1<length&&array[child]<array[child+1]){
                child++;
            }
            if(array[child]>array[parent]){
                swap(array,child,parent);
                parent=child;
                child=parent*2+1;
            }else {
                break;
            }
        }
    }
    //冒泡排序
    //时间复杂度 O(n^2)
    //空间复杂度 O(1)
    //稳定
    public static void bublleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            boolean flg=false;
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flg=true;
                }

            }
            if (!flg){
                break;
            }
        }
    }
    //快速排序

    //时间复杂度O(N^2)
    //空间复杂度O(logN);
    //不稳定
    public static void quickSort(int[] array){
//        quick(array,0,array.length-1);
        quickNor(array,0,array.length-1);

    }

    private static void quickNor(int[] array, int start, int end) {

        Deque<Integer> stack=new ArrayDeque<>();
        int pivot=partition2(array,start,end);
        if(pivot>start+1){
            stack.push(start);
            stack.push(pivot-1);
        }
        if(pivot<end-1){
            stack.push(pivot+1);
            stack.push(end);
        }
        while(!stack.isEmpty()){
            end= stack.pop();
            start=stack.pop();
            pivot=partition2(array,start,end);
            if(pivot>start+1){
                stack.push(start);
                stack.push(pivot-1);
            }
            if(pivot<end-1){
                stack.push(pivot+1);
                stack.push(end);
            }
        }
    }

    private static void quick(int[] array, int start, int end) {
        if(start>=end){
            return;
        }
        //优化二 直接插入法减少空间消耗
        if(end-start+1<=7){
            testInsertSort(array,start,end);
            return;
        }

        //优化一 三数取中间值放在start位置
        int midValIndex=getMidValIndex(array,start,end);
        swap(array,start,midValIndex);

        int midVal=partition2(array,start,end);
        quick(array,start,midVal-1);
        quick(array,midVal+1,end);

    }

    private static void testInsertSort(int[] array, int start, int end) {
        for (int i = start+1; i <=end ; i++) {
            int j=i-1;
            int tmp=array[i];
            for (; j  >=start ; j--) {
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else {
                    break;
                }
            }
            array[j+1]=tmp;

        }
    }

    private static int getMidValIndex(int[] array, int start, int end) {
        int minIndex=(start+end)/2;
        if(array[start]<array[end]){
            if(array[minIndex]<array[start]){
                return start;
            } else if (array[minIndex]>array[end]) {
                return end;
            }else {
                return minIndex;
            }
        }else{
            if(array[minIndex]>array[start]){
                return start;
            } else if (array[minIndex]<array[end]) {
                return end;
            }else {
                return minIndex;
            }
        }
    }

    //前后指针法  不支持三数取中的优化
    private static int partition(int[] array,int left,int right){
        int prev=left;
        int cur=left+1;
        while(cur<=right){
            if(array[cur]<array[left]&&array[++prev]!=array[cur]){
                swap(array,cur,prev);
            }
            cur++;
        }
        swap(array,left,prev);
        return left;
    }
    //挖坑法
    private static int partition2(int[] array,int left,int right){
        int tmpI=array[left];
        while (left<right){
            while (left<right&&tmpI<=array[right]){
                right--;
            }
            array[left]=array[right];
            while (left<right&&tmpI>=array[left]){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=tmpI;
        return left;
    }
    //hoare法
private static int partitionHoare(int[] array,int left,int right){
        int tmpI=left;
        while (left<right){
            while (left<right&&array[tmpI]<=array[right]){
                right--;
            }
            while (left<right&&array[tmpI]>=array[left]){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,tmpI,left);
        return left;
    }

    /**
     * 归并排序
     *
     * @param array
     */
    public static void mergeSort(int[] array){
        mergeSortTmp(array,0,array.length-1);

    }


    private static void mergeSortTmp(int[] array, int start, int end) {
        if(start>=end) return;
        int mid=(start+end)/2;
        mergeSortTmp(array,start,mid);
        mergeSortTmp(array,mid+1,end);

        //归并
        merge(array,start,mid,end);
    }
    private static void merge(int[] array,int left,int mid,int right){
        int s1=left;
        int e1=mid;
        int s2=mid+1;
        int e2=right;
        int i=0;
        int[] tmp=new int[right-left+1];
        while (s1<=e1&&s2<=e2){
            if(array[s1]<=array[s2]){  // = 决定稳定
                tmp[i++]=array[s1++];
            }else {
                tmp[i++]=array[s2++];
            }
        }
        while(s1<=e1){
            tmp[i++]=array[s1++];
        }
        while (s2<=e2){
            tmp[i++]=array[s2++];
        }
        for (int j = 0; j < i; j++) {
            array[j+left]=tmp[j];
        }
    }

    /**
     * 非递归实现归并排序
     * @param array
     */

    public static void mergeSortNor(int[] array){
        int gap=1;
        while (gap<array.length){
            for (int i = 0; i < array.length; i=i+gap*2) {
                int left=i;
                int mid=left+gap-1;
                if(mid>=array.length){
                    mid=array.length-1;
                }
                int right=mid+gap;
                if(right>=array.length){
                    right=array.length-1;
                }
                merge(array,left,mid,right);
            }
            gap*=2;
        }
    }

    /**
     * 计算数组
     * 时间复杂度 O(N+范围)
     * 空间复杂度 o(范围)
     * @param array
     */
    public static void countSort(int[] array){
        if(array==null) return;
        //1计算最大值，最小值
        int max=array[0];
        int min=array[0];
        for (int i = 1; i <array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        int[] count=new int[max-min+1];
        //2.完成计数
        for (int i = 0; i < array.length; i++) {
            int index=array[i]-min;
            count[index]++;
        }
        //3.写回原数组
        int indexVal=0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[indexVal++]=i+min;
            }
        }
    }
}
