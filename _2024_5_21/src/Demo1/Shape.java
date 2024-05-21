package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  17:45
 */

class Dot{
    public double x;
    public double y;
}
public class Shape {
    public Dot dot1;

    public Shape() {
    }

    public Shape(Dot dot1) {
        this.dot1 = dot1;
    }

    public void draw(){
        System.out.println("shape.......");
    }

    public void printName(){
        System.out.println("shape....");
    }
}
