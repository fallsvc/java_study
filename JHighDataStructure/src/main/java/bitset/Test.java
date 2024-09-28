package bitset;

import java.util.BitSet;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/28  10:04
 */
public class Test {

    public static void main(String[] args) {
        BitSet bitSet=new BitSet(10);
        bitSet.set(16);
        bitSet.set(18);
        bitSet.set(16);
        bitSet.set(13);

        System.out.println(bitSet.size());

        System.out.println(bitSet.length());
    }
    public static void main2(String[] args) {
        int[] array={1,4,3,2,1,7,9,20};
        MyBitSet myBitSet=new MyBitSet(20);

        for (int i = 0; i < array.length; i++) {
            myBitSet.set(array[i]);
        }

        System.out.println(myBitSet.usedSize);
        System.out.println(myBitSet.get(9));
        myBitSet.reSet(20);
        System.out.println(myBitSet.usedSize);
        System.out.println(myBitSet.get(20));
//        System.out.println(myBitSet.get(100));

        myBitSet.bitSetSort();
    }

    public static void main1(String[] args) {

        int[] array={1,20,2,4,7,9,8,42};
        BitSet bitSet=new BitSet(20);
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i]);
        }
        System.out.println(bitSet.get(20));
    }
}
