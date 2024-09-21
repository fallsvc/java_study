package Test1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  18:53
 */
public class B extends A{
    public B() {
    }

    public B(String name, int age) {
        super(name, age);
    }

    public void btalk(){
        System.out.println("b jjjjj");
    }

    @Override
    public B eat() {
        System.out.println(" .........b");
        return this;
    }

}
