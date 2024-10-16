package practice2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/16  8:49
 */
public class Demo1 {
    public static void main(String[] args) {
        int x = 10, y = 10;
        add(10.0, y); // 选择add(double x, int y)
        add(x, 10.0); // 选择add(int x, double y)
//        add(x, y); // 错误：匹配不明确
    }
    public static double add(double x, int y) {
        return x + y;
    }
    public static double add(int x, double y) {
        return x + y;
    }
}
