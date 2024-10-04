package lrucache;

import bloomfilter.MyBloomFilter;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/3  10:18
 */
public class MyDemo2 {
    public static void main(String[] args) {
        MyLRUCache myLRUCache=new MyLRUCache(1);
        myLRUCache.put(2,1);
        myLRUCache.put(3,2);
    }
    public static void main1(String[] args) {

        MyLRUCache myLRUCache=new MyLRUCache(16);
        myLRUCache.put(2,4);
        myLRUCache.printNodes(" put: ");
        myLRUCache.put(1,3);
        myLRUCache.printNodes(" put: ");
        myLRUCache.put(2,5);
        myLRUCache.printNodes(" put: ");
        myLRUCache.put(5,4);
        myLRUCache.printNodes(" put: ");
        System.out.println(myLRUCache.get(2));
        myLRUCache.printNodes(" get: ");
    }
}
