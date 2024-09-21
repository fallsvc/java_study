package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/24  15:21
 */
public class HashBuck {
    static class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    public static final double DEFAULT_LOADFACTOR=0.75;

    public Node[] array=new Node[10];
    public int usedSize;

    public void push(int key,int val){
        int index=key%array.length;
        Node cur=array[index];
        //找是否有相同key
        while(cur!=null){
            if(cur.key==key){
                cur.val=val;
                return;
            }
            cur=cur.next;
        }
        //头插
        Node node=new Node(key,val);
        node.next=array[index];
        array[index]=node;
        usedSize++;
        if(doLoadFactor()>=DEFAULT_LOADFACTOR){
            resize();
        }
    }

    private double doLoadFactor() {
        return usedSize*1.0/array.length;
    }

    private void resize() {
        Node[] newArray=new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {
            Node cur=array[i];
            while(cur!=null){
                int index=cur.key%newArray.length;
                Node curN=cur.next;
                cur.next=newArray[index];
                newArray[index]=cur;
                cur=curN;
            }
        }
        array=newArray;
    }
    public int getVal(int key){
        int index=key%array.length;
        Node cur=array[index];
        //找是否有相同key
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }
            cur=cur.next;
        }
        return -1;
    }
}















