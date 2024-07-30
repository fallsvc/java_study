package InnerClass;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/30  20:11
 */
interface IA{
    void test();
}
class A{
    public int a=10;
    public void test(){
        System.out.println(a);
    }
}
public class Test {
    public static void main(String[] args) {
        A a=new A();
        a.test();

        //不能A a=new...引用下面这个，而接口可以
       new A(){
           @Override
           public void test() {
               System.out.println(a*2);
           }
       }.test();
    }
    public static void main2(String[] args) {
//        new IA(){
//            @Override
//            public void test() {
//                System.out.println("AIIIII");
//            }
//        }.test();
        IA ia=new IA(){
            @Override
            public void test() {
                System.out.println("AIIIII");
            }
        };
        ia.test();
    }
    public static void main1(String[] args) {
        Outer.Inner i=new Outer.Inner();
        i.test();
        Outer outer=new Outer();
        Outer.Inner2 inner2=outer.new Inner2();
        inner2.test();

    }
}
