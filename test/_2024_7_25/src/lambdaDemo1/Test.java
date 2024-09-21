package lambdaDemo1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/25  11:33
 */
//函数接口
    @FunctionalInterface
interface IA{
    void test();

    default void test2(){

    }
    public static void test3(){

    }

}@FunctionalInterface
interface NoParameterNoReturn{
        int test(int a);
}
public class Test {
    public static void main(String[] args) {
        NoParameterNoReturn noParameterNoReturn=new NoParameterNoReturn() {
            @Override
            public int test(int a) {
                System.out.println(a);
                return 0;
            }
        };
        noParameterNoReturn.test(10);
        NoParameterNoReturn noParameterNoReturn1=a->{
            System.out.println(a);
            return a*2;
        };
        System.out.println(noParameterNoReturn1.test(100));
    }
    public static void main2(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("abcd");
        list.add("zko");
        list.add("healoo");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("===========================");

        list.forEach(s-> System.out.println(s));

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        list.sort((o1,o2)->o1.compareTo(o2));
        list.forEach(s-> System.out.println(s));
    }
    public static void main1(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("hello",3);
        map.put("abc",2);
        map.put("def",1);
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("key:" +s+"  val:"+integer);
            }
        });

        map.forEach((s,integer)->System.out.println("key:" +s+"  val:"+integer));
    }
}
