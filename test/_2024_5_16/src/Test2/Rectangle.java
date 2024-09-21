package Test2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  21:10
 */
public class Rectangle extends Shape{
    private Coordinate c3;
    private Coordinate c4;
    public Rectangle(){

    }

    public Rectangle(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4) {
        super(c1, c2);
        this.c3 = c3;
        this.c4 = c4;
    }

    public Coordinate getC3() {
        return c3;
    }

    public void setC3(Coordinate c3) {
        this.c3 = c3;
    }

    public Coordinate getC4() {
        return c4;
    }

    public void setC4(Coordinate c4) {
        this.c4 = c4;
    }

    public double S(){
        return c1.x+c1.y+c2.x+c2.y+c3.x+c3.y+c4.x+c4.y;
    }
}
