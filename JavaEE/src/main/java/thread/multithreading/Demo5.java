package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/8  23:49
 */

/**
 * 给线程起名字
 */
public class Demo5 {
    public static void main(String[] args)  {
        Thread thread=new Thread(()->{
            while (true) {
                System.out.println("Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        while (true) {
            System.out.println("main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
