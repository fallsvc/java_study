package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/10  19:18
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread结束");
        });
        t.start();

        // main线程的阻塞等待
//        t.join();// t结束才往下执行
        t.join(3000);// 停3000ms
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main 结束");
    }
}
