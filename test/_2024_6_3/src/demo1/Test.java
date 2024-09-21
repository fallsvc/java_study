package demo1;

import java.util.ArrayList;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/3  18:38
 */
class Student {

    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "name="+name+",age="+age;
    }
}
public class Test {

    public static void main(String[] args) {
        Student student1=new Student("zs",22);
        Student student2=new Student("za",20);
        Student student3=new Student("as",10);

        ArrayList<Student> s=new ArrayList<>();
        s.add(student1);
        s.add(student2);
        s.add(student3);
        System.out.println(s);


    }
    public static void main4(String[] args) {
        String data = "one" ;
        int result = switch (data)
                {
//                    case "one"->1;
//                    case "two"->2;
//                    default->-1;
                    case "one":yield 1;
                    case "two":yield 2;
                    default:yield -1;
                };
        System.out.println(result);
    }
    public static void main3(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        Integer E=new Integer(128);
        Integer F=new Integer(128);

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(E==F);
    }
    public static void main1(String[] args) {
        DataInt<Integer> s=new DataInt<>();
        s.t=10;
        System.out.println(s.t);
    }
}
