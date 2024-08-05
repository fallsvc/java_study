package demo2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/4  21:25
 */

public class Cat implements Comparable<Cat>{ //Cat比较属于类
    public int age;
    public String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //重写compareTo方法
    @Override
    public int compareTo(Cat o) {
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
