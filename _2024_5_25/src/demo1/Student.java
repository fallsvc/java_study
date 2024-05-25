package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/25  15:35
 */
public class Student extends Person{
    public String ID;
    static {
        System.out.println("子类静态代码块。。");
    }

    {
        System.out.println("子类实例代码块。。");
    }

    public Student() {
        System.out.println(getAge());
        System.out.println("子类构造代码块。。");
    }
}
