package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/6  19:14
 */
public class Test {
    public static int[] fun(int[] arr1){

        return arr1;
    }
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        fun(arr1);


        int[] arr2={4,4,4};

        arr1[1]=3;//把arr1的2改为3

        arr2=arr1;//arr2引用arr1引用地址


//        Object a=null;
//        a.toString();
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        for (int x :
                arr1) {
            System.out.println(x);
        }

//        System.out.println(arr1[0]);
//        System.out.println(arr1[4]);
        //error
//        int[] arr1;
//        arr1={1,2,3};
    }
    public static void main1(String[] args) {
        int[] array1=new int[10];//存放10个int型整数
        String[] array2=new String[10];


        int[] arr1=new int[]{1,2,3};
        int[] arr2={1,2,3};
    }
}
