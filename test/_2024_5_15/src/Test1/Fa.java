package Test1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/15  10:37
 */
public class Fa {
    public String name;
    public int age;

    static{
        System.out.println("static fa");
    }
    {
        System.out.println("sl   fa");
    }
    public Fa() {
    }

    public Fa(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("fa  gz....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Fa{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
