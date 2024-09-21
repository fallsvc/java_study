package Demo3;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  23:18
 */
public class Dog extends Animal implements Ac{
    @Override
    public void eat() {
        System.out.println("dog ...eat");
    }

    @Override
    public void doWork() {
        System.out.println("barkkkkk ..");
    }
}
