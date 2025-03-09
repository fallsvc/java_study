package practice1;

public class CheckEvenOnes {

    // 递归函数
    public static boolean isEvenOnesRecursive(int[] arr, int index, int count) {
        if (index == arr.length) {
            return true; // 遍历结束
        }

        if (arr[index] == 1) {
            return isEvenOnesRecursive(arr, index + 1, count + 1);
        } else {
            if (count % 2 != 0) {
                return false; // 当前连续 1 的序列长度为奇数
            }
            return isEvenOnesRecursive(arr, index + 1, 0);//重新向下遍历
        }
    }

    public static void main1(String[] args) {
        int[] arr = {0,0,0,0,0,0,1};
        boolean result = isEvenOnesRecursive(arr, 0, 0);
        System.out.println("递归结果: " + result);
    }

        // 非递归函数
        public static boolean isEvenOnesNonRecursive(int[] arr) {
            int count = 0;
            for (int num : arr) {
                if (num == 1) {
                    count++;
                } else {
                    if (count % 2 != 0) {
                        return false; // 当前连续 1 的序列长度为奇数
                    }
                    count = 0;
                }
            }
            // 检查最后一个连续 1 的序列
            return count % 2 == 0;
        }

        public static void main(String[] args) {
            int[] arr = {0 ,0,0,0,0,0,0,1};
            boolean result = isEvenOnesNonRecursive(arr);
            System.out.println("非递归结果: " + result);
        }

}