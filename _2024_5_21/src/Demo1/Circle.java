package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  17:48
 */
public class Circle extends Shape{

    public double r;

    public Circle() {
    }

    public Circle(Dot dot1, double r) {
        super(dot1);
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("⚪  ......");
    }

    @Override
    public void printName() {
        System.out.println("circle");
    }

}
