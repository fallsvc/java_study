/**
 * @auther falls_vc
 * description:
 * @date 2024/5/13  18:27
 */
public class TestDemo {
    public int x;
    private int y=10;

    public static int m_z;

    public static void setZ(int z){
        m_z=z;
    }
    static{
        m_z=20;
    }

    {
        this.x=2000;
        y=10;
    }

    @Override
    public String toString() {
        return "TestDemo{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public TestDemo() {
    }
    public TestDemo(int x, int y){
        this.x=x;
        this.y=y;
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
}
