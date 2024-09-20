package reflect1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/18  12:18
 */
public class Student {
    public int age;
    private String name;

    public Student(){

    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
