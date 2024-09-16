package BST;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/16  20:05
 */
public class Test {
    public static void main(String[] args) {
//        final int[] array={12,4,5};
//        array[0]=1;
//        System.out.println(array[0]);
        Set<Integer> set=new HashSet<>();

        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);
        set.add(1);
        for (Integer x:
        set) {
            System.out.println(x);
        }


    }
    public static void main2(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        //哈希map可以插入null key 但是只能存在一个null 值列
        //而treeMap key值必须是能比较的类必须实现comparable接口重写compareTo()方法
//        map.put(null,1);
        map.put(null,2);
        map.put("asd",3);
        map.put("ew",4);
        Set<Map.Entry<String,Integer>> set=map.entrySet();
        for (Map.Entry<String, Integer> entry :
                set) {
            System.out.println("key="+entry.getKey()+"value="+entry.getValue());
        }
        System.out.println("==============");
        Iterator<Map.Entry<String,Integer>> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        BinarySearchTree.TreeNode s=binarySearchTree.search(3);
        System.out.println(s.val);
        binarySearchTree.remove(6);

//        s=binarySearchTree.search(6);
        System.out.println(s.val);

    }
}
