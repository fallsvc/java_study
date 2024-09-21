package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  18:23
 */
public class Rect extends Shape{
    public Dot[] dots=new Dot[4];

    public Rect() {
    }

    public Rect(Dot[] dots) {
        super(dots[0]);
        this.dots=dots;
    }

    @Override
    public void draw() {
        System.out.println("长方形。。。。");
    }

    @Override
    public void printName() {
        System.out.println("Rect.........");
    }

}
