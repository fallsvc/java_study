/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  15:47
 */
public class Test {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Test test=new Test();
        test.setAge(20);
        test.setName("xiaoming");

        System.out.println(test.getAge());
        System.out.println(test.getName());
    }
}
