package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/8  23:55
 */
public class Demo6 {
    public static void main(String[] args) {
        // 线程命名
        Thread thread=new Thread(()->{
            while(true){
                System.out.println("hello1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"hello1");
        thread.start();
        Thread thread2=new Thread(()->{
            while(true){
                System.out.println("hello2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"hello2");
        thread2.start();
        Thread thread3=new Thread(()->{
            while(true){
                System.out.println("hello3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"hello3");
        thread3.start();
    }
}
