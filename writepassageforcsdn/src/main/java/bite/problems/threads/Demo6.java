package bite.problems.threads;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/20  16:51
 */
// 恶汉模式
class Singleton{
    private static Singleton singleton=new Singleton();

    public static Singleton getSingleton(){
        return singleton;
    }
    private Singleton(){

    }
}

// 懒汉模式
class SingletonLazy{
    // volatile 解决内存可见性问题和指令集重排序问题
    private static volatile SingletonLazy singletonLazy=null;

    public static SingletonLazy getSingletonLazy(){
        if(singletonLazy==null){// 解决多次加锁问题
            synchronized(SingletonLazy.class){// 解决多线程创建多个实例问题
                if(singletonLazy==null){
                    singletonLazy=new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }

    private SingletonLazy(){

    }
}
public class Demo6 {
    public static void main(String[] args) {

    }
}
