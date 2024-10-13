package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/11  11:26
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while(true){
                System.out.println("thread");
                try {
                    Thread.sleep(1000);// TIMED_WAITING
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // NEW 对象未创建线程
        System.out.println(thread.getState());

        thread.start();
        // Runnable 线程正在运行
        // TERMINATED 线程结束
        System.out.println(thread.getState());
        Thread.sleep(1000);

//        thread.join(3000);// TIMED_WAITING 使main进入

        thread.join();// 可能会进入WAITING

    }
}
