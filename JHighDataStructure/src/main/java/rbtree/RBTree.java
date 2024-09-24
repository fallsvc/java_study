package rbtree;


import static rbtree.COLOR.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/21  19:40
 */
public class RBTree {
    static class RBTreeNode{
        public int val;
        public COLOR color;
        public RBTreeNode left;
        public RBTreeNode right;
        public RBTreeNode parent;
        public RBTreeNode(int val){
            this.val=val;
            this.color= red;
        }

    }
    public RBTreeNode root;
    public boolean insert(int val){
        RBTreeNode node=new RBTreeNode(val);
        //第一个节点为黑色
        if(root==null){
            root=node;
            node.color=COLOR.black;
            return true;
        }
        //判断插入节点位置
        RBTreeNode parent=null;
        RBTreeNode cur=root;
        while(cur!=null){
            if(cur.val>val){
                parent=cur;
                cur=cur.left;
            }else if(cur.val==val){
                return false;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }

        if(parent.val>val){
            parent.left=node;
        }else{
            parent.right=node;
        }
        //
        node.parent=parent;
        cur=node;
        //调整颜色
        while(parent!=null&&parent.color==red){
            RBTreeNode grandFather=parent.parent;//不可能为空
            if(grandFather.left==parent){
                RBTreeNode uncle=grandFather.right;
                if(uncle!=null&&uncle.color==red){
                    //情况一
                    parent.color=black;
                    uncle.color=black;
                    grandFather.color=red;
                    //向上遍历
                    cur=grandFather;
                    parent=grandFather.parent;
                }else{
                    //uncle为null或者黑色

                    //情况三cur在parent右边
                    if(parent.right==cur){
                        //左旋parent到情况二
                        leftRotate(parent);
                    }

                    //情况二
                    rightRotate(grandFather);
                    grandFather.color=red;
                    parent.color=black;
                }
            }else{
                //反转后
                RBTreeNode uncle=grandFather.left;
                if(uncle!=null&&uncle.color==red){
                    //情况一
                    parent.color=black;
                    uncle.color=black;
                    grandFather.color=red;
                    //向上遍历
                    cur=grandFather;
                    parent=grandFather.parent;
                }else{
                    //uncle为null或者黑色

                    //情况三cur在parent右边
                    if(parent.right==cur){
                        //右旋parent到情况二
                    }

                    //情况二
                    leftRotate(grandFather);
                    grandFather.color=red;
                    parent.color=black;
                }
            }
        }
        root.color=black;
        return true;
    }

    private void leftRotate(RBTreeNode parent) {
        RBTreeNode subL=parent.right;
        RBTreeNode subLR=subL.left;

        parent.right=subLR;

        subL.left=parent;
        if(subLR!=null){
            subL.parent=parent;
        }
        RBTreeNode pParent=parent.parent;
        parent.parent=subL;

        if(root==parent){
            root=subL;
            root.parent=null;
        }else{
            if(pParent.left==parent){
                pParent.left=subL;
            }else{
                pParent.right=subL;
            }
            subL.parent=pParent;
        }
    }

    private void rightRotate(RBTreeNode parent) {
        RBTreeNode subL=parent.left;
        RBTreeNode subLR=subL.right;

        parent.left=subLR;
        //
        if(subLR!=null){
            subLR.parent=parent;
        }

        subL.right=parent;
        //
        RBTreeNode pParent=parent.parent;
        parent.parent=subL;

        //
        if(root==parent){
            root=subL;
            subL.parent=null;
        }else{
            if(pParent.left==parent){
                pParent.left=subL;
            }else{
                pParent.right=subL;
            }
            subL.parent=pParent;
        }

    }
    //判断是不是红黑树
    public boolean isRBTree(RBTreeNode root){
        if(root==null) return true;
        //根节点为黑色
        if(root.color!=black){
            return false;
        }
        //红黑树黑色节点个数
        RBTreeNode cur=root;
        int count=0;
        while (cur!=null){
            if(cur.color==black){
                count++;
            }
            cur=cur.left;
        }
        //是否有两个连续的红色节点//路径上黑色个数
        return checkRedColor(root)&&checkBlackNum(root,0,count);
    }

    private boolean checkBlackNum(RBTreeNode root, int pathBlackNum, int blackNum) {
        if(root==null) return true;
        if(root.color==black){
            pathBlackNum++;
        }
        if(root.left==null&&root.right==null){
            if(pathBlackNum!=blackNum){
                System.out.println("路径上黑色节点个数不同");
                return false;
            }
        }

        return checkBlackNum(root.left,pathBlackNum,blackNum)&&checkBlackNum(root.right,pathBlackNum,blackNum);
    }



    private boolean checkRedColor(RBTreeNode root) {
        if(root==null) return true;
        if(root.color==red){
            RBTreeNode parent=root.parent;
            if(parent!=null&&parent.color==red){
                System.out.println("有两个连续的红色节点");
                return false;
            }
        }
        return checkRedColor(root.left)&&checkRedColor(root.right);
    }
    //中序遍历
    public void inOrder(RBTreeNode root){
        if(root==null) return ;

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
