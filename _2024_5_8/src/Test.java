import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/8  10:26
 */
public class Test {
    public static void main(String[] args) {
        int[] array=new int[10];
        Arrays.fill(array,0,10,2);

    }
//调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
//如数组：[1,2,3,4,5,6]
//调整后可能是：[1, 5, 3, 4, 2, 6]
    public static void func4(int[] array){
        int i=0;
        int j=array.length-1;
        while(i<j){
            while(i<j&&array[i]%2!=0){
                i++;
            }
            while(i<j&&array[j]%2==0){
                j--;
            }
            int tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
        }
    }
//    给定一个非空整数数组，除了某个元素只出现一次以外，
//    其余每个元素均出现两次。找出那个只出现了一次的元素
    public static int singleNumber(int[] array){
        int ret=0;
        for (int x :
                array) {
            ret^=x;
        }
        return ret;
    }
    //返回数组中一个数个数大于n/2
    public static int majorityElement(int[] array){
        Arrays.sort(array);
        return array[array.length/2];
    }
//    给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数
//    的情况：如果存在，请返回 true ；否则，返回 false 。
    public static boolean threeConsecutiveOdds(int[] array){
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==1){
                count++;
                if(count==3){
                    return true;
                }
            }else {
                count = 0;
            }
        }
        return false;
    }
    public static void main1(String[] args) {
        int[] array={1,2,1,1,1,2,3,4,4};
        System.out.println(threeConsecutiveOdds(array));
        System.out.println(singleNumber(array));
        func4(array);
        System.out.println(Arrays.toString(array));
    }
}
