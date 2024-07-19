package demo1;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/18  7:45
 */
public class BinaryTree {
    static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }

    }
    //层序遍历使用队列
    public void levelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode c=q.poll();
            System.out.print(c.val+" ");
            if(c.left!=null){
                q.offer(c.left);
            }
            if(c.right!=null){
                q.offer(c.right);
            }
        }
    }
    public List<List<Character>> levelOrder1(TreeNode root){
        List<List<Character>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Character> list=new ArrayList<>();
            while(size>0){

                TreeNode c=q.poll();
                list.add(c.val);
                if(c.left!=null){
                    q.offer(c.left);
                }
                if(c.right!=null){
                    q.offer(c.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }
    //反转二叉树
    public TreeNode invertTree(TreeNode root){
        if(root==null) return root;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    //判断是不是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode c=queue.poll();
            if(c!=null){
                queue.offer(c.left);
                queue.offer(c.right);
            }else{
                break;
            }

        }
        while(!queue.isEmpty()){
            TreeNode c=queue.poll();
            if(c!=null){
                return false;
            }
        }
        return true;
    }
    //p,q父亲节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);
        if(leftNode!=null&&rightNode!=null){
            return root;
        }else if(leftNode!=null){
            return leftNode;
        }else if(rightNode!=null){
            return rightNode;
        }else{
            return null;
        }

    }
    public boolean getPath(TreeNode root, TreeNode find, Stack<TreeNode> stack){
        if(root==null){
            return  false;
        }
        stack.add(root);
        if(root==find){
            return true;
        }
        boolean ret=getPath(root.left,find,stack);
        if(ret){
            return true;
        }
        ret=getPath(root.right,find,stack);
        if(ret){
            return true;
        }
        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        getPath(root,p,stack1);
        getPath(root,q,stack2);
        int size=stack1.size()-stack2.size();
        if(size>0){
            while(size-->0){
                stack1.pop();
            }
        }else{
            size=-size;
            while(size-->0){
                stack2.pop();
            }
        }
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            if(stack1.peek()==stack2.peek()){
                return stack1.peek();
            }else{
                stack1.pop();
                stack2.pop();
            }
        }
        return null;
    }
    public String tree2str(TreeNode root) {
        if(root==null){
            return null;
        }
        StringBuilder stringBuilder=new StringBuilder("");
        tree2strCreate(root,stringBuilder);
        return stringBuilder.toString();

    }
    //二叉树转字符串
    public void tree2strCreate(TreeNode root,StringBuilder stringBuilder){
        if(root==null){
            return;
        }
        stringBuilder.append(root.val);
        //打印左边节点
        if(root.left!=null){
            stringBuilder.append("(");
            tree2strCreate(root.left,stringBuilder);
            stringBuilder.append(")");
        }else{
            if(root.right!=null){
                stringBuilder.append("()");
            }else{
                return;
            }
        }
        //打印右边节点
        if(root.right!=null){
            stringBuilder.append("(");
            tree2strCreate(root.right,stringBuilder);
            stringBuilder.append(")");
        }else{
            return;
        }
    }
    //中序和前序数组创建树
//    public int preorderIndex;
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return buildTree2(preorder,inorder,0,inorder.length-1);
//    }
//    public TreeNode buildTree2(int[] preorder,int[] inorder,int istart,int iend){
//        if(istart>iend){
//            return null;
//        }
//        TreeNode root=new TreeNode(preorder[preorderIndex]);
//        preorderIndex++;
//        int rootIndex=findVal(root.val,inorder,istart,iend);
//        root.left=buildTree2(preorder,inorder,istart,rootIndex-1);
//        root.right=buildTree2(preorder,inorder,rootIndex+1,iend);
//
//        return root;
//    }
//    public int findVal(int val,int[] inorder,int i,int j){
//        while(i<=j){
//            if(val==inorder[i]){
//                return i;
//            }
//            i++;
//        }
//        return -1;
//    }

    //中序和后序创建树
    public int postorderIndex;//下标遍历postorder数组
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex=postorder.length-1;//从后遍历
        return buildTree1(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode buildTree1(int[] inorder,int[] postorder,int istart,int iend){
        if(istart>iend) return null;
        //创建根节点
        TreeNode root=new TreeNode(postorder[postorderIndex]);
        postorderIndex--;
        //中序遍历数组中找到根节点下标，用来分割左右节点
        int rootIndex=findVal(root.val,inorder,istart,iend);
        //后序遍历数组倒序拿先出右节点
        //创建右节点
        root.right=buildTree1(inorder,postorder,rootIndex+1,iend);
        //创建左节点
        root.left=buildTree1(inorder,postorder,istart,rootIndex-1);

        return root;
    }
    public int findVal(int val,int[] inorder,int i,int j){
        while(i<=j){
            if(val==inorder[i]){
                return i;
            }
            i++;
        }
        return -1;
    }
    //循环实现前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();//存放遍历
        if(root==null){
            return list;
        }
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=root;
        //向左节点遍历入栈，为空后出栈cur引用出栈节点的右节点
        while(cur!=null||!s.empty()){
            while(cur!=null){
                s.push(cur);
                list.add(cur.val);
                cur=cur.left;
            }
            TreeNode ret=s.pop();
            cur=ret.right;
        }
        return list;
    }
    //循环实现中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode ret=stack.pop();
            list.add(ret.val);
            cur=ret.right;
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();

    }
}




