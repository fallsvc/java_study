package optimizationalgorithm.queueandbfs;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/7  15:25
 */
public class Demo1 {
    public static void main(String[] args) {
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

    class Solution {
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
}
