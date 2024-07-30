package Tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/30  22:14
 */
public class TestCollections {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        Collections.reverse(list);//逆置表
//        Collections.sort(list);//排序
        Collections.rotate(list,2);//逆置个数依次逆序
        for (Integer x :
                list) {
            System.out.println(x);
        }
    }
}
