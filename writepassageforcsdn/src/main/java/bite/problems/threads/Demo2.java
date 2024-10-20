package bite.problems.threads;

/**实现创建线程的五种写法
 * @auther falls_vc
 * description:
 * @date 2024/10/15  17:26
 */
class MyThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程开启");
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程开启");
    }
}
public class Demo2 {

    public static void main2(String[] args) throws InterruptedException {
        Thread thread=new Thread(new MyRunnable());
        thread.start();
        thread.join();

        System.out.println("main线程结束");
    }


    public static void main1(String[] args) throws InterruptedException {
        Thread thread=new MyThread();
        thread.start();
        thread.join();

        System.out.println("main线程结束");
    }

    public static void main3(String[] args) throws InterruptedException {
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程开启");
            }
        };
        thread.start();
        thread.join();

        System.out.println("main线程结束");
    }

    public static void main4(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程开启");
            }
        });

        thread.start();
        thread.join();

        System.out.println("main线程结束");
    }

    public static void main5(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程开启");
        });

        thread.start();
        thread.join();

        System.out.println("main线程结束");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.start();
//        Thread.sleep(1);
        System.out.println("2");
    }

}
