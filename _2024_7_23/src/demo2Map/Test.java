package demo2Map;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/23  16:39
 */
public class Test {
    public static void main(String[] args) {
        int[] array={1,2,32,1,32,2};
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        System.out.println(hashSet);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if(!hashSet.contains(array[i])){
                hashSet.add(array[i]);
            }else {
                System.out.println(array[i]);
                return;
            }
        }

    }
    public static void main2(String[] args) {
        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("asd");
        treeSet.add("fds");
        treeSet.add("qwe");
        Iterator<String> t=treeSet.iterator();
        while(t.hasNext()){
            System.out.println(t.next());
        }
//        Object[] strings=(treeSet.toArray());
        String[] strings=(String[])(treeSet.toArray(new String[0]));
        System.out.println(Arrays.toString(strings));
    }
    public static void main1(String[] args) {
        TreeMap<String,Integer> treeMap=new TreeMap<>();
        treeMap.put("hh",4);
        treeMap.put("yyf ",3);
        treeMap.put("iils",2);
//        treeMap.remove("yyf");

//        int val=treeMap.get("yyf");
//        Set<String> set=treeMap.keySet();
//        for (String s :
//                set) {
//            System.out.println(s);
//        }

        Set<Map.Entry<String,Integer>> entrySet=treeMap.entrySet();

        for (Map.Entry<String, Integer> x :
                entrySet) {
            System.out.println("k:"+x.getKey()+"     value:"+x.getValue());
        }
        int val=treeMap.getOrDefault("yyf",-1);

        System.out.println(val);
    }
}
