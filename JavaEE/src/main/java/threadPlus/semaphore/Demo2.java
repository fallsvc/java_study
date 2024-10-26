package threadPlus.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/26  16:36
 */
public class Demo2 {
    private static int count=0;

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(1);

        Thread thread1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("count= "+count);
    }
}
