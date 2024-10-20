package bite.problems.threads;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/19  16:46
 */
public class Demo3 {
    private static int count=0;

    public static void main(String[] args) throws InterruptedException {
        Object locker=new Object();
        
        Thread thread1=new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                synchronized(locker){
                    count++;
                }
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                synchronized (locker){
                    count++;
                }
            } 
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}
