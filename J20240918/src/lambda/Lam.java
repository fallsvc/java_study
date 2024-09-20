package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/19  15:42
 *
 */
//函数试接口
@FunctionalInterface
interface AI{
//    void test1();
//    int test2();

    int test3(int x,int y);
}
class B<T>{

}

public class Lam {
    public static void main(String[] args) {

    }
    public static void f1(B<?> b ){

    }
    public static void main5(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("afd",2);
        map.put("gfd",5);
        map.put("qagd",3);
        map.put("yd",6);

//        map.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String s, Integer integer) {
//                System.out.println("Key:"+s+"  val:"+integer);
//            }
//        });

        map.forEach((a,b)-> System.out.println("Key:"+a+"  val:"+b));
    }
    public static void main4(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
//        arrayList.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
//        arrayList.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });

        arrayList.sort((o1,o2)->o2.compareTo(o1));

        arrayList.forEach((a)-> System.out.println(a));

    }
    public static void main2(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        PriorityQueue<Integer> p2=new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));//等于上面这一行代码


    }
    public static void main1(String[] args) {
//        AI a=()->{System.out.println("helll");};
//        a.test1();

//        AI a=()->{return 1000;};
//        System.out.println(a.test2());

        AI  a=(x,y)->x*y;
        System.out.println(a.test3(10, 20));
    }
}
