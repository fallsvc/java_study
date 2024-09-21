package Demo3;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  23:14
 */
public class Bird extends Animal implements Ac{
    @Override
    public void eat() {
        System.out.println("bird...eat");
    }

    @Override
    public void doWork() {
        System.out.println("fly.......");
    }
}
