package Demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  9:58
 */
class MyValue{
    public int value;

}
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException{
        Student student=new Student("zs",20);
        Student student2=(Student) student.clone();
        System.out.println(student2.age);
    }
    public static void swap(MyValue value1,MyValue value2){
        int tmp=value1.value;
        value1.value=value2.value;
        value2.value=tmp;
    }

    public static void main2(String[] args) {
        MyValue value1=new MyValue();
        MyValue value2=new MyValue();
        value1.value=10;
        value2.value=20;
        System.out.println(value1.value+"dfd"+ value2.value);

        swap(value1,value2);
        System.out.println(value1.value+"dfd"+ value2.value);
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
        Student student1=new Student("zs",10);
        Student student2=new Student("ls",20);
        Student[] stus=new Student[3];
        stus[0]=student1;
        stus[1]=student2;
        stus[2]=new Student("ww",15);
        System.out.println(Arrays.toString(stus));
        //Arrays.sort(stus);
//        mySort(stus);
        //比较器
        StudentDescComparator studentDescComparator=new StudentDescComparator();
        Arrays.sort(stus,studentDescComparator);
        System.out.println(Arrays.toString(stus));

//        System.out.println(student1.compareTo(student2));
    }
}
