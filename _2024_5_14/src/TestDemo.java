/**
 * @auther falls_vc
 * description:
 * @date 2024/5/14  14:10
 */
public class TestDemo {
    private int x;
    private int y;
    public static int z;

    {
        this.x=20;
        this.y=10;
    }
    static{
        z=30;
    }

    public TestDemo() {
    }

    public TestDemo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "TestDemo{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getZ() {
        return z;
    }

    public static void setZ(int z) {
        TestDemo.z = z;
    }

    public int add(){
        return z+x+y;
    }

}
