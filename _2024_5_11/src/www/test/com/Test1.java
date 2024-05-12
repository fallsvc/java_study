package www.test.com;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/11  20:32
 */
public class Test1 {
    public static void main(String[] args) {
        TestDemo t=new TestDemo(10,"zhangsan");
        System.out.println(t.age);
        t.setAge(20);
        System.out.println(t.age);
        t.showName();
    }
}
