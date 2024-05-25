package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/25  15:35
 */
public class Person {
    public String name;
    private int age=20;
    static {
        System.out.println("父类静态代码块。。");
    }

    {
        System.out.println("父类实例代码块。。");
    }

    public Person() {
        System.out.println("父类构造代码块。。");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

