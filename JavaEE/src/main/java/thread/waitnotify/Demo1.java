package thread.waitnotify;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/18  16:44
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Object object=new Object();
        System.out.println("wait 前");
        synchronized(object){// 加锁

            object.wait();// 解锁
            // 加锁
        }// 解锁
        System.out.println("wait 后");
    }
}
