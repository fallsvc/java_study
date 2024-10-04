package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/2  21:02
 */
public class Demo1 {
    public static void main(String[] args) {
        LRUCache1<String,Integer> map=new LRUCache1<>(18);
        map.put("zs",2);
        map.put("lx",2);
        map.put("wa",2);
        map.put("flle",2);

        map.get("wa");

        System.out.println(map);

    }
    public static void main2(String[] args) {
        // accessOrder
//        Map<String,Integer> map=new LinkedHashMap<>();//默认插入顺序
        Map<String,Integer> map=new LinkedHashMap<>(1,0.7f,true);//访问顺序

        map.put("zs",2);
        map.put("lx",2);
        map.put("wa",2);
        map.put("flle",2);

        map.get("wa");

        System.out.println(map);
    }
    public static void main1(String[] args) {
//        Map<String,Integer> map=new LinkedHashMap<>();//默认插入顺序
        Map<String,Integer> map=new LinkedHashMap<>(16,0.7f,false);

        map.put("zs",2);
        map.put("lx",2);
        map.put("wa",2);
        map.put("flle",2);

        map.get("wa");

        System.out.println(map);
    }
}
