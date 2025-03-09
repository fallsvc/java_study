package practice1;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/3  21:21
 */
public class Demo1 {
    // 定义一个内部类来存储最小值和最大值
    static class MinMax {
        int min;
        int max;
        public MinMax(){

        }
        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    // 主方法：找到数组中的最小值和最大值
    public static MinMax findMinMax(int[] arr, int low, int high) {
        // 只有一个元素
        if (low == high) {
            return new MinMax(arr[low], arr[low]);
        }
        //有两个元素
        if (high == low + 1) {
            return new MinMax(Math.min(arr[low], arr[high]), Math.max(arr[low], arr[high]));
        }
        //找到中间点
        int mid = (low + high) / 2;
        // 递归求解左半部分
        MinMax left = findMinMax(arr, low, mid);
        // 递归求解右半部分
        MinMax right = findMinMax(arr, mid + 1, high);

        // 合并：比较左右部分的最小值和最大值
        int Min = Math.min(left.min, right.min);
        int Max = Math.max(left.max, right.max);

        return new MinMax(Min, Max);
    }

    public static void main(String[] args) {
        int[] arr = {12,2,2,2,2,2,2,2,2,2,1};
        MinMax result = findMinMax(arr, 0, arr.length - 1);
        System.out.println("最小值: " + result.min);
        System.out.println("最大值: " + result.max);
    }
}
