package thread.waitnotify;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/18  17:54
 */
public class Demo3 {
    public static void main(String[] args) {
        Object object=new Object();

        Thread thread1=new Thread(()->{
            try{
                System.out.println("wait 前");
                synchronized(object){
                    object.wait();
                }
                System.out.println("wait 后");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2=new Thread(()->{
            try{
                System.out.println("wait 前");
                synchronized(object){
                    object.wait();
                }
                System.out.println("wait 后");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread3=new Thread(()->{
            Scanner scanner=new Scanner(System.in);
//            while (true) {
//                System.out.println("输入唤醒");
//                scanner.next();
//                synchronized(object){
//                    object.notify();
//                }
//            }
            System.out.println("输入唤醒");
                scanner.next();
                synchronized(object){
                    object.notifyAll();
                }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
