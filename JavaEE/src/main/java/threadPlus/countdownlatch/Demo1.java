package threadPlus.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/27  10:12
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // 把任务拆成10个

        CountDownLatch downLatch=new CountDownLatch(10);
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int id=i;
            executorService.submit(()->{
                System.out.println("开始执行任务："+id);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("结束执行任务："+id);

                downLatch.countDown();
            });

        }
        // 等待10任务完成
        downLatch.await();
        System.out.println("所有任务执行完毕");
        executorService.shutdown();// 释放线程池
    }
}
