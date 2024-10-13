package thread.synchronizeddemo;

import java.util.Vector;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/13  15:24
 */
public class Demo2 {

    // 死锁的特点
    // 1. 互斥
    // 2. 不可剥夺
    // 3. 请求和保持
    // 4. 循环等待
    // 死锁
    public static void main1(String[] args) {
        Object locker1=new Object();
        Object locker2=new Object();

        Thread thread1=new Thread(()->{
           synchronized (locker1){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               synchronized(locker2){
                   System.out.println("获取两把锁");
               }
           }
        });
        Thread thread2=new Thread(()->{
           synchronized (locker2){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               synchronized(locker1){
                   System.out.println("获取两把锁");
               }
           }
        });
        thread1.start();
        thread2.start();
    }
    // 解决死锁问题
    // 嵌套锁到-》并列锁
    // 嵌套锁按 先获取序号小的锁-》序号大的锁
    public static void main2(String[] args) {
        Object locker1=new Object();
        Object locker2=new Object();

        Thread thread1=new Thread(()->{
           synchronized (locker1){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
           synchronized(locker2){
                System.out.println("获取两把锁");
            }
        });
        Thread thread2=new Thread(()->{
           synchronized (locker2){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
           synchronized(locker1){
                System.out.println("获取两把锁");
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void main3(String[] args) {
        Vector<Integer> vector=new Vector<>();
        vector.add(1);
        vector.add(3);
        vector.add(2);
        Integer[] integers=vector.toArray(new Integer[0]);
        for (Integer x :
                integers) {
            System.out.println(x);
        }
    }
}
