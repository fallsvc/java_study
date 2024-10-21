package bite.problems.threads;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/20  11:27
 */

/**
 * 嵌套死锁
 */
public class Demo5 {
    public static void main(String[] args) {
        Object locker1=new Object();
        Object locker2=new Object();

        Thread thread1=new Thread(()->{
           synchronized(locker1){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               synchronized (locker2){
                   System.out.println("thread1 ");
               }
           }
        });
        Thread thread2=new Thread(()->{
           synchronized(locker2){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               synchronized(locker1){
                   System.out.println("thread2 ");
               }
           }
        });
        thread1.start();;
        thread2.start();
    }
}
