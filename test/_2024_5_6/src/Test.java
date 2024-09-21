import java.util.Arrays;
import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/6  18:03
 */
public class Test {
    public static void main(String[] args) {
        int[][] arr1={{1,2,3},{2,3,1,1}};
        int[][] arr2={{1,2,3},{2,3,1,1}};

        boolean a=Arrays.deepEquals(arr1,arr2);
        System.out.println(a);
    }

    //打印二维数组
    public static void printArray(int[][] array){
        //(1)
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        //(2)
        for (int[] x :
                array) {
            for (int y :
                    x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
    public static void main7(String[] args) {
        int[][] array1={{1,2},{1,2,3}};
        printArray(array1);
        System.out.println(array1[1][2]);
        System.out.println(Arrays.deepToString(array1));//（3）
    }
    public static void main6(String[] args) {

        int[] arr=new int[10];
        Arrays.fill(arr,1,5,-1);
        System.out.println(Arrays.toString(arr));

        int[] array={1,12,32,43,1,11};
        int[] array2={1,12,32,43,1,11};
        System.out.println(Arrays.equals(array,array2));

        int[] ret=Arrays.copyOf(array,2*array.length);

        int[] ret1=Arrays.copyOfRange(array,1,3);

        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(ret1));

    }
    //冒泡排序
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            boolean flag=false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flag=true;
                }
            }
            if(flag==false){
                return;
            }
        }
    }

    public static void main5(String[] args) {
        int[] array={6,5,76,3,2,54,2};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    //二分查找
    public static int binarySearch(int[] array,int k){
        int left=0;
        int right=array.length-1;
        while(left<=right){
            int mid =(left+right)>>>1;//等于除以2
            if(array[mid]==k){
                return mid;
            }else if(array[mid]<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main4(String[] args) {
        int[] array=new int[]{1,12,13,4,5,5};
        Arrays.sort(array);
        System.out.println(myToString(array));
        int ret1=Arrays.binarySearch(array,12);


        int ret2=binarySearch(array,2);
        System.out.println(ret2);
        System.out.println(myToString(array));
    }
    public static String myToString(int[] array){

        String a="[";
        int i=1;
        for (int j = 0; j < array.length; j++) {
//           if(j!=array.length-1){
//               a+=array[j]+",";
//           }else{
//               a+=array[j];
//           }
            a+=array[j];
            if(j!=array.length-1) {
                a+=",";
            }
        }
        a+="]";
        return a;
    }
    public static int[] func2(int[] arr){
        int[] ret=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i]=arr[i]*2;
        }
        return ret;
    }
    public static int[] func1(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i]*=2;
        }
        return arr;
    }
    public static void main3(String[] args) {

        int[] arr={111,21,2,32,1,112};
        func1(arr);
        System.out.println(Arrays.toString(arr));
        int[] ret=func2(arr);
        System.out.println(Arrays.toString(ret));
    }
//   int a=10;
    public static void main2(String[] args) {
        final int a=10;//final ~ const
//        a=20;//error
        int[] array={0,1,2,3,4,5};
        int[] arr2=array;

        System.out.println(array);
        System.out.println(arr2);

        int[] arr=null;
        System.out.println(arr.length);
    }
    public static void main1(String[] args) {
        Random random=new Random();
        int n=random.nextInt(1,10000);
        String a=random.toString();
        System.out.println(n);
        System.out.println(a);
        System.out.println("hehe"+'A');
    }
}
