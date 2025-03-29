package recursivesearchbacktrackin.search;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/29  18:23
 */
public class Demo {
//    https://leetcode.cn/problems/evaluate-boolean-binary-tree/description/
    //public boolean evaluateTree(TreeNode root) {
    //    if(root.left==null) {
    //        return root.val==0?false:true;
    //    }
    //    boolean left=evaluateTree(root.left);
    //    boolean right=evaluateTree(root.right);
    //    if(root.val==2) return left||right;
    //    else return left&&right;
    //}

//    https://leetcode.cn/problems/sum-root-to-leaf-numbers/submissions/616897971/
//    public int sumNumbers(TreeNode root) {
//
//        return sums(root,0);
//    }
//        public int sums(TreeNode root,int x){
//            x=x*10+root.val;
//            if(root.left==null&&root.right==null) return x; //1.无子节点
//            int ret=0;
//            if(root.left!=null) ret+=sums(root.left,x); // 2.有左节点
//            if(root.right!=null) ret+=sums(root.right,x);// 3.有右节点
//
//            return ret;
//        }

//    https://leetcode.cn/problems/binary-tree-pruning/
//    public TreeNode pruneTree(TreeNode root) {
//        if(root==null) return null;
//
//        root.left=pruneTree(root.left);
//        root.right=pruneTree(root.right);
//
//        if(root.left==null&&root.right==null&&root.val==0) return null;
//
//        return root;
//    }

//    https://leetcode.cn/problems/validate-binary-search-tree/
//        long pre=Long.MIN_VALUE;
//    public boolean isValidBST(TreeNode root) {
//        if(root==null) return true;
//
//        boolean left=isValidBST(root.left);
//        boolean cur=false;
//        if(pre<root.val) cur= true;
//
//        pre=root.val;
//        boolean right=isValidBST(root.right);
//
//        return left&&right&&cur;
//    }

//        long pre=Long.MIN_VALUE;
//    public boolean isValidBST(TreeNode root) {
//        if(root==null) return true;
//
//        boolean left=isValidBST(root.left);
//        // 剪枝
//        if(left==false) return false;
//        if(pre>=root.val) return false;
//
//        pre=root.val;
//        boolean right=isValidBST(root.right);
//
//        return left&&right;
//    }


//    https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
//    int count;
//    int ret;
//    public int kthSmallest(TreeNode root, int k) {
//        count=k;
//        dfs(root);
//        return ret;
//    }
//    public void dfs(TreeNode root){
//        if(root==null||count==0) return;// 剪枝
//        dfs(root.left);
//        count--;
//        if(count==0) {
//            ret=root.val;
//            return; // 剪枝
//        }
//        dfs(root.right);
//    }
public static void main(String[] args) {

}


}
