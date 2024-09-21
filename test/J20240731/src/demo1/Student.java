package demo1;

import java.util.Objects;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/31  8:55
 *
 *
 */
abstract class Person implements Comparable<Person>,Cloneable{
    protected int age;
    protected String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

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

    protected void eat(){
        System.out.println("person Eat.......");
    }
    protected void work(){
        System.out.println("do person works....");
    }
    protected abstract void doWeak();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Person o) {
        if(this.age==o.age){
            return this.name.compareTo(o.name);
        }
        return this.age-o.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Student extends Person{
    public int id;
    public String teacherName;

    public Student() {
        super();
    }

    public Student(int age,String name,int id, String teacherName) {
        super(age,name);
        this.id = id;
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void test(){
        System.out.println("Student  test()");
    }

    @Override
    protected void eat() {
        System.out.println("Student eat.......");
    }

    @Override
    protected void work() {
        System.out.println("Student work.......");
    }

    @Override
    protected void doWeak() {
        System.out.println("Student doWeak......");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Person o) {

        return super.compareTo(o);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(teacherName, student.teacherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, teacherName);
    }

    @Override
    public String toString() {
        return "Student{" +super.toString()+
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
