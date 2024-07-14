package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/14  19:53
 */
public class MyTree {
    public TreeNode root;

    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode treeNode1 = new TreeNode('A');
        TreeNode treeNode2 = new TreeNode('B');
        TreeNode treeNode3 = new TreeNode('C');
        TreeNode treeNode4 = new TreeNode('D');
        root = treeNode1;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        return root;
    }

    void preOrder(TreeNode r) {
        if (r == null) {
            return;
        }
        System.out.print(r.val + " ");
        preOrder(r.left);
        preOrder(r.right);
    }

    void inOrder(TreeNode r) {
        if (r == null) {
            return;
        }
        inOrder(r.left);
        System.out.print(r.val + " ");
        inOrder(r.right);
    }

    void postOrder(TreeNode r) {
        if (r == null) {
            return;
        }
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.val + " ");
    }

    public List<Character> preorderTraversal(TreeNode r) {
        List<Character> list = new ArrayList<>();

        if (r == null) {
            return list;
        }
        list.add(r.val);
        List<Character> ret1 = preorderTraversal(r.left);
        list.addAll(ret1);
        List<Character> ret2 = preorderTraversal(r.right);
        list.addAll(ret2);

        return list;
    }

    public int size(TreeNode r) {
        if (r == null) {
            return 0;
        }

        return size(r.left) + size(r.right) + 1;
    }

    public int getLeafCountNode(TreeNode r) {
        if (r == null) {
            return 0;
        }
        if (r.left == null && r.right == null) {
            return 1;
        }
        return getLeafCountNode(r.left) + getLeafCountNode(r.right);
    }

    public int getLevelNodeCount(TreeNode r, int k) {
        if (r == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        return getLevelNodeCount(r.left, k - 1) +
                getLevelNodeCount(r.right, k - 1);

    }

    public int getHeight(TreeNode r){
        if(r==null){
            return 0;
        }
        int leftHeight=getHeight(r.left);
        int rigthHeight=getHeight(r.right);

        return Math.max(leftHeight,rigthHeight)+1;
    }
    public TreeNode findVal(TreeNode r,char val){
        if(r==null){
            return null;
        }
        if(r.val==val){
            return r;
        }
        TreeNode ret1=findVal(r.left,val);
        if(ret1!=null){
            return ret1;
        }
        TreeNode ret2=findVal(r.right,val);
        if(ret2!=null){
            return ret2;
        }
        return null;
    }
}
