package Test1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  18:53
 */
public class A {
    public String name;
    public int age=20;
    public static int z=10;
    static{
        z=20;
    }
    {
        age=10;
    }

    public A() {
    }

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public A eat(){
        System.out.println("..........a");
        return this;
    }

    public void atalk(){
        System.out.println("a jjjjj");
    }

}
