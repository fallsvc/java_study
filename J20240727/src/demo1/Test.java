package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/27  17:12
 */
public class Test {
    public static void main(String[] args) {
        Integer[] array={9,7,null,2,3,null,null};
        Tree<Integer> tree=new Tree<>();
//        Tree.TreeNode<Integer> h=tree.getHead();
        tree.add(10);
        tree.add(1);
        tree.add(20);
        tree.add(13);
        tree.add(21);
        tree.play(tree.head);
    }
}
