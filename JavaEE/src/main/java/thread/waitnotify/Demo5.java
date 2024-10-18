package thread.waitnotify;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/18  23:07
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Object locker1=new Object();
        Object locker2=new Object();
        Object locker3=new Object();

        Thread thread1=new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized(locker1){
                        locker1.wait();
                    }
                    System.out.print('A');
                    synchronized (locker2){
                        locker2.notify();
                    }
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2=new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized(locker2){
                        locker2.wait();
                    }
                    System.out.print('B');
                    synchronized (locker3){
                        locker3.notify();
                    }
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3=new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized(locker3){
                        locker3.wait();
                    }
                    System.out.print('C');
                    System.out.println();
                    synchronized(locker1){
                        locker1.notify();
                    }
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);
        synchronized(locker1){
            locker1.notify();
        }
    }
}
