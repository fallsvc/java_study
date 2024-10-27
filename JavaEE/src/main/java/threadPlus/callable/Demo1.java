package threadPlus.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/26  15:31
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int count=0;
                for (int i = 1; i <=1000; i++) {
                    count+=i;
                }
                return count;
            }
        };
        FutureTask<Integer> futureTask=new FutureTask<>(callable);
        Thread thread=new Thread(futureTask);

        thread.start();

        System.out.println(futureTask.get());

    }
    public static void main1(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor();

    }
    public static void main2(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
               int call=0;
                for (int i = 0; i <=100; i++) {
                    call+=i;
                }
                return call;
            }
        };
        FutureTask<Integer> futureTask=new FutureTask<>(callable);

        Thread t=new Thread(futureTask);
        t.start();

        // 未get就会阻塞
        System.out.println(futureTask.get());

        FutureTask<Integer>  futureTask1=new FutureTask<>(()->{
            int call=0;
            for (int i = 0; i < 100; i++) {
                call+=i;
            }
            return call;
        });

        System.out.println(futureTask1.get());
    }
}
