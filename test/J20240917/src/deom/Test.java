package deom;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/17  17:36
 */
public class Test {
    public static void main(String[] args) {
        char[] ch={'a','h','l'};
        String s=new String(ch);//数组创建字符串时，字符串不会在常量池中创建对象
        s.intern();//手动入池

        String s2="ahl";

        System.out.println(s==s2);
    }
    public static void main1(String[] args) {
        String a="asd";
        String b="asd";
        System.out.println(a==b);
    }
}
