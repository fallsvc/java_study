package BST;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/16  20:05
 */
public class BinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;

    public int insert(int key){
        TreeNode newnode=new TreeNode(key);
        if(root==null){
            root=newnode;
        }else{
            TreeNode parent=null;
            TreeNode cur=root;
             while(cur!=null){
                 if(cur.val>key){
                     parent=cur;
                     cur=cur.left;
                 }else if(cur.val<key){
                     parent=cur;
                     cur=cur.right;
                 }else{
                     //不能放相同元素
                     break;
                 }
             }
             //判断该节点在左还是右
            if(parent.val>key){
                parent.left=newnode;
            }else{
                //已经不存在等于
                parent.right=newnode;
            }
        }
        return key;
    }
    public TreeNode search(int key){
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val>key){
                cur=cur.left;
            }else if(cur.val==key){
                return cur;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }

    public TreeNode remove(int key){
        TreeNode parent=null;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val>key){
                parent=cur;
                cur=cur.left;
            }else if(cur.val<key){
                parent=cur;
                cur=cur.right;
            }else{
                removeNode(parent,cur);
                break;
//                return null;
            }
        }
        return cur;
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(parent.left==cur){
                parent.left=cur.right;
            }else{
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(parent.left==cur){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else{
            //节点两边都不为null 可以采用左树找最大或者右树找最小
            //这里采用右树找最小
            TreeNode prev=cur;
            TreeNode pcur=cur.right;
            while(pcur.left!=null){
                prev=pcur;
                pcur=pcur.left;
            }
            cur.val=prev.val;
            //防止就在cur的下一个节点
            if(prev.left==pcur){
                prev.left=pcur.right;
            }else{
                prev.right=pcur.right;
            }
        }

    }
}
