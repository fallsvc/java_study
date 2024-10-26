package threadPlus.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/25  21:15
 */
public class Demo1 { 
    // 使用原子类 代替int
    // private static int count=0;
    // CAS
    private static AtomicInteger count=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                // count++
                count.getAndIncrement();
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("count= "+count);
    }

}
