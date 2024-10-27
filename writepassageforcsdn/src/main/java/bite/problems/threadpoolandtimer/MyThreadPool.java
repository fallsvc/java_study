package bite.problems.threadpoolandtimer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/27  22:10
 */
public class MyThreadPool {
    private BlockingQueue<Runnable> blockingQueue=null;

    public MyThreadPool(int n) throws InterruptedException {
        blockingQueue=new ArrayBlockingQueue<>(1000);
        for (int i = 0; i < n; i++) {
            Thread thread=new Thread(()->{
               while(true){
                   Runnable runnable= null;
                   try {
                       runnable = blockingQueue.take();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   runnable.run();
               }
            });
            thread.start();
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        blockingQueue.put(runnable);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool=new MyThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int id =i;
            myThreadPool.submit(()->{
                System.out.println(Thread.currentThread().getName()+"第"+id);
            });
        }
    }
}
