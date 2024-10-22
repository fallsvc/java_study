package thread.threadpool;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/20  11:21
 */
class Point {
    private int x=0;
    private int y=0;
//    public Point(double x,double y){
//
//    }
}

/**
 * 工厂类  用静态方法初始化属性
 */
class PointFactory{
    /**
     *
     * @param x r
     * @param y a
     * @return
     */
    public static Point makePointByXY(double x,double y){
        Point p=new Point();
        // 设置xy属性
        return p;
    }
    public static Point makePointByRA(double r,double a){
        Point p=new Point();
        // 设置RA属性
        return p;
    }
}