package bite.problems.threads;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/15  17:11
 */
public class Demo1 {
    public static long count1=0L;
    public static long count2=0L;

    public static long countArray(long[] array) throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (int i = 0; i < array.length; i+=2) {
                count1+=array[i];
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 1; i < array.length; i+=2) {
                count2+=array[i];
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

       return count2+count1;
    }

    public static void main(String[] args) throws InterruptedException {
        long[] array={10L,30L,40L,7590L};

        System.out.println(countArray(array));

        System.out.println(count1);
        System.out.println(count2);
    }
}
