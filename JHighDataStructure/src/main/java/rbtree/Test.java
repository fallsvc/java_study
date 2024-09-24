package rbtree;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/21  21:25
 */
public class Test {
    public static void main(String[] args) {
        RBTree rbTree=new RBTree();
        rbTree.insert(3);
        rbTree.insert(2);
        rbTree.insert(4);
        rbTree.insert(1);
        rbTree.insert(6);
        rbTree.insert(7);
        rbTree.insert(69);
        rbTree.insert(9);

        rbTree.inOrder(rbTree.root);
    }
}
