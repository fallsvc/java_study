package new17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/4  14:17
 */
public class Demo1 {
    public static void main(String[] args) {
        String r1="aaa";
        // instanceof 判断一个对象是不是一个类或者该类的子类
        if(r1 instanceof String){
            System.out.println("是String类型");
        }

    }
    public static void main2(String[] args) {
        IDemo1 iDemo1=new IDemo1() {
            @Override
            public void test1() {
                System.out.println("hello test!");
            }
        };
        iDemo1.sayHello();
        iDemo1.test1();
    }
    public static void main1(String[] args) {
        String data="one";

        int ret1=0;
       switch(data){
           case "one":
               ret1= 1;
               break;
           case "two":
               ret1=2;
               break;
           default:
               ret1=0;
               break;
        };

       // 返回值类型
        int ret2=switch(data){
            case "one"->1;
            case "two"->2;
            default -> 0;
        };
        // yield 返回   jdk13
        int ret3=switch(data){
            case "one":yield 1;
            case "two":yield 2;
            default : yield 0;
        };

        // var  java10
        Map<String, List<Map<Integer,String>>> map1=new HashMap<String, List<Map<Integer, String>>>();

        var map2=new HashMap<String,List<Map<Integer,String>>>();
        //简化代码，但是不适用，最好不要使用var
        // 不能声明不能当方法参数，不能当方法返回值。必须初始化且不能为null
    }
}
