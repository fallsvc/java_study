package threadPlus.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/26  16:30
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(3);

        semaphore.acquire();
        System.out.println("p操作一次");
        semaphore.acquire();
        System.out.println("p操作一次");
        semaphore.acquire();
        System.out.println("p操作一次");
        // 如果再p一次 则会阻塞
    }
}
