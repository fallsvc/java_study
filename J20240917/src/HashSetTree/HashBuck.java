package HashSetTree;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/17  10:32
 */
public class HashBuck<K,V> {
        static class Node<K,V>{
            K key;
            V val;
            Node<K,V> next;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }
        public Node<K,V>[] nodes=new Node[10];
        public int usedSize;
        public static final double DEFAULT_LOADFACTOR=0.75;

        public V put(K key,V val){
            int index=key.hashCode()%nodes.length;
            //找是否有这个Key
            Node<K,V> cur=nodes[index];
            while(cur!=null){
                if(cur.key.equals(key)){
                    cur.val=val;
                    return val;
                }
                cur=cur.next;
            }
            //头插
            Node<K,V> node=new Node<>(key,val);
            node.next=nodes[index];
            nodes[index]=node;
            usedSize++;

            if(doLoadFactor()>=DEFAULT_LOADFACTOR){
                reSize();
            }
            return val;
        }

    private void reSize() {
            Node<K,V>[] array=new Node[nodes.length*2];
        for (int i = 0; i < nodes.length; i++) {
            Node<K,V> cur=nodes[i];
            while(cur!=null){
                int index=cur.hashCode()%array.length;
                Node<K,V> Ncur=cur.next;
                //头插
                cur.next=array[index];
                array[index]=cur;

                cur=Ncur;
            }
        }
        nodes=array;
    }

    private double doLoadFactor() {
            return usedSize*1.0/ nodes.length;
    }
    public V getVal(K k){
            int index=k.hashCode()%nodes.length;
            Node<K,V> cur=nodes[index];
            while(cur!=null){
                if(cur.key.equals(k)){
                    return cur.val;
                }
                cur=cur.next;
            }
            return null;
    }
    public V remove(K key){
            int index=key.hashCode()%nodes.length;
            Node<K,V> prev=null;
            Node<K,V> cur=nodes[index];

            while(cur!=null){
                if(cur.key.equals(key)){
                    break;
                }
                prev=cur;
                cur=cur.next;
            }
            if(cur==null){
                return null;
            }

            if(prev==null){
                nodes[index]=null;
            }else{
                prev.next=cur.next;
            }
            usedSize--;
            return cur.val;
    }
}
