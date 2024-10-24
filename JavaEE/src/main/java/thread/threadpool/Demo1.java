package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/20  16:24
 */
public class Demo1 {
    public static void main1(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor();
    }
    public static void main(String[] args) {
        ExecutorService executorService1=Executors.newCachedThreadPool();
        ExecutorService executorService2=Executors.newFixedThreadPool(4);// 固定线程数

        for (int i = 0; i < 1000; i++) {
            int n=i;
            executorService2.submit(()->{
                System.out.println("n="+n+"   "+Thread.currentThread().getName());
            });
        }

        // 无法保证一定能执行完
        executorService2.shutdown();
        // 等待什么时候完成
//        executorService2.awaitTermination();
    }
}
