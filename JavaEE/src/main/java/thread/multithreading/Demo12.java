package thread.multithreading;

/**
 * bug 实际效果和预期效果不一样
 * @auther falls_vc
 * description:
 * @date 2024/10/11  11:57
 */
public class Demo12 {
    public static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        // 并发
        thread1.start();
        thread2.start();

        // 这两个可以交换顺序 等待时间是相同的
        thread1.join();
        thread2.join();

//        // 串行执行
//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();

        System.out.println(count);
    }
}
