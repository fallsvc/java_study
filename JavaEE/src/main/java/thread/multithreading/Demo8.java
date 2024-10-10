package thread.multithreading;

// 进程有父子关系
// 线程没有
/**
 * @auther falls_vc
 * description:
 * @date 2024/10/10  21:24
 */
public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
//            while(true){
//
//            }
            for (int i = 0; i < 3; i++) {
                System.out.println("thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println(thread.isAlive());// false此时未开启线程
        // 设置为后台线程 随进程结束不影响主进程
//        thread.setDaemon(true);
        thread.start();

        while(true){
            System.out.println(thread.isAlive());
            Thread.sleep(1000);
        }
//        for (int i = 0; i < 3; i++) {
//            System.out.println("main");
//            Thread.sleep(1000);
//        }
//        System.out.println("main结束");
    }
}
