package practice2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/16  8:50
 */
class Geometry{

}
class Circle extends Geometry{

}
public class Demo2 {
    public static void main(String[] args) {
        Geometry geometry=new Circle();
        if (geometry instanceof Circle){
            Circle c=(Circle) geometry;


        }else{

        }
    }
}
