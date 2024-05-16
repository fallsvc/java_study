package Test2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  21:03
 */
public class Triangle extends Shape{
    private Coordinate c3;

    public Triangle() {
    }

    public Triangle(Coordinate c1, Coordinate c2, Coordinate c3) {
        super(c1, c2);
        this.c3 = c3;
    }

    public Coordinate getC3() {
        return c3;
    }

    public void setC3(Coordinate c3) {
        this.c3 = c3;
    }
    public double S(){
        return c1.x+c1.y+c2.x+c2.y+c3.x+c3.y;
    }

}
