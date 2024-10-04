package bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.BitSet;
import java.util.HashMap;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/29  9:53
 */

public class demo1 {

    // 需要输入元素个数
    public static int size = 1000000;
    /**
     * 期望的误判率
     * 误判率越小 运算的时间越久
     */
    public static double fpp = 0.01;//误判率

    private static BloomFilter<Integer> bloomFilter =
            BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    public static void main(String[] args) {
        // 插入100W样本
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        int count = 0;
        // 误判率 用另外100w数据样本
        for (int i = size; i < size + 1000000; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
                System.out.println(i + "被误判了");
            }
        }
        System.out.println("总的误判数量：" + count);

    }



    public static void main1(String[] args) {
        MyBloomFilter myBloomFilter=new MyBloomFilter();
        myBloomFilter.add("heal");
        myBloomFilter.add("hill");
        myBloomFilter.add("helel");
        myBloomFilter.add("hello");

        System.out.println(myBloomFilter.contains("heal"));
        System.out.println(myBloomFilter.contains("lllll"));
    }

}
