package practice2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/16  9:30
 */
public class Demo3 {
    static class A11 {
        public void test() {
            System.out.println("A11 test");
        }
    }
    class A22{
        public void test(){
            System.out.println("A22 test");
        }
    }
    public void test(){
        class A33{
            public void test2(){
                System.out.println("A33 test2");
            }
        }
        A33 a33=new A33();
        a33.test2();
    }

}
