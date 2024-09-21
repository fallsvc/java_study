package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/11  10:58
 */
public class Test {
    public static void main2(String[] args) {


    int[] data = {4, 5, 3, 6, 2, 5, 1};
    // int[] 转 List<Integer>
    List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());
    // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
    // 1.使用Arrays.stream将int[]转换成IntStream。
    // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
    // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。

    // int[] 转 Integer[]
    Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);
    // 前两步同上，此时是Stream<Integer>。
    // 然后使用Stream的toArray，传入IntFunction<A[]> generator。
    // 这样就可以返回Integer数组。
    // 不然默认是Object[]。

    // List<Integer> 转 Integer[]
    Integer[] integers2 = list1.toArray(new Integer[0]);

    //  调用toArray。传入参数T[] a。这种用法是目前推荐的。
    // List<String>转String[]也同理。

    // List<Integer> 转 int[]
    int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

    // 想要转换成int[]类型，就得先转成IntStream。
    // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
    // 而IntStream中默认toArray()转成int[]。

    // Integer[] 转 int[]
    int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();

    // 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。
    // Integer[] 转 List<Integer>
    List<Integer> list2 = Arrays.asList(integers1);

    // 最简单的方式。String[]转List<String>也同理。
    // 同理       <br>　　　　　　　　
    String[] strings1 = {"a", "b", "c"};

    // String[] 转 List<String>
    List<String> list3 = Arrays.asList(strings1);

    // List<String> 转 String[]
    String[] strings2 = list3.toArray(new String[0]);
}

    public static void main3(String[] args) {
//        String str="12";
//        System.out.println(str.charAt(2));
//        BinaryTree binaryTree=new BinaryTree();
//        binaryTree.createTree("abc##de#g##f###");
        List<Integer> list=new ArrayList<>();
        List<Integer> list2=new LinkedList<>();
        list.add(21);
        list.add(21);
        list.add(21);
//        Integer[] ret=new Integer[list.size()];
//        ret=list.toArray(ret);//toArray不分配内存
//        int[] res = new int[list.size()];
//
//        for (int i = 0; i < res.length; i++) {
//            res[i]=list.get(i);
//        }
//
//        System.out.println(Arrays.toString(res));

    }
    public static BinaryTree.Node createTree(){
        BinaryTree.Node node1=new BinaryTree.Node(3);
        BinaryTree.Node node2=new BinaryTree.Node(2);
        BinaryTree.Node node3=new BinaryTree.Node(1);
        BinaryTree.Node node4=new BinaryTree.Node(6);
        BinaryTree.Node node5=new BinaryTree.Node(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        return node1;
    }
    public static void main1(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        BinaryTree.Node node=createTree();
//
//        binaryTree.postOrder(node);
//        System.out.println(binaryTree.size(node));
//        List<Integer> list=binaryTree.preorderTraversal(node);
//        System.out.println(list.toString());
//        System.out.println(binaryTree.getLeafNodeCount(node));
//        System.out.println(binaryTree.getKLevelNodeCount(node, 3));

        System.out.println(binaryTree.getHeight(node));
    }

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        BinaryTree.Node node=createTree();

        binaryTree.lowestCommonAncestor1(node,node.left,node.right);
        binaryTree.inOrderNor(node);
    }
}
