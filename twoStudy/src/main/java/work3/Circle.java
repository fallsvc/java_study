package work3;

public class Circle {
    private double radius;
    private static int count=0;

    public Circle(){
        this.radius=1.0;
        count++;
    }
    public Circle(double radius){
        this.radius=radius;
        count++;
    }

    /**
     * 面积
     * @return
     */
    public double area(){
        return Math.PI*radius*radius;
    }
    public static int getCount() {
        return count;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}