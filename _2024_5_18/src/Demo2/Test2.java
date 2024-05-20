package Demo2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  12:04
 */

interface  AI{
    public void st();
}
public class Test2 {

    public static void mai3(String[] args) {
//        Outter.fun3();


        Outter out=new Outter();
        Outter.In in=out.new In();
        in.funn();
    }
    //内部类
    public static void main(String[] args) {
        AI ai=new AI(){
            @Override
            public void st() {
                System.out.println("fddfff");
            }
        };
        ai.st();

        new Out().fun();//
//        Out oug=new Out(){
//            @Override
//            public void fun() {
//                System.out.println("hehe");
//            }
//        }.fun();//error
//        oug.fun();


    }
    //静态内部类
    public static void main1(String[] args) {
//        Outter out=new Outter();
        Outter.Inner inner=new Outter.Inner();

        inner.fun1();
    }
}
