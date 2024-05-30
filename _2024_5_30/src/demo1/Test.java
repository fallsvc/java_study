package demo1;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/30  14:27
 */
public class Test {

    public static void main(String[] args) throws NameException,CloneNotSupportedException{
        Student student=new Student();
//        student.name="asdf";
//        student.checkName("asd");
        Student student1=(Student) student.clone();

    }
    public static void fun(int a) throws CloneNotSupportedException{

        if(a==0){
            throw new CloneNotSupportedException();
        }

    }
    public static void main3(String[] args) throws CloneNotSupportedException {
        Student s1=new Student();
        Student s2= (Student) s1.clone();
        try(Scanner scanner=new Scanner(System.in)){
            fun(0);
            System.out.println("jjj");
        }catch (CloneNotSupportedException cloneNotSupportedException){
        System.out.println("catch");
        }finally{
        }

        assert 10>20;
        System.out.println("正常结束");
    }
    public static void main2(String[] args) {
        //常量串构造
        String s1="asdfg";
        //new String
        String s2=new String("Asdfg");

        String s3="asdfggggh";
        System.out.println(s1.compareTo(s2));//32
        System.out.println(s1.compareTo(s3));//-4
        System.out.println(s1.compareToIgnoreCase(s2));//0

        if(s1.equalsIgnoreCase(s2)){
            System.out.println("s1==s2");
        }


        //字符串数组构造
        byte[] arr={'a','b','d','c'};
//        String s3=new String(arr);

        System.out.println("asdfg".length());//5
    }
    //单词数
    public static int numberC(String string){
        int count=0;
        String[] rets=string.split(" ");
        for (String x :
                rets) {
            if (x.length() != 0) {
                count++;
                }
            }
        return count;
    }
    //实现toLowerCase()
    public static String myToLowerCase(String string){
        StringBuilder stringBuilder=new StringBuilder("");
        for (int i = 0; i < string.length(); i++) {
            char ch=string.charAt(i);
            //判断是不是字母
            if(Character.isLetter(ch)){
                //判断是不是大写
                if(Character.isUpperCase(ch)){
                    ch+=32;//ch=(char)(ch+32);
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main1(String[] args) {
        String string=", , , ,     a  ds";
        System.out.println(myToLowerCase(string));
        System.out.println(numberC(string));
    }
}
