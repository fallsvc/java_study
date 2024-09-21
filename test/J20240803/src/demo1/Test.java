package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/3  14:13
 */
public class Test {
    public static void main(String[] args) {
        //纯粹的引用一系列一维数组
        int[][] array={{1,2,3},{1,2},{4,3,2}};
        //遍历1
        for (int[] x :
                array) {
            System.out.println(Arrays.toString(x));
        }
        //遍历2
        System.out.println(Arrays.deepToString(array));
    }
    public static void reverse(int[] array){
        int left=0;
        int right=array.length-1;
        while (left<right){
            swap(array,left,right);
            left++;
            right--;
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public static void main4(String[] args) {
        int[] array={7,6,5,4,3,2,1};
        Arrays.sort(array);
        reverse(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) { //-1 优化1 少排一趟
            boolean flag=false;//优化2 如果排好没交换就直接结束排序
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


    public static void main3(String[] args) {
        int[] array={1,2,3,4,3,4,5,6,7,8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        int retIndex=myBinarySearch(array,3);
        System.out.println(retIndex);
    }
    //升序数组演示
    public static int myBinarySearch(int[] array,int key){
        if(array==null) return -1;//模拟
        int left=0;
        int right=array.length-1;
        while(left<=right){
            int mid=(right-left)/2+left;
            if(array[mid]<key){
                left=mid+1;
            }else if(array[mid]>key){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static int[] myCopyOf(int[] array,int length){
        if(array==null) return array;
        int[] newArray=new int[length];//创建数组
        //拷贝数组
        for (int i = 0; i <array.length; i++) {
            newArray[i]=array[i];
        }
        return newArray;
    }
    public static void main2(String[] args) {
        int[] array={1,2,3,4,5,6,7};
        //拷贝一份新数组 长度为原来的两倍，新数组不足部分默认0值 [1,2,3,4,5,6,7,0,0,0,0,0,0,0]
//        int[] newArray1=Arrays.copyOf(array,array.length*2);
        int[] newArray1=myCopyOf(array,array.length*2);
        System.out.println(Arrays.toString(newArray1));
        //拷贝一份数组，从原数组的1下标到2下标  [2,3]
        int[] newArray2=Arrays.copyOfRange(array,1,3);
        System.out.println(Arrays.toString(newArray2));
    }
    public static void main1(String[] args) {
        int[] array={1,2,3,3,4,5,5};
        //import java.util.Arrays;  导入工具类Arrays
        String newArray= Arrays.toString(array);//toString()将数组转化为字符串

        System.out.println(newArray);
    }
}
