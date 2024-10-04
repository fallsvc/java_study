package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/30  21:01
 */
public class LRUCache1<K,V> extends LinkedHashMap<K,V> {


    private int capacity;

    public LRUCache1(int capacity){
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }

    public V get(Object key){
        return super.get(key);
    }


    public V put(K key, V value){
        super.put(key,value);
        return value;
    }

    // 这个一定要写
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size()>capacity;
    }


}
//

class LRUCache2 extends LinkedHashMap<Integer,Integer>{

    public int capacity;

    public LRUCache2(int capacity) {
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }

    public Integer get(Integer key) {
        return super.getOrDefault(key,-1);
    }

    public Integer put(Integer key, Integer value) {
        return super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }
}