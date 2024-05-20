import java.util.Arrays;
import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/20  12:16
 */

class Student{
    //属性
    public String name="zz";
    public int age=20;
    {
        name="zha";
        age=10;
    }
    //行为
    public Student(){
        this("zhnags",20);
    }
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void print(Student this){
        System.out.println(this.name+this.age);
    }
    public void eat(){
        System.out.println("eat food....");
    }
}
//创建类
    class ClassName{
        public int a;//字段/属性/成员变量

        public void add(){//行为/成员方法
        }
}

class TestS{
    public static int age=10;
    public static String name;
    static{
        age=29;
        name="zg";
    }
    public static void print(){
        System.out.println("TestS    ");
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(TestS.age);
        TestS.print();
    }
    public static void main4(String[] args) {
        java.util.Date date = new java.util.Date();
    }
    public static void main2(String[] args) {
        Student student=new Student("小明",15);
        Student student2=new Student("小红",16);

        student.print();
        student2.print();
    }
    public static void main1(String[] args) {
        String[] array={" asdfgh","sdsd"};
        for (String x :
                array) {
            System.out.println(x);
        }
        System.out.println(array.toString());
        System.out.println();
    }
}
