package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/5  16:19
 */
public class Test {
    public static void main1(String[] args) {

    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1=new Student(16,"李明");
        Student student2=(Student) student1.clone();

        student1.money.price=10.0;

        System.out.println(student1);
        System.out.println(student2);
    }
}
