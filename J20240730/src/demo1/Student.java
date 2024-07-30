package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/30  15:47
 */
class Id implements Cloneable{
    public int id=10;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Id{" +
                "id=" + id +
                '}';
    }
}
public class Student implements Cloneable{
    public int age=20;
    public Id id=new Id();

    public Student(){

    }

    //深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student=(Student) super.clone();
        student.id=(Id)this.id.clone();

        return student;
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                '}';
    }
}
