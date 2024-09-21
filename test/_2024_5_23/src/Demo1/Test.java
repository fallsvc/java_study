package Demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  18:27
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student=new Student("zs",20);
        student.card.ID=123;
        Student s=(Student) student.clone();
        s.card.ID=122;
        System.out.println(s.card.ID);
        System.out.println(student.card.ID);
    }
    public static void main3(String[] args) {
        Student student1=new Student("zs",16);
        Student student2=new Student("ls",20);
        Student student3=new Student("ws",18);
        Student[] students={student1,student2,student3};

        NameDecComparator nameDecComparator=new NameDecComparator();

        Arrays.sort(students,nameDecComparator);

        for (Student x :
                students) {
            System.out.println(x);
        }
    }
    public static void mySort(Comparable[] comparables){
        for (int i = 0; i < comparables.length - 1; i++) {
            for (int j = 0; j < comparables.length - 1 - i; j++) {
                if(comparables[j].compareTo(comparables[j+1])>0){
                    Comparable tmp=comparables[j];
                    comparables[j]=comparables[j+1];
                    comparables[j+1]=tmp;
                }
            }
        }
    }
    public static void main1(String[] args) {
        Student student1=new Student("zs",16);
        Student student2=new Student("ls",20);
        Student student3=new Student("ws",18);
        Student[] students={student1,student2,student3};

//        mySort(students);
//        System.out.println(student1.compareTo(student2));
        Arrays.sort(students);
        for (Student x :
                students) {
            System.out.println(x.toString());
        }
    }
}
