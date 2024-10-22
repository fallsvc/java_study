package AVLTree;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/20  10:46
 */
public class MyAVLTree {
    static class TreeNode{
        public int val;
        public int bf;//平衡因子
        public TreeNode left;//左树
        public TreeNode right;//右树
        public TreeNode parent;//父亲节点

        public TreeNode(int val){
            this.val=val;
        }
    }

    public TreeNode root;//根节点

    public boolean insert(int val){
        TreeNode node=new TreeNode(val);
        if(root==null){
            root=node;
            return true;
        }

        TreeNode parent=null;
        TreeNode cur=root;
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
        node.parent=parent;

        //调节平衡因子
        cur=node;
        while(parent!=null){
            //平衡因子
            if(cur==parent.right){
                parent.bf++;
            }else{
                parent.bf--;
            }

            if(parent.bf==0){
                //已经平衡
                break;
            }else if(parent.bf==-1||parent.bf==1){
                //向上遍历
                cur=parent;
                parent=cur.parent;
            }else{
                //2
                if(parent.bf==2){
                    if(cur.bf==1){
                        rotateLeft(parent);
                    }else{
                        //cur.bf==-1;
                        rotateRL(parent);
                    }

                }else{
                    //bf==-2;
                    if(cur.bf==1){
                        rotateLR(parent);
                    }else{
                        rotateRight(parent);
                    }
                }
                break;
            }
        }
        return false;
    }

    //

    private void rotateRL(TreeNode parent) {
        TreeNode subL=parent.right;
        TreeNode subLR=subL.left;
        //旋转后subLR的bf会被修改成0
        int bf=subLR.bf;

        rotateRight(subL);
        rotateLeft(parent);

        if(bf==1){
            subL.bf=0;
            subLR.bf=0;
            parent.bf=-1;
        }else if(bf==-1){
            subL.bf=1;
            subLR.bf=0;
            parent.bf=0;
        }
        //bf=0时如三个节点bf已经全修改为0了
    }

    private void rotateLR(TreeNode parent) {
        TreeNode subL=parent.left;
        TreeNode subLR=subL.right;
        int bf=subLR.bf;

        rotateLeft(subL);
        rotateRight(parent);

        if(bf==1){
            subL.bf=-1;
            subLR.bf=0;
            parent.bf=0 ;
        }else if(bf==-1){
            subL.bf=0;
            subLR.bf=0;
            parent.bf=1;
        }
    }

    private void rotateRight(TreeNode parent){
        TreeNode subL=parent.left;
        TreeNode subLR=subL.right;

        parent.left=subLR;
        if(subLR!=null){
            subLR.parent=parent;
        }

        subL.right=parent;
        TreeNode pParent=parent.parent;
        parent.parent=subL;

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

        subL.bf=0;
        parent.bf=0;
    }
    public void rotateLeft(TreeNode parent){
        TreeNode subR=parent.right;
        TreeNode subRL=subR.left;

        parent.right=subRL;

        subR.left=parent;
        if(subRL!=null){
            subR.parent=parent;
        }
        TreeNode pParent=parent.parent;
        parent.parent=subR;

        if(root==parent){
            root=subR;
            root.parent=null;
        }else{
            if(pParent.left==parent){
                pParent.left=subR;
            }else{
                pParent.right=subR;
            }
            subR.parent=pParent;
        }

        subR.bf=0;
        parent.bf=0;

    }
    //中序遍历 判断是不是二叉树
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);

    }
    //
    public boolean isBalance(TreeNode root){
        if(root==null) return true;

        int leftH=getHeight(root.left);
        int rightH=getHeight(root.right);

        if(rightH-leftH!=root.bf){
            System.out.println("平衡因子异常");
            return false;
        }

        return Math.abs(rightH-leftH)<2&&isBalance(root.left)&&isBalance(root.right);
    }

    private int getHeight(TreeNode root) {
        if(root==null) return 0;
        int leftH=getHeight(root.left);
        int rightH=getHeight(root.right);

        return leftH>rightH?leftH+1:rightH+1;
    }
}
