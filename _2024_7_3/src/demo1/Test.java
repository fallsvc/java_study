package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/3  18:39
 */

class Money implements Cloneable{
    public int m;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Money{" +
                "m=" + m +
                '}';
    }
}
class Student implements Comparable<Student>,Cloneable{
    public String name;
    public int age;
    public Money m=new Money();
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
//        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", m=" + m.toString() +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student=(Student) super.clone();
        student.m=(Money) this.m.clone();
        return student;
    }
}
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student=new Student("zs",20);
        student.m.m=10;
        Student student1=(Student)student.clone();
        student1.m.m=20;
        System.out.println(student1);
        System.out.println(student);
    }
    public static void main2(String[] args) {
        System.out.println(~1);
        System.out.println(1^1);
//        System.out.println(10>20&10/0==0);//程序抛出异常
//        System.out.println(10<20|10/0==0);//程序抛出异常
//        System.out.println(Integer.MAX_VALUE);//最大值
//        System.out.println(Integer.MIN_VALUE);//最小值
    }
    public static void mySort(Comparable[] comparables ){
        for (int i = 0; i < comparables.length-1; i++) {
            if(comparables[i].compareTo(comparables[i+1])>0){
                Comparable a=comparables[i];
                comparables[i]=comparables[i+1];
                comparables[i+1]=a;
            }
        }
    }
    public static void main1(String[] args) {
        Student[] students=new Student[3];
        students[0]=new Student("zs",20);
        students[1]=new Student("ww",15);
        students[2]=new Student("lm",18);
//        Arrays.sort(students);

//        mySort(students);
        ComparatorAge comparatorAge=new ComparatorAge();
        Arrays.sort(students,comparatorAge);
        System.out.println(Arrays.toString(students));
    }
}



















