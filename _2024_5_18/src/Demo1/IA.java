package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  11:27
 */
public class IA extends Animal implements A{
    @Override
    public void eat() {
        System.out.println("IA.... eat");
    }

    @Override
    public void A() {
        System.out.println("A.....IA");
    }
    public IA(int a, String name) {
        super(a, name);
    }


}
