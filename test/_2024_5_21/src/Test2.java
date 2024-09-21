/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  12:08
 */
public class Test2 {
    public static int data1;
    public int data2;
    //{}中
    {
        class Inner1{
            public int data3;
            //...
        }
        Inner1 inner1=new Inner1();
    }
    //方法中
    public void show(){
        class Inner2{
            public int data4;
            //...
        }
        Inner2 inner2=new Inner2();
    }
}
