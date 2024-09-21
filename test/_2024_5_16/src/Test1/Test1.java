package Test1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  18:55
 */
public class Test1 {

    public static void fun(A a){
        a.eat().atalk();
    }
    public static void main(String[] args) {
        A a1=new B();
//        A a3=new A();
        A a2=new C("lm",18);
        fun(a1);
        fun(a2);
        System.out.println();
        if(a1 instanceof B){
            a1=(B)a1;
            ((B) a1).btalk();
        }
        String a="as";
        int[] ab={1,2,3};

    }


}
