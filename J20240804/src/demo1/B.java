package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/4  15:54
 */
public interface B {
    int age=10;//默认public static final
    void test1();//默认public abstract修饰
    //默认public abstract修饰不能在接口实现

//    //error
//    public B(){
//
//    }
//    //error
//    static{
//
//    }
    default void test2(){
        System.out.println(1);
    }
    static void test3(){

    }
}

