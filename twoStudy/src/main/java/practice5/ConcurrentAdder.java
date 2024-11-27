package practice5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentAdder {
  // 根据n来生成n组操作数，并计算结果
  public static void add(int[][] operands, int[] res) {
    int n = operands.length;
    ExecutorService es = Executors.newFixedThreadPool(3); // 创建线程池
    es.submit(() -> {
      for(int i = 0; i < n / 2; i++) {
        res[i] = operands[i][0] + operands[i][1];
      }
    }); // 提交第一个任务，承担一半的计算
    es.submit(() -> {
      // 待完成
      for(int i =n/2; i < n ; i++) {
        res[i] = operands[i][0] + operands[i][1];
      }
    }); // 提交另一个任务，承担另一半计算
    es.shutdown(); // 任务结束后关闭
  }
}