package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  11:25
 */
public class Dog extends Animal implements A {

    public void A(){
        System.out.println(" A   dog......");
    }

    public Dog(int a, String name) {
        super(a, name);
    }

    public void eat(){
        System.out.println("dog .......eat");
    }
}
