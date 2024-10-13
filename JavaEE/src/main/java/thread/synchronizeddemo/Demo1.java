package thread.synchronizeddemo;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/13  11:47
 */
class Counter{
    public int count;

//    public void add(){
//        synchronized (this){
//            count++;
//        }
//    }
    //也是以this为锁对象
    synchronized public void add(){
        count++;
    }

    public int getCount(){
        return count;
    }

    // 静态方法的两种写法 （给类对象加锁）
    // 1.
    synchronized public static void func(){
       // 2.
        synchronized (Counter.class){

        }
    }
}
public class Demo1 {
    public static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();// 锁对象
        Counter counter=new Counter();

        Thread thread1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
//                synchronized (lock){
                    counter.add();
//                }
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
               // 可重入  加锁
                synchronized (lock) {
                    synchronized (lock){
                        counter.add();
                    }
                }
            }
        });

        // 并发
        thread1.start();
        thread2.start();

        // 这两个可以交换顺序 等待时间是相同的
        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());
    }
}
