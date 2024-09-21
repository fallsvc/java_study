package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/24  17:27
 */
public class HashBuck2<K,V> {
    static class Node<K,V>{
        public K key;
        public V val;
        public Node<K,V> next;
        public Node(K key,V val){
            this.key=key;
            this.val=val;
        }

    }
    Node<K,V>[] array=(Node<K, V>[]) new Node[10];
    public int usedSize;

    public static final double DEFAULTFACTOR=0.75;

    public void push(K key,V val){
        int index=key.hashCode()%array.length;
        Node<K,V> cur=array[index];
        while(cur!=null){
            if(cur.key.equals(key)){
                cur.val=val;
                return;
            }
            cur=cur.next;
        }
        //头插
        Node<K,V> node=new Node<>(key, val);
        node.next=array[index];
        array[index]=node;
        usedSize++;
        if(doLoadFactor()>DEFAULTFACTOR){
            resize();
        }
    }

    private double doLoadFactor() {
        return usedSize*1.0/array.length;
    }

    private void resize() {
        Node<K,V>[] newArray=new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur=array[i];
            while(cur!=null){
                int index=cur.hashCode()%newArray.length;
                Node<K,V> curN=cur.next;
                cur.next=newArray[index];
                newArray[index]=cur;
                cur=curN;
            }
        }
        array=newArray;
    }
    public V getVal(K key){
        int index=key.hashCode()%array.length;
        Node<K,V> cur=array[index];
        while(cur!=null){
            if(cur.key.equals(key)){
                return cur.val;
            }
            cur=cur.next;
        }

        return null;
    }
}
