package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/10  22:40
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
//            System.out.println("thread:"+Thread.currentThread().getName());
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("thread ");
                try {
                    Thread.sleep(1000);//
                } catch (InterruptedException e) {
                    // 到这结束
//                    throw new RuntimeException(e);

                    break;
                }
            }

        });
        thread.start();

        Thread.sleep(3000);
        thread.interrupt();// 可能唤醒正在sleep 的 thread 线程 然后 sleep 把isInterrupted设置为false 抛出异常

//        System.out.println("thread"+Thread.currentThread().getName());
    }
}
