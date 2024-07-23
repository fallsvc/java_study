package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/23  9:22
 *
 *
 *
 */
public class BinarySearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;
    public void insert(int val){
        if(root==null){
            root=new TreeNode(val);
            return;
        }
        TreeNode parent=null;
        TreeNode cur=root;
        TreeNode node=new TreeNode(val);
        while (cur!=null){
            parent=cur;
            if(cur.val>node.val){
                cur=cur.left;
            }else if(cur.val<node.val){
                cur=cur.right;
            }else {
                return;
            }
        }
        if(parent.val>node.val){
            parent.left=node;
        }else {
            parent.right=node;
        }

    }
    public TreeNode search(int val){
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val>val){
                cur=cur.left;
            }else if(cur.val<val){
                cur=cur.right;
            }else {
                return cur;
            }
        }
         return null;
    }
    public void remove(int val){
        TreeNode cur=root;
        TreeNode parent=null;
        while(cur!=null){
            if(cur.val>val){
                parent=cur;
                cur=cur.left;
            }else if(cur.val<val){
                parent=cur;
                cur=cur.right;
            }else {
                removeNode(parent,cur);
                return;
            }
        }
    }
    public void removeNode(TreeNode parent,TreeNode cur){
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(parent.left==cur){
                parent.left=cur.right;
            }else {
                parent.right=cur.right;
            }
        } else if (cur.right == null) {
            if(cur==root){
                root=cur.left;
            }else if(parent.left==cur){
                parent.left=cur.left;
            }else {
                parent.right=cur.left;
            }
        }else {
            //右数找最小
            TreeNode prev=cur;
            TreeNode c=cur.right;
            while(c.left!=null){
                prev=c;
                c=c.left;
            }
            cur.val=c.val;
            if(prev.left==c){
                prev.left=c.right;
            }else {
                prev.right=c.right;
            }

        }
    }

}
