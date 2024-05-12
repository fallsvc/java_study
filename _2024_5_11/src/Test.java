import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/11  18:57
 */

class Data {

    private int x;
    private int y;

    Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

class Student{
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        this.name=null;
        this.age=0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static int a=10;
    private String name;
    private int age;

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
}
public class Test {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Data data = new Data(x, y);
            System.out.println(data.getX() + data.getY());
        }
    }
    public static int age;
    public static void main1(String[] args) {
//        Student student=new Student("zhansan",20);
//        student.a++;
//        System.out.println(student.toString());
//        System.out.println("%");
//        ++student.a;
//        Student.a++;
//        System.out.println(Student.a);

        System.out.println(age);
//        String a;
//        System.out.println("a="+a);
    }
}

class TestDemo1{

    private int count;
    public void fun(){
        System.out.println("fgf");
    }

    public static void main(String[] args) {


        TestDemo1 test=new TestDemo1(88);

        System.out.println(test.count);

    }

    TestDemo1(int a) {

        count=a;

    }

}



































