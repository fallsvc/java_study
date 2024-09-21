package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/23  14:56
 */
public class Sort {
    // 归并排序---递归
    public static void mergeSort(int[] array){
        // write code  here
        mergeSortTmp(array,0,array.length-1);
    }

// 归并排序---非递归
    public static void mergeSortTmp(int[] array,int start,int end){
        // write code  here
        if(start>=end) return;
        int mid=(start+end)/2;
        mergeSortTmp(array,start,mid);
        mergeSortTmp(array,mid+1,end);

        merge1(array,start,mid,end);
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
    private static void merge1(int[] array, int start, int mid, int end) {
        int s1=start;
        int e1=mid;
        int s2=mid+1;
        int e2=end;
        int[] tmp=new int[e2-s1+1];
        int k=0;
        while(s1<=e1&&s2<=e2){
            if(array[s1]<array[s2]){
                tmp[k++]=array[s1++];
            }else {
                tmp[k++]=array[s2++];
            }
        }
        while(s1<=e1){
            tmp[k++]=array[s1++];
        }
        while (s2<=e2){
            tmp[k++]=array[s2++];
        }
        for (int i = 0; i < k ; i++) {
            array[i+start]=tmp[i];
        }
    }

    // 计数排序
    public static void countSort(int[] array){
        // write code  here
        //计算最大值最小值
        int max=array[0];
        int min=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        int[] count=new int[max-min+1];
        //写计数数组
        for (int i = 0; i < array.length; i++) {
            int index=array[0]-min;
            count[i]++;
        }
        //写回
        int k=0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[k++]=i+min;
            }
        }
    }
}
