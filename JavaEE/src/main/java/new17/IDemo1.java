package new17;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/4  14:44
 */
public interface IDemo1 {
    void test1();
    default void sayHello(){
        System.out.println("sayHello");
        sayBoot();
    }

    // 私有方法
    private void sayBoot(){
        System.out.println("Boot");
    }

}
