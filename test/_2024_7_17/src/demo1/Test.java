package demo1;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/17  19:13
 */
public class Test {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //判断p树和q树相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q==null|| p==null&&q!=null ){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode tree, TreeNode subTree) {
        if(tree==null){
            return false;
        }
        if(isSameTree(tree,subTree)) return true;
        if(isSameTree(tree.left,subTree)) return true;
        if(isSameTree(tree.right,subTree)) return true;

        return false;
    }

    //交换树
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    //树是否对称
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree!=null&&rightTree==null ||leftTree==null&&rightTree!=null){
            return false;
        }
        if(leftTree==null&&rightTree==null){
            return true;
        }
        if(leftTree.val!=rightTree.val){
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right)&&isSymmetricChild(leftTree.right,rightTree.left);
    }

    //平衡二叉树
    //时间复杂度N^2
    public int getHeight1(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight1(root.left);
        int rightHeight=getHeight1(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
    public boolean isBalanced1(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftHeight=getHeight1(root.left);
        int rightHeight=getHeight1(root.right);

        return Math.abs(leftHeight-rightHeight)<2&&isBalanced1(root.left)&&isBalanced1(root.right);
    }
    // O(N)
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        if(leftHeight<0){
            return -1;
        }
        int rightHeight=getHeight(root.right);
        if(rightHeight>=0&&Math.abs(leftHeight-rightHeight)<2){
            return Math.max(leftHeight,rightHeight)+1;
        }else{
            return -1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        return getHeight(root)>=0;
    }
    //二叉树转双向链表
    public TreeNode Convert(TreeNode pRoot){

        if(pRoot==null){
            return null;
        }
        ConvertChild(pRoot);
        TreeNode c=pRoot;
        while(c.left!=null){
            c=c.left;
        }
        return c;
    }
    TreeNode prev=null;
    public void ConvertChild(TreeNode root){
        if(root==null){
            return;
        }
        ConvertChild(root.left);
        //最左节点
        root.left=prev;
        if(prev!=null){
            prev.right=root;
        }
        prev=root;
        ConvertChild(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s=in.nextLine();
            TreeNode c=createTree(s);
            inOrder(c);
        }
    }
    public static int i=0;
    public static TreeNode createTree(String s){
        if(s.isEmpty()){
            return null;
        }
        TreeNode root=null;
        if(s.charAt(i)!='#'){
            root=new TreeNode(s.charAt(i));
            i++;
            root.left=createTree(s);
            root.right=createTree(s);
        }else{
            i++;
        }
        return root;
    }
    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);

    }

}
