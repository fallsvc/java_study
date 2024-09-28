package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/28  15:30
 */

class MyThread extends Thread{
    /**
     * run 线程的入口
     *  编写自己的逻辑
     */
    @Override
    public void run(){
        while (true) {
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread();
        // 系统中创建线程
        t.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);

        }

    }
}
