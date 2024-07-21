package demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/20  7:53
 */
public class Tree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    //非递归后序遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode prev=null;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode ret=stack.peek();
            if(ret.right==null || ret.right==prev){
                list.add(ret.val);
                ret=stack.pop();
            }else{
                cur=ret.right;
            }
        }
        return list;
    }
}
