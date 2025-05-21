package optimizationalgorithm.queueandbfs;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/7  15:25
 */
public class Demo1 {

    public static void main1(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        for(int x:list){
            System.out.println(x);
        }
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    class Solution1 {
//      https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
//      n层多叉数的层序遍历
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ret=new ArrayList<>();
            if(root==null) return ret;
            Queue<Node> q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int n=q.size();
                List<Integer> tmp=new ArrayList<>();
                for(int i=0;i<n;i++){
                    Node t=q.poll();
                    List<Node> childrens=t.children;
                    for(Node x:childrens){// 孩子入队
                        if(x!=null)
                            q.offer(x);
                    }
                    tmp.add(t.val);
                }
                ret.add(tmp);
            }
            return ret;
        }
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution2 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret=new ArrayList<>();
            if(root==null) return ret;

            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);
            boolean flag=false;
            while(!q.isEmpty()){
                int size=q.size();// 每一层节点个数
                List<Integer> tmp=new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode r=q.poll();
                    tmp.add(r.val);
                    // 不为null的子节点入队列
                    if(r.left!=null) q.offer(r.left);
                    if(r.right!=null) q.offer(r.right);
                }
                if(flag) Collections.reverse(tmp); // 有些行需要逆置
                ret.add(tmp);
                flag=!flag;
            }
            return ret;

        }

    }
    class Pair{
        TreeNode TreeNode;
        int index;
        public Pair(TreeNode treeNode, int index) {
            TreeNode = treeNode;
            this.index = index;
        }

        public TreeNode getTreeNode() {
            return TreeNode;
        }

        public void setTreeNode(TreeNode treeNode) {
            TreeNode = treeNode;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    class Solution3 {
//        https://leetcode.cn/problems/maximum-width-of-binary-tree/
//        每行最大宽度
        public int widthOfBinaryTree(TreeNode root) {

            Pair[] q=new Pair[3001];
            int size=1;
            int start=1;
            int len=0;
            q[1]=new Pair(root,1);
            int end=start+size;
            while(size!=0){

                len=Math.max(q[end-1].getIndex()-q[start].getIndex()+1,len);// 更新长度
                for(int i=start;i<start+size;i++){
                    TreeNode cur=q[i].getTreeNode();
                    int index=q[i].getIndex();
                    if(cur.left!=null) q[end++]=new Pair(cur.left,index*2);
                    if(cur.right!=null) q[end++]=new Pair(cur.right,index*2+1);
                }
                start=start+size;
                size=end-start;
            }
            return len;
        }


//        public int widthOfBinaryTree(TreeNode root) {
//            List<Pair<TreeNode,Integer>> q=new ArrayList<>();
//            q.add(new Pair(root,1));
//            int len=0;
//
//            while(!q.isEmpty()) {
//                int size=q.size();
//                // 更新长度
//                len=Math.max(q.get(size-1).getValue()-q.get(0).getValue()+1,len);
//
//                // 下一行入队
//                List<Pair<TreeNode,Integer>> tmp=new ArrayList<>();
//                for(int i=0;i<size;i++){
//                    TreeNode cur=q.get(i).getKey();
//                    int index=q.get(i).getValue();
//                    if(cur.left!=null) tmp.add(new Pair(cur.left,index*2));
//                    if(cur.right!=null) tmp.add(new Pair(cur.right,index*2+1));
//                }
                //   更新队列
//                q=tmp;
//            }
//            return len;
//        }

    }

    class Solution4 {
//        https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
//        找树每行最大值
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ret=new ArrayList<>();
            if (root == null) return ret;

            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size=q.size();
                int max=Integer.MIN_VALUE;
                // 出一行入一行
                for (int i=0;i<size;i++){
                    TreeNode cur=q.poll();
                    max=Math.max(cur.val,max);// 计算当前行最大值
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }
                ret.add(max);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();

    }
}
