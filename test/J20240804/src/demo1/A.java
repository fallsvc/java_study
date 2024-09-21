package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/4  15:54
 */
public class A implements B{
    @Override
    public void test1() {
        System.out.println(1);
    }

    public static void main(String[] args) {
//        B b=new B();//error
        B b=new A();
    }
}
