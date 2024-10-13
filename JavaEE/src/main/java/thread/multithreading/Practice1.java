package thread.multithreading;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/11  15:29
 */
public class Practice1 {
    public static Long sum1=0L;
    public static Long sum2=0L;

    public static Long getSum(Long[] array) throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (int i = 0; i < array.length; i+=2) {
                sum1+=array[i];
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 1; i <array.length ; i+=2) {
                sum2+=array[i];
            }
        });
        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();
        return sum1+sum2;
    }

    public static void main(String[] args) throws InterruptedException {
        Long[] array={10L,30L,40L,60L};
        System.out.println(getSum(array));
    }

}
