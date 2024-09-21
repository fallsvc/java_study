package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/31  8:50
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1=new Student(18,"zs",11,"wang");
        Student student2=new Student(11,"zs",11,"wang");
//        System.out.println(student1.equals(student2));
//        System.out.println(student1.hashCode());
//        System.out.println(student2.hashCode());
//        System.out.println(student2);
        Student student=(Student) student1.clone();
        System.out.println(student);
    }
}
