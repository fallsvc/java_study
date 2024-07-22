/**
 * @auther falls_vc
 * description:
 * @date 2024/7/22  19:33
 */
public class Sort {
    // 冒泡排序
    public static void bubbleSort(int[] array){
        // write code  here
        for (int i = 0; i < array.length - 1; i++) {
            boolean flg=false;
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flg=true;
                }
            }
            if(!flg){
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp=array[i];
        array[i]= array[j];
        array[j]=tmp;
    }

    // 快速
    public static void quickSort(int[] array){
        // write code  here
        quick(array,0,array.length-1);
    }

    private static void quick(int[] array, int start, int end) {
        if(start>=end){
            return ;
        }
        int midVal=partition(array,start,end);
        quick(array,start,midVal-1);
        quick(array,midVal+1,end);
    }

    //挖坑法
    private static int partition(int[] array, int start, int end) {
        int tmp=array[start];
        while(start<end){
            while (start<end&&tmp<array[end]){
                end--;
            }
            array[start]=array[end];
            while (start<end&&tmp>array[start]){
                start++;
            }
            array[end]=array[start];
        }
        array[start]=tmp;
        return start;
    }
}
