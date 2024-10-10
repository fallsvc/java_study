package thread.multithreading;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/10  22:23
 */
public class Demo9 {
    public static boolean isFilished=false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while(!isFilished){
                System.out.println("thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        isFilished=true;
    }
}
