package practice4;

public class Triangle {
  private double a, b, c; // 三边
  public Triangle() {
    this.a=1.0;
    this.b=1.0;
    this.c=1.0;
  }
  public Triangle(double a, double b, double c) {
    checkSides(a, b, c);
    this.a=a;
    this.b=b;
    this.c=c;
  }
  public static boolean checkSides(double a, double b, double c){
    if(a<=0||b<=0||c<=0){
      throw new TriangleSideException("存在边长小于零");
    }
    if(a+b<=c||a+c<=b||b+c<=a){
      throw new TriangleSideException("两边之和小于等于第三边");
    }
    return true;
  }
  public static Triangle[] fromArray(double[][] a) {
    //
    Triangle[] tri=new Triangle[a.length];
    for (int i = 0; i < a.length; i++) {
      try {
        tri[i]=new Triangle(a[i][0],a[i][1],a[i][2]);
      } catch (TriangleSideException e) {
        System.out.println(e.getMessage());
      }
    }
    return tri;
  }
  public double perimeter() {
    return a+b+c;
  }
  // Getter和Setter方法

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }

  public double getC() {
    return c;
  }

  public void setC(double c) {
    this.c = c;
  }
}