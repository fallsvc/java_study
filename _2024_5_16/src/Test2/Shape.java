package Test2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  20:58
 */

public class Shape {
    public Coordinate c1;
    public Coordinate c2;

    public Shape() {

    }

    public Shape(Coordinate c1, Coordinate c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Coordinate getC1() {
        return c1;
    }

    public void setC1(Coordinate c1) {
        this.c1 = c1;
    }

    public Coordinate getC2() {
        return c2;
    }

    public void setC2(Coordinate c2) {
        this.c2 = c2;
    }
}
