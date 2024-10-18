package thread.singleton;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/18  23:58
 */

/**
 * 饿汉方式
 */
class Singleton{
    private static Singleton singleton=new Singleton();

    // 获得实例
    public static Singleton getSingleton(){
        return singleton;
    }

    /**
     * 构造器私有化
     */
    private Singleton(){

    }
}
public class Demo1 {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getSingleton();
        Singleton singleton2=Singleton.getSingleton();

        System.out.println(singleton1==singleton2);

    }
}
