package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/4  14:32
 */

abstract class a{
    public abstract void test3();
}
//abstract 修饰类是抽象类只能被继承
//抽象类比普通类： 可以有抽象方法
public abstract class Test extends a{
    public int data1;
    //abstract修饰的方法为抽象方法，继承类必须重写
    //如果继承类不具体实现，该继承类也为抽象类
    public abstract void test1();
    //也可以有普通方法和属性
    public void test2(){
        System.out.println(1);
    };

    public static void main(String[] args) {
//        Test test=new Test();//error  Test是抽象类
    }
}
