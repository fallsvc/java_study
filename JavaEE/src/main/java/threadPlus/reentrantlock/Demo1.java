package threadPlus.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/26  16:06
 */
public class Demo1 {
    public static int count=0;
    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock reentrantLock=new ReentrantLock();
        ReentrantLock reentrantLock=new ReentrantLock(true);// 公平锁


        Thread thread1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                reentrantLock.lock();
                try{
                    count++;
                }finally {
                    reentrantLock.unlock();
                }
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                reentrantLock.lock();
                count++;
                reentrantLock.unlock();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);

    }
}
