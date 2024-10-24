package thread.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/24  20:02
 */
public class Demo1 {
    public static void main(String[] args) {
        // 线程池计时器
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)  Executors.newScheduledThreadPool(4);

    }
    public static void main2(String[] args) {
        MyTimer timer=new MyTimer();
        timer.schedule(()->{
            System.out.println("hello 3000");
        },3000);
        timer.schedule(()->{
             System.out.println("hello 2000");
        },2000);
        timer.schedule(()->{
            System.out.println("hello 1000");
        },1000);
    }
    public static void main1(String[] args) {
        Timer timer=new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        },3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        },1000);

        System.out.println("hello main");
    }
}
