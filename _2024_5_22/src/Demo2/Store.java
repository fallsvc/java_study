package Demo2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  11:29
 */
class Food implements Cloneable{
    public double money=20.0;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Store implements Cloneable{
    public int x=10;
    public Food food=new Food();

    //深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Store tmp=(Store)super.clone();
        tmp.food=(Food)this.food.clone();
        return (Object) tmp;
    }
}
