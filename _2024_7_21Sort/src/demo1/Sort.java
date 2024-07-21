package demo1;

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
        for (int parent = (array.length-2)>>>1; parent>= 0; parent--) {
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
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);

    }

    private static void quick(int[] array, int start, int end) {
        if(start>=end){
            return;
        }

        int midVal=partition(array,start,end);
        quick(array,start,midVal-1);
        quick(array,midVal+1,end);

    }

    //前后指针法
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

}
