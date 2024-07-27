package demo1;

import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/27  17:16
 */
public class Tree<T> {
    static class TreeNode<T>{
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;
        public TreeNode(T val){
            this.val=val;
        }
    }
    public TreeNode<T> head;
    public TreeNode<T> getHead(){
        return head;
    }
    public void add(T t){
        TreeNode<T> node=new TreeNode<>(t);
        if(head==null){
            head=node;
            return;
        }
        TreeNode<T> cur=head;
        TreeNode<T> prev=null;
        Random random=new Random();
        while(cur!=null){
            int x=random.nextInt(10);
            prev=cur;
            if(x<5){
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }
        if(prev.left==cur){
            prev.left=node;
        }else {
            prev.right=node;
        }

    }
    public void play(TreeNode<T> root){
        if(root==null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.val+" ");
        play(root.left);
        play(root.right);
    }
}
