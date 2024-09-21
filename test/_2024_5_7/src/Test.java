import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/7  11:40
 */
public class Test {

    public static String myToString(int[] array){
        String a="[";
        for (int i = 0; i < array.length; i++) {
            a+=array[i];
            if(i!=array.length-1){
                a+=", ";
            }
        }
        a+="]";
        return a;
    }
    public static String myDeepToString(int[][] array){
        String a="[";
        for (int i = 0; i < array.length; i++) {
            a+=myToString(array[i]);
            if(i!=array.length-1){
                a+=", ";
            }
        }
        a+="]";

        return a;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,4,3};
        System.out.println(addTwo(array,8));
        int[][] arr2={{1,2,31,2},{1,2,32,1,3}};
        System.out.println(Arrays.deepToString(arr2));
        System.out.println(myDeepToString(arr2));
    }
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static int selectSingle(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean flag=false;
            for (int j = 0; j < array.length; j++) {
                if(j!=i&&array[j]==array[i]){
                    flag=true;
                    break;
                }
            }
            //如果是单个数就返回这个数
           if(!flag){
               return array[i];
           }
        }
        return -1;
    }

    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    public static int numberMax(int[] array){
        for (int i = 0; i < array.length/2+1; i++) {
            int count=0;
            for (int j = 0; j < array.length; j++) {
                if(array[i]==array[j]){
                    count++;
                }
            }
            if(count>array.length/2){
                return array[i];
            }
        }
        return -1;
    }
//    给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
//    如果存在，请返回 true ；否则，返回 false 。
    public static boolean triOdds(int[] array){
        boolean flag=false;
        for (int i = 0; i < array.length-2; i++) {
            int ret=array[i]%2+array[i+1]%2+array[i+2]%2;
            if(ret==3){
               flag=true;
            }
        }
        return flag;
    }

    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    public static String addTwo(int[] array,int val){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i]+array[j]==val){
                    if(i!=j){
                        return "["+i+","+j+"]";
                    }else{
                        return "["+i+"]";
                    }
                }
            }
        }
        return null;
    }

    public static void main2(String[] args) {
//        int[] array={1,1,4,3,2,3,4};
//        int ret=selectSingle(array);
//        System.out.println(ret);

//        int[] array={1,2,3,1};
//        System.out.println(numberMax(array));

        int[] array={1,2,3,1};
//        System.out.println(triOdds(array));
        System.out.println(addTwo(array,2));
    }

    //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 ,
    // 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static int[] transform(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i]*=2;
        }
        return array;
    }
    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    // 如数组：[1,2,3,4,5,6]
    //调整后可能是：[1, 5, 3, 4, 2, 6]
    public static int[] adjustArray(int[] array){
        int j=0;//前下标找偶数
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2!=0){
                if (array[j]%2==0) {
                    int tmp=array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
                j++;
            }
        }
        return array;
    }
    //二分查找
    public static int binarySearch(int[] array,int val){
        int left=0;
        int right=array.length-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(array[mid]==val){
                return mid;
            }else if(array[mid]<val){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }
    public static void main1(String[] args) {
        int[] array={1,2,2,3,2,4,5,6,7,8};
//        transform(array);
        adjustArray(array);
        bubbleSort(array);
        int ret=binarySearch(array,2);
        System.out.println(ret);
        System.out.println(Arrays.toString(array));
    }
}
