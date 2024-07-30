package InnerClass;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/30  20:29
 */
public class Outer {
    private int data1=1;
    private static int data2=2;
    //静态
    static class Inner{
        public int data3=3;
        public void test(){
            System.out.println(data2);
        }
    }
    //实例
    class Inner2{
        public int data3=3;
        public void test(){
            System.out.println(data1);
            System.out.println(data2);
        }
    }
}
