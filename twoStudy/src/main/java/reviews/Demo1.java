package reviews;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/12/27  14:19
 */
public class Demo1 {
    {
        System.out.println("实例");
    }
    static {
        System.out.println("静态实例！！");
    }
    Demo1(){
        System.out.println("构造器");
    }
    public static void main1(String[] args) throws Exception {
//        Demo1 demo1=new Demo1();
//        throw new Exception();
//        Object

        Integer integer=Integer.valueOf("1");
        System.out.println(integer);
        Integer[][] a= new Integer[2][2];
        a[0][0] = 20;
        System.out.println(a.getClass().getTypeName()); // 类型为java.lang.Integer[][]
        System.out.println(a[0].getClass().getTypeName()); //类型为java.lang.Integer[]
        System.out.println(a[0][0].getClass().getTypeName()); // 类型为java.lang.Integer
    }

    public static void m2ain(String[] args) {
//        String s1 = new String("Hello");
//        String s2 = "Java";
//        System.out.println(s1 + " "+ s2); // Hello Java
//        System.out.println(s1.concat(" ".concat(s2))); // Hello Java
//        System.out.println(Math.random());
//
//        Random random=new Random();
//        System.out.println(random.nextInt(1,2));
//        int a=1/0;

        String s1="1ww";
        String s2="1wqwdfsd";
        Integer integer=1;
        Integer integer1=10;
        int i=integer;
        System.out.println(s1.compareTo(s2));
        System.out.println(integer.compareTo(integer1));


    }

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        Stack<String> strings=new Stack<>();

        Map<Integer,String> map=new HashMap<>();
        map.
    }
}
