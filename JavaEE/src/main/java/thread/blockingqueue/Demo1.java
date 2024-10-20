package thread.blockingqueue;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/19  14:59
 */
public class Demo1 {
    public static void main(String[] args) {
//        BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<>(100);

        MyBlockingQueue blockingQueue=new MyBlockingQueue(100);
        Thread prodecer=new Thread(()->{
           int n=0;
           while(n<199){
//               try {
                   System.out.println("生产元素  "+ n);
               try {
                   blockingQueue.put(n);

               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
//                   Thread.sleep(1000);//// consumer 等待put
//               } catch (InterruptedException e) {
//                   throw new RuntimeException(e);
//               }
               n++;
           }
            System.out.println("producer 结束");
        });

        Thread consumer=new Thread(()->{
            int n=0;
            while(n<199){
                int ret= 0;
                try {
                    ret = blockingQueue.take();
                    System.out.println("消费元素  "+ret);
                    // 阻塞队列装满了等待consumer消费一个 ，然后 继续产生
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                n++;
            }
            System.out.println("consumer 结束");

        });

        prodecer.start();
        consumer.start();
    }

    public static void main1(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new LinkedBlockingQueue<>(100);
//        LinkedList<String> linkedList=new LinkedList<>();
//
//        for (int i = 0; i < 100; i++) {
//            blockingQueue.put("aaa");
//        }
//        blockingQueue.put("bbbb");
//        String elem=blockingQueue.take();

        blockingQueue.add("sting");
        blockingQueue.add("aaa");
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.take());
    }
}
