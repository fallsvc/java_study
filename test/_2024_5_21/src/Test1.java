/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  11:54
 */
public class Test1 {
    public static int data1;
    public int data2;

    //静态内部类
    static class Inner{
        public int data2;

        //只能访问外部类的静态成员
        public void show(){
            System.out.println(data1);
//            System.out.println(Test1.this.data1);//报错
        }
    }

    public static void main(String[] args) {
        //静态内部类的实例化和成员访问（不需要创建外部类对象）
        Test1.Inner inner=new Test1.Inner();
        inner.show();
    }
}
