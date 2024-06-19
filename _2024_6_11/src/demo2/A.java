package demo2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/11  21:51
 */
class B{
    public void fun(){
        System.out.println("fun..");
    }
}
public class A extends B {
    public void fun(int a){
        System.out.println("fun...a");
    }

    public static void main(String[] args) {
        A a=new A();
        a.fun();
    }
}
