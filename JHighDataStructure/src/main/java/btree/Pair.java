package btree;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/3  18:54
 */
public class Pair <K,V>{
    public K key;
    public V val;

    public Pair(K key,V val){
        this.key=key;
        this.val=val;

    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }
}
