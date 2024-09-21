package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/1  13:04
 */
public class Fx<T extends Number>{
    private Object[] objects=new Object[10];

    public void setObjects(int pos,T b){
        objects[pos]=b;
    }
    public T getObjects(int pos){
        return (T)objects[pos];
    }

    public static void main(String[] args) {
        Fx<Integer> fx=new Fx<>();
        fx.setObjects(0,20);
        System.out.println(fx.getObjects(0));
    }
}
