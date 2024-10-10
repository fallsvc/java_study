package thread.multithreading;

// 高内聚低耦合
/**
 * @auther falls_vc
 * description:
 * @date 2024/10/8  23:36
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=new Runnable(){
          @Override
          public void run(){
              while (true) {
                  System.out.println("Thread");
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
              }
          }
        };
        Thread thread=new Thread(runnable);
        thread.start();

        while (true) {
            System.out.println("main");
            Thread.sleep(1000);
        }
    }

}
