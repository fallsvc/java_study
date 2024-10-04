package btree;



/**
 * @auther falls_vc
 * description:
 * @date 2024/10/3  17:26
 */
public class MyBTree {
    static class BTNode{
        public int[] keys; // 关键字
        public BTNode[] subs; // 孩子节点
        public BTNode parent; // 父亲节点

        public int usedSize;// 当前节点的数据个数

        public BTNode(){
            this.keys=new int[M];// 没有使用M-1 加一个好操作
            this.subs=new BTNode[M+1];
        }
    }

    public static final int M=3;

    public BTNode root;
    /**
     * 插入数据
     * @param key
     */
    public boolean insert(int key){
        // 当为头节点为null
        if(root==null){
            root=new BTNode();
            root.keys[0]=key;
            root.usedSize++;

            return true;
        }
        // 找是否存在节点key
        Pair<BTNode,Integer> pair=findKey(key);
        //
        if (pair.getVal()!=-1) {
            return false;
        }
        BTNode findNode=pair.getKey();// 找到要插入的 节点
        // 直接插入排序
        int i = findNode.usedSize-1;
        for (;i>=0 ;i--) {
            if(findNode.keys[i]>key){
                findNode.keys[i+1]=findNode.keys[i];
            }else{
                break;
            }
        }
        findNode.keys[i+1]=key;
        findNode.usedSize++;

        if(findNode.usedSize>=M) {
            // 满了 开始分裂
            split(findNode);
        }
        return true;
    }

    private void split(BTNode cur) {
        BTNode newNode=new BTNode();

        // 拷贝父亲节点
        BTNode parent=cur.parent;
        //挪数据

        int midIndex=cur.usedSize/2;
        int j=0;
        int i = midIndex+1;
        for (; i < cur.usedSize ; i++) {
            newNode.keys[j]=cur.keys[i]; // 拷贝有效数据
            newNode.subs[j]=cur.subs[i]; // 拷贝孩子节点
            if(newNode.subs[j]!=null){
                newNode.subs[j].parent=newNode;
            }
            cur.subs[i]=null; //
            j++;
        }
        // 多拷贝一个节点
        newNode.subs[j]=cur.subs[i];
        cur.subs[i]=null;
        if(newNode.subs[j]!=null){
            newNode.subs[j].parent=newNode;
        }

        // 更新新节点有效数字个数
        newNode.usedSize=j;
        // cur 直接设为分裂后节点个数
        cur.usedSize= cur.usedSize-j-1;

        // 处理特殊情况 分裂节点为root
        if(cur==root){
            root=new BTNode();
            root.keys[0]=cur.keys[midIndex];
            root.usedSize=1;
            root.subs[0]=cur;
            root.subs[1]=newNode;

            cur.parent=root;
            newNode.parent=root;

            return;
        }

        // 更新当前节点的父亲节点
        newNode.parent=parent;
        // 开始挪动父亲节点
        int endT=parent.usedSize-1;
        int val=cur.keys[midIndex];

        // 挪动 parent
        while(endT>=0&&parent.keys[endT]>val){
            parent.keys[endT+1]=parent.keys[endT];
            parent.subs[endT+2]=parent.subs[endT+1];
            endT--;
        }
        // 放入新的节点和有效数据
        parent.keys[endT+1]=val;
        parent.subs[endT+2]=newNode;
        parent.usedSize++;


        if(parent.usedSize>=M){
            split(parent);
        }
    }

    private Pair<BTNode,Integer> findKey(int key) {
        BTNode parent=root;
        BTNode cur=root;

        while(cur!=null){
            int i=0;
            while(i< cur.usedSize){
                if(cur.keys[i]<key){
                    i++;
                }else if(cur.keys[i]>key){
                    break;
                }else{
                    return new Pair<>(cur,i);
                }
            } // 到下一个子节点下标停下
            parent=cur;
            cur=cur.subs[i];
        }
        return new Pair<BTNode,Integer>(parent,-1);
    }

    //
    public void inOrder(BTNode root){
        if(root==null){
            return;
        }

        for (int i = 0; i < root.usedSize; i++) {
            inOrder(root.subs[i]);
            System.out.println(root.keys[i]);
        }

        inOrder(root.subs[root.usedSize]);
    }

}
