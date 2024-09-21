package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/5  16:27
 */
class Money implements Cloneable{
    public double price=9.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Student implements Cloneable{
    public int age;
    public String name;
    public Money money=new Money();

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //拷贝一个Student对象
        Student student=(Student)super.clone();
        //拷贝一个Money对象
        student.money=(Money)student.money.clone();
        //返回该拷贝
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name=" + name + " price="+money.price+
                '}';
    }
}
