package practice1;

import java.util.HashMap;
import java.util.Map;

public class ModeFinder {

    public static void main(String[] args) {
        int[] S = {1,1,1,1,1,1,1,1,1}; // 示例多重集
        int[] result = findMode(S);
        System.out.println("众数: " + result[0] + ", 重数: " + result[1]);
    }

    public static int[] findMode(int[] S) {
        // 使用哈希表统计每个元素的频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : S) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // 找到众数及其重数
        int mode = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mode = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return new int[]{mode, maxCount};
    }
}