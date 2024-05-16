package Test2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/16  21:13
 */
public class Test2 {

    public static void main(String[] args) {
        Coordinate a=new Coordinate(1.0,1.0);
        Coordinate b=new Coordinate(2.0,2.0);
        Coordinate c=new Coordinate(3.0,3.0);
        Coordinate d=new Coordinate(4.0,4.0);

        Triangle triangle=new Triangle(a,b,c);
        Rectangle rect=new Rectangle(a,b,c,d);

        System.out.println(triangle.S());
        System.out.println(rect.S());

        triangle.setC3(d);
        System.out.println(triangle.S());

    }
}
