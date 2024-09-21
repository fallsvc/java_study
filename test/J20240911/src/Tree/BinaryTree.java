package Tree;

import com.sun.source.tree.Tree;

import java.util.*;

import static java.lang.System.exit;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/11  10:13
 */
public class BinaryTree {
    static class Node{
        public int val;
        public Node left;
        public Node right;
        Node(int val){
            this.val=val;
        }
    }
    //前序遍历
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        list.add(root.val);
        List<Integer> leftTree=preorderTraversal(root.left);
        list.addAll(leftTree);
        List<Integer> rightTree=preorderTraversal(root.right);
        list.addAll(rightTree);

        return list;
    }
    public void preOrder(Node root){
        if(root==null) return;
        System.out.println(root.val +" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //非递归
    public void preOrderNor(Node root){
        if(root==null) return ;

        Stack<Node> stack=new Stack<>();
        Node cur=root;

        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur=cur.left;
            }
            Node node=stack.pop();
            cur=node.right;
        }


    }
    //中序遍历
    public void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }
    public void inOrderNor(Node root){
        if(root==null) return ;

        Stack<Node> stack=new Stack<>();
        Node cur=root;

        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node node=stack.pop();
            System.out.print(node.val+" ");
            cur=node.right;
        }


    }
    //后序遍历
    public void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val+" ");
    }
    public void postOrderNor(Node root){
        if(root==null) return ;

        Stack<Node> stack=new Stack<>();
        Node cur=root;
        Node prev=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                cur=cur.left;
            }
            Node peek=stack.peek();
            if(peek.right==null||peek.right==prev){
                System.out.println(peek.val+" ");
                prev=peek;
                stack.pop();
            }else{
                cur=peek.right;
            }
        }
    }

    // 获取树中节点的个数
     public int size(Node root){
        if(root==null) return 0;
        return 1+size(root.left)+
        size(root.right);
     };
     // 获取叶子节点的个数
     int getLeafNodeCount(Node root){
         if(root==null) return 0;

         if(root.left==null&&root.right==null){
             return 1;
         }

         int left=getLeafNodeCount(root.left);
         int right=getLeafNodeCount(root.right);

         return left+right;
     };
     // 子问题思路-求叶子结点个数
     // 获取第K层节点的个数
     int getKLevelNodeCount(Node root,int k){
         if(root==null) return 0;
         if(k==1) return 1;

         return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
     };
     // 获取二叉树的高度
     int getHeight(Node root){
         if(root==null) return 0;
         int leftHeight=getHeight(root.left);
         int rightHeight=getHeight(root.right);

         return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
     };
     // 检测值为value的元素是否存在
     Node find(Node root, int val){
         if(root==null) return null;
         if(root.val==val) return root;
         Node node1=find(root.left,val);
         if(node1!=null){
             return node1;
         }
         Node node2=find(root.right,val);
        if(node2!=null){
            return node2;
        }
         return null;
     };
    //层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;

        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);//加入根节点
        while(!queue.isEmpty()){
            List<Integer> list1=new ArrayList<>();
            //遍历每一层
            int size=queue.size();
            while(size-->0){
                Node tmp=queue.poll();
                list1.add(tmp.val);
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
            }
            list.add(list1);
        }

        return list;
    }

    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(Node root){
        if(root==null) return true;

        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        //放入队列 如果找到第一个空时停止 该队列已经存放该节点 这一层所有节点
        while(!queue.isEmpty()){
            Node tmp=queue.poll();
            if(tmp!=null){
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }else{
                break;
            }
        }
        //如果还有不为空值则不是完全二叉树
        while(!queue.isEmpty()){
            if(queue.poll()!=null) return false;
        }

        return true;
    };
    //判断树是否相同
    public static boolean isSameTree(Node p,Node q) {
        if(p==null&&q==null) return true;
        if((p==null&&q!=null)||(p!=null&&q==null)) return false;

        if(p.val!=q.val) {
            return false;
        }

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //判断是不是子树
    public boolean isSubtree(Node root, Node subRoot) {
        if(root==null) return false;

        if(isSameTree(root,subRoot)) return true;
        if(isSubtree(root.left,subRoot)) return true;
        if(isSubtree(root.right,subRoot)) return true;

        return false;
    }
    //翻转二叉树
    public Node invertTree(Node root) {
        if(root==null) return null;
        if(root.left==null&&root.right==null) return root;

        Node tmp=root.left;
        root.left=root.right;
        root.right=tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public Node invertTree1(Node root){
        return null;
    }
    //判断是否是对称二叉树
    public boolean isSymmetric(Node root) {
        if(root==null) return true;

        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(Node leftTree,Node rightTree){
        //判断左右节点是否存在
        if(leftTree!=null&&rightTree==null || leftTree==null&&rightTree!=null) return false;
        if(leftTree==null&&rightTree==null) return true;

        //有节点判断是否相等
        if(leftTree.val!=rightTree.val) return false;
        //判断左右对称
        return isSymmetricChild(leftTree.left,rightTree.right)&&isSymmetricChild(leftTree.right,rightTree.left);
    }
    //判断是否是平衡二叉树

    //O(N^2)
    public int treeHeight(Node root){
        if(root==null) return 0;
        int leftHeight=treeHeight(root.left);
        int rightHeight=treeHeight(root.right);
        return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
    }
    public boolean isBalanced(Node root) {
        if(root==null) return true;
        int leftHeight=treeHeight(root.left);
        int rightHeight=treeHeight(root.right);

        return Math.abs(leftHeight-rightHeight)<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    //O(N)
    public int treeHeight1(Node root){
        if(root==null) return 0;
        int leftHeight=treeHeight(root.left);
        if(leftHeight<0){
            return -1;
        }
        int rightHeight=treeHeight(root.right);
        if(rightHeight!=-1&&Math.abs(leftHeight-rightHeight)<2){
            return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
        }else{
            return -1;
        }

    }
    public boolean isBalanced1(Node root) {
        if(root==null) return true;

        return treeHeight(root)>=0;
    }

    // 二叉搜索树转化为双向链表
    public Node prev=null;
    public Node convertChild(Node root){
        if(root==null) return null;

        //中序遍历
        convertChild(root.left);
        root.left=prev;
        //回退时root的前一个节点不为空就有
        if(prev!=null)
            prev.right=root;

        prev=root;

        convertChild(root.right);

        return root;
    }
    public Node convert(Node root){
        if(root==null) return null;
        Node cur=convertChild(root);

        //找到表头
        while(cur.left!=null){
            cur=cur.left;
        }
        return cur;
    }

    //    //创建 二叉树
        public  int i=0;
        public  Node createTree(String str){
//            if(i==str.length()) return null;

            char ch=str.charAt(i++);
            if(ch=='#') return null;

            Node node=new Node(ch);
            node.left=createTree(str);
            node.right=createTree(str);

            return node;
        }
        //中序遍历打印
        public  void inorder(Node root){
            if(root==null) return;
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }

    //p,q共同祖先
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null) return null;
        if(p==root||q==root) return root;

        Node leftTree=lowestCommonAncestor(root.left,p,q);
        Node rightTree=lowestCommonAncestor(root.right,p,q);

        if(leftTree!=null&&rightTree!=null){
            return root;
        }else if(leftTree!=null){
            return leftTree;
        }else{
            return rightTree;
        }

    }
    //2找 路径
    public Node lowestCommonAncestor1(Node root, Node p, Node q) {
            if(root==null) return null;

            Stack<Node> stack1=new Stack<>();
            Stack<Node> stack2=new Stack<>();
            getPath(root,p,stack1);
            getPath(root,q,stack2);

            int size1=stack1.size();
            int size2=stack2.size();
            Node ret=null;
            if(size1>size2){
                int n=size1-size2;
                while(n-->0) {
                    stack1.pop();
                }
            }else{
                    int n = size2 - size1;
                    while (n-- > 0) {
                        stack2.pop();
                    }
                }
        while(!stack1.isEmpty()){
            Node node=stack1.pop();
            if(node.equals(stack2.pop())){
                ret=node;
            }
        }

            return ret;
    }
    public boolean getPath(Node root, Node node, Stack<Node> stack){
            if(root==null) return false;

            stack.push(root);
            if(root==node) return true;


            boolean ret=getPath(root.left,node,stack);
            if(ret){
                return true;
            }
            ret=getPath(root.right,node,stack);
            if(ret){
                return true;
            }

            stack.pop();
            return false;
    }
    //中序遍历和前序遍历创建 二叉树
    public int preIndex=0;
    public Node buildTree(int[] preorder, int[] inorder) {

        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }

    private Node buildTreeChild(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(inStart>inEnd) return null;

        Node root=new Node(preorder[preIndex]);
        //找到该值在中序遍历 数组的下标
        int finVal=findIndex(inorder,preorder[preIndex],inStart,inEnd);
        if(finVal<0) System.exit(0); //中序遍历中没有找到前序遍历中的值

        preIndex++;

        root.left=buildTreeChild(preorder,inorder,inStart,finVal-1);
        root.right=buildTreeChild(preorder,inorder,finVal+1,inEnd);

        return root;
    }

    //中序遍历加后序遍历  创建二叉树
    public int postIndex;

    public Node buildTree2(int[] inorder,int[] postorder ) {
        postIndex=inorder.length-1;
        return buildTreeChild(postorder,inorder,0,inorder.length-1);
    }

    private Node buildTreeChild2(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if(inStart>inEnd) return null;

        Node root=new Node(postorder[postIndex]);
        //找到该值在中序遍历 数组的下标
        int finVal=findIndex(inorder,postorder[postIndex],inStart,inEnd);
        if(finVal<0) System.exit(0); //中序遍历中没有找到前序遍历中的值

        postIndex--;
        root.right=buildTreeChild(postorder,inorder,finVal+1,inEnd);
        root.left=buildTreeChild(postorder,inorder,inStart,finVal-1);


        return root;
    }

    private int findIndex(int[] inorder, int key, int inStart, int inEnd) {
        for (int i = inStart; i <=inEnd ; i++) {
            if(inorder[i]==key){
                return i;
            }
        }
        return -1;
    }
    //树到括号字符串   1(()2)(3)
     public String tree2str(Node root) {
         if(root==null) return null;

         StringBuilder stringBuilder=new StringBuilder();
         createStr(root,stringBuilder);

         return stringBuilder.toString();
     }
    public void createStr(Node root,StringBuilder stringBuilder){
        if(root==null) return;
        stringBuilder.append(root.val);

        if(root.left!=null){
            stringBuilder.append("(");
            createStr(root.left,stringBuilder);
            stringBuilder.append(")");
        }else{
            if(root.right!=null){
                stringBuilder.append("()");
            }else{
                return;
            }
        }
        if(root.right!=null){
            stringBuilder.append("(");
            createStr(root.right,stringBuilder);
            stringBuilder.append(")");
        }else{
            return;
        }
    }
    //





}
