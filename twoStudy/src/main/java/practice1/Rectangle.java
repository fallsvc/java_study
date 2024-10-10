package practice1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/9  9:00
 */
public class Rectangle {
    // 矩形的宽和长
    private double width;
    private double height;

    // 重心坐标
    private double centerX;
    private double centerY;

    private double angle; // 矩形相对于x轴角度
    // 矩形顶点
    public static final int VERTEX0=0;
    public static final int VERTEX1=1;
    public static final int VERTEX2=2;
    public static final int VERTEX3=3;

    public Rectangle( double centerX, double centerY,double width, double height) {
        this.width = width;
        this.height = height;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * 矩形在坐标轴的移动
     * @param dx
     * @param dy
     */
    public void move(double dx,double dy){

        this.centerX+=dx;
        this.centerY+=dy;
    }

    /**
     * 移动矩形的重心到 （x,y）
     * @param x
     * @param y
     */
    public void moveTo(double x,double y){
        this.centerX=x;
        this.centerY=y;
    }
    /**
     * 旋转角度
     * * @param angle
     */
    public void rotate(double angle){
        this.angle+=angle;
        angle%=360.0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", centerX=" + centerX +
                ", centerY=" + centerY +
                ", angle=" + angle +
                '}';
    }
}
