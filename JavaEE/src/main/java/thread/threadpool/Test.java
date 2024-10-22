package thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/22  22:59
 */
class MyThreadPool {
    private BlockingQueue<Runnable> blockingQueue=null;

    public MyThreadPool(int n){
        blockingQueue=new ArrayBlockingQueue<>(1000);

        for (int i = 0; i < n; i++) {
            Thread thread=new Thread(()->{
                try{
                    while (true){
                        Runnable task=blockingQueue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }

    }
    public void submit(Runnable runnable) throws InterruptedException {
        blockingQueue.put(runnable);
    }
}
public class Test{
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool=new MyThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int id=i;
           pool.submit(()->{
               System.out.println(Thread.currentThread().getName()+"i="+id);
           });
        }
    }
}
