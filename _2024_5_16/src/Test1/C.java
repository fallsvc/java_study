package Test1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  18:53
 */
public class C extends B{

    public C() {
    }

    public C(String name, int age) {
        super(name, age);
    }

    public void ctalk(){
        System.out.println("c jjjjj");
    }

    public C eat(){
        System.out.println("......c");
        return this;
    }

}
