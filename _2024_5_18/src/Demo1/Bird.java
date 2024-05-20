package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  13:25
 */
public class Bird extends Animal implements All{

    public Bird(int a, String name) {
        super(a, name);
    }

    @Override
    public void eat() {
        System.out.println("bird...eat");
    }

    @Override
    public void A() {
        System.out.println("A......bid");
    }

    @Override
    public void B() {
        System.out.println("B......bird");

    }

    @Override
    public void C() {
        System.out.println("C........bird");
    }
}
