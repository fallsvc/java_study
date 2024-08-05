package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/4  14:56
 */
abstract class T1 {
//    private abstract void test1();//error
//    abstract final void test2();//error
//    public abstract static void test3();//error
    public abstract void test1();
}
class Child extends T1{
    @Override
    public void test1() {
        System.out.println(1);
    }
}