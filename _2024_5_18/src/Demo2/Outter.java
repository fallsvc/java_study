package Demo2;

import org.w3c.dom.ls.LSOutput;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  12:04
 */
//匿名类
class Out{
    public void fun(){
        System.out.println("Out //.fun()");
    }
}
//内部类
public class Outter{
    public int data1;
    private int data2;

    //实例内部类
    public class In{
       public int data3;
        public void funn(){
            System.out.println(Outter.this.data2);//两个this
            System.out.println(data3);
        }
    }
    //静态内部类
    static class Inner{
        public static int data3;
        public int data4;

        public static void fun1(){
            System.out.println("fun1");
        };
    }

    public static void fun2(){
        System.out.println("fun2......");
    }
    //局部内部类
    public static void fun3(){
        class Fun{
            public int data5;
            public void fun(){
                System.out.println("jubuneibulei     ");
            }
        }
        Fun f=new Fun();
        f.fun();
        int a=20;
    }

}
