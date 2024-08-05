package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/4  15:34
 */

//interface替换class
public interface ILink {
    public final int age=10;
    int age2=10;
    //抽象方法
    public abstract void test1();
    public void test2();
    abstract void test3();
    void test4();//推荐写法

    //上面全是抽象方法的形式默认public abstract修饰
}
