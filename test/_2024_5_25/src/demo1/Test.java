package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/25  15:35
 */
public class Test {
    public static B fun(A a){

        return a;
    }
    public static void main(String[] args) {
        A a=new A();
        B b=a;

        if(b instanceof A){
            System.out.println("b 是由a向上转型的 ");
        }
    }
}

