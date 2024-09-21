package SortTest;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/31  22:10
 */
public class Sort {
    //直接插入排序
    public static void insertSort(int[] array){
        if(array==null) return;
        for (int i = 1; i <array.length ; i++) {
            int j=i-1;
            int tmp=array[i];
            while (j>=0&&array[j]>tmp){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=tmp;
        }
    }
    public static void insertSort1(int[] array){
        if(array==null) return;
        for (int i = 1; i <array.length ; i++) {
            int j=i-1;
            int tmp=array[i];
            for (; j >=0 ; j--) {
                if(tmp<array[j]){
                    array[j+1]=array[j];
                }else {
                    array[j+1]=tmp;
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
}
