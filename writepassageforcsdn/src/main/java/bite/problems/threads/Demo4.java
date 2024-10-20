package bite.problems.threads;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/19  16:59
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Object locker1=new Object();
        Object locker2=new Object();
        Object locker3=new Object();

        Thread thread1=new Thread(()->{
                synchronized(locker1){
                    try {
                        locker1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print('a');
                synchronized(locker2){
                    locker2.notify();
                }
        },"a");
        Thread thread2=new Thread(()->{

                synchronized(locker2){
                    try {
                        locker2.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println('b');
        },"b");
        Thread thread3=new Thread(()->{
                System.out.print('c');

                synchronized(locker1){
                    locker1.notify();
                }
        },"c");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        synchronized (locker3){
            locker3.notify();
        }
    }
    public static void main1(String[] args) throws InterruptedException {
        Object locker1=new Object();
        Object locker2=new Object();
        Object locker3=new Object();

        Thread thread1=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized(locker1){
                    try {
                        locker1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print('A');
                synchronized(locker2){
                    locker2.notify();
                }
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized(locker2){
                    try {
                        locker2.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print('B');
                synchronized(locker3){
                    locker3.notify();
                }
            }
        });
        Thread thread3=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized(locker3){
                    try {
                        locker3.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println('C');
                synchronized(locker1){
                    locker1.notify();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);
        synchronized (locker1){
            locker1.notify();
        }

    }
}
