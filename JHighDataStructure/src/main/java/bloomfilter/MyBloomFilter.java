package bloomfilter;

import bitset.MyBitSet;

import java.util.BitSet;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/29  9:52
 */
class SimpleHash{

    public int cap;
    public int seed;

    public SimpleHash(int cap,int seed){
        this.cap=cap;
        this.seed=seed;

    }
    public int hash(String key){
        int h;
        //
        return (key == null) ? 0 :(seed*(cap-1)) & ((h = key.hashCode()) ^ (h >>> 16));
    }
}
public class MyBloomFilter {

    //默认大小
    public static final int DEFAULT_SIZE=1<<20;
    //位图
    public BitSet bitSet;
    //记录了多少数据
    public int usedSize;

    public static final int[] seeds={5,7,11,13,27,33};

    public static SimpleHash[] simpleHashes;

    public MyBloomFilter(){
        bitSet=new BitSet(DEFAULT_SIZE);
        simpleHashes=new SimpleHash[seeds.length];
        for (int i = 0; i < seeds.length; i++) {
            simpleHashes[i]=new SimpleHash(DEFAULT_SIZE,seeds[i]);
        }
    }

    /**
     * 添加元素到布隆过滤器
     * @param val
     */
    public void add(String val){

        //遍历hash函数
        for (SimpleHash simpleHash : simpleHashes) {
            int index=simpleHash.hash(val);
            // 放在位图
            bitSet.set(index);
        }

    }

    /**
     * 判断是否可能包含元素和一定不存在
     * @param val
     * @return
     */
    public boolean contains(String val){

        // 遍历hash 函数 找到对应放的几个值
        for (SimpleHash simpleHash : simpleHashes) {
            int index=simpleHash.hash(val);
            // 只有有0 这个值一定不存在
            if (!bitSet.get(index)) {
                return false;
            }
        }
        // 可能存在
        return true;
    }



}
