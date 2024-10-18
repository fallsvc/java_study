package thread.waitnotify;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/18  22:58
 */
public class Demo4 {
    public static void main(String[] args) {
        Object object=new Object();
        Thread thread=new Thread(()->{
            System.out.println("start  ");
            synchronized (object){
                try {
                    object.wait(10);
                    System.out.println("end ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
