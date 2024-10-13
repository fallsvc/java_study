package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/11  14:42
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread=Thread.currentThread();
        Thread thread=new Thread(()->{
            try {
                // 等待主线程
                mainThread.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread");
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("Main");
    }
}
