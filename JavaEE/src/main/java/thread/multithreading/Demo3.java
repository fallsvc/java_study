package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/8  23:29
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){// 匿名内部类
            @Override
            public void run(){
                while(true){
                    System.out.println("Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t.start();

        while(true){
            System.out.println("main");
            Thread.sleep(1000);
        }

    }
}
