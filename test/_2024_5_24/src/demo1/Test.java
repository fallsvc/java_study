package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  16:41
 */
class A{
    public int x=20;
    public void methodB(){
        System.out.println("methodB ...A");
    }
}
public class Test extends A{
    public int x=30;
    public void printX(){
        x=40;//默认this.访问子类的x
        super.x=40;//访问父类x
    }
    @Override
    public void methodB() {
        System.out.println("methodB....Teat");
    }

    public void useM(){
        methodB();//子类的方法
        super.methodB();//父类方法
    }
}
