package thread.memoryVisualProblem;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/13  17:26
 */
public class Demo1 {
    public static volatile int flag=0;// volatile 修饰变量
    // 针对一读一写

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(()->{
           while(flag==0){
//               try {
//                   // 使优化不把flag直接读到cpu
////                   Thread.sleep(1); // 1ms
//               } catch (InterruptedException e) {
//                   throw new RuntimeException(e);
//               }
               // or volatile
           }
            System.out.println("thread 1 ");
        });
        Thread thread2=new Thread(()->{
            Scanner scanner=new Scanner(System.in);
            flag=scanner.nextInt();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
