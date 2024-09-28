package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/28  17:36
 */


class MyRunable implements Runnable{
    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Runnable ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=new MyRunable();
        Thread thread=new Thread(runnable);

        thread.start();

        while (true) {
            System.out.println("main ");
            Thread.sleep(1000);
        }
    }
}
