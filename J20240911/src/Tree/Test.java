package Tree;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/11  10:58
 */
public class Test {
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
    public static void main(String[] args) {
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
}
