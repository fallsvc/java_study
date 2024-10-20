package thread.singleton;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/19  9:35
 */

/**
 * 懒汉模型
 */
class SingletonLazy{
    // volatile 避免内存可见性和指令重排序
    private static volatile SingletonLazy instance=null;
    private static Object locker=new Object();
    public static SingletonLazy getInstance() {
        if (instance==null) { // 解决多次加锁效率问题
            synchronized (locker) { // 解决线程安全返回两个不同实例
                if(instance==null){
                    instance=new SingletonLazy();
                }
            }
        }
        return instance;
    }

    /**
     * 锁对象为 SingletonLazy.class
     * @return
     */
    public synchronized static SingletonLazy getInstance2() {
        if(instance==null){
            instance=new SingletonLazy();
        }
        return instance;
    }
    private SingletonLazy(){

    }
}
public class Demo2 {
    public static void main(String[] args) {
        SingletonLazy singletonLazy1=SingletonLazy.getInstance();
        SingletonLazy singletonLazy2=SingletonLazy.getInstance();

        System.out.println(singletonLazy1==singletonLazy2);
    }
}
