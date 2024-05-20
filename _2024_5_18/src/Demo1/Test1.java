package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  12:57
 */
public class Test1 {
    public static void fun(A a){
        a.A();
    }
    public static void main(String[] args) {
        Dog dog=new Dog(10,"as");
        fun(dog);
        fun(new IA(20,"zs"));//匿名对象
        A a=(A)dog;
        if(dog instanceof Animal){
            System.out.println("heh");
        }
    }
}
