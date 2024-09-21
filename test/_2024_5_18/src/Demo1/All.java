package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  11:28
 */
//接口
    //成员变量都是 public static final
    //成员方法都是 public abstract  (不写默认)

interface A{

    default void test1(){
        System.out.println("A interface default");
    }
    public static void test2(){
        System.out.println();
    }
    public static final int x=10;
    public abstract void A();
}

interface B{

    public abstract void B();
}
public abstract interface All extends A,B{

        public abstract void C();

}
