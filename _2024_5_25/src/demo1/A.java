package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/25  15:55
 */
class B{
    public void print(){
        System.out.println("B...print");
    }
}

public class A extends B{
    @Override//重写父类B的print方法
    public void print() {
        System.out.println("A...print");
    }
    //重载add方法
    public int add(int x,int y){
        return x+y;
    }
    public double add(double x,double y){
        return x+y;
    }

}
