package thread.waitnotify;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/18  17:35
 */
public class Demo2 {
    public static void main(String[] args) {
        Object locker1=new Object();
        Object locker2=new Object();

        Thread thread1=new Thread(()->{
            try {
                System.out.println("wait 前");
                synchronized (locker1){

                    locker1.wait();// 暂时解锁

                }
                System.out.println("wait 后");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2=new Thread(()->{
            Scanner scanner=new Scanner(System.in);
            System.out.println("阻塞等待,输入任何信息唤醒");
            scanner.next();
            synchronized (locker1){
                locker1.notify();// * 唤醒需要同一对象
                // 需要先wait 再notify
                // notify 没有副作用
            }
        });

        thread1.start();
        thread2.start();
    }
}
