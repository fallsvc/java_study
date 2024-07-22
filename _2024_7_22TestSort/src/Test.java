import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/22  19:48
 */
public class Test {
    public static void main(String[] args) {
        int[] array={9,8,7,6,5,4,3,2,1};
//        Sort.quickSort(array);
        Sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
