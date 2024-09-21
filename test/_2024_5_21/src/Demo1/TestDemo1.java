package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  18:28
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Shape[] shapes={new Circle(),new Rect(),new Shape()};
        shapes[0].draw();
        for (Shape x :
                shapes) {
            x.draw();
        }
    }
}
