package threadPlus.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/27  20:29
 */
public class Demo2 {
    private static AtomicInteger count=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (int i=0;i<1000;i++) {
                count.getAndIncrement();
            }
        });
        Thread thread2=new Thread(()->{
            for (int i=0;i<1000;i++) {
                count.getAndIncrement();
            }
        });
        Thread thread3=new Thread(()->{
            for (int i=0;i<1000;i++) {
                count.getAndIncrement();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(count.get());
    }
}
