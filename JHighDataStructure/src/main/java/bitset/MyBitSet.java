package bitset;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/28  10:09
 */
public class MyBitSet {
    public byte[] elem;
    // 存入数据个数
    public int usedSize;

    public MyBitSet(){
        this.elem=new byte[1];
    }

    /**
     *
     * @param n 多少位
     *
     *  多给一个字节
     */
    public MyBitSet(int n){
        this.elem=new byte[n/8+1];
    }

    /**
     * 设置bit位唯一
     * @param val
     *
     */

    public void set(int val){
        if(val<0){
            throw new IndexOutOfBoundsException();
        }
        int index=val/8;
        // 扩容
        if(index>=elem.length){
            elem= Arrays.copyOf(elem,index+1);
        }

        int bitIndex=val%8;
        elem[index] |=1<<bitIndex;

        usedSize++;
    }

    /**
     *
     * @param val
     * @return
     */
    public boolean get(int val){
        int index=val/8;
        if(val<0||index>=elem.length){
            throw new IndexOutOfBoundsException();
        }

        int bitIndex=val%8;

        if((elem[index] & (1<<bitIndex))!=0){
            return true;
        }

        return false;
    }

    //

    /**
     *
     * @param val
     */

    public void reSet(int val){
        if(val<0){
            throw new IndexOutOfBoundsException();
        }
        int index=val/8;
        int bitIndex=val%8;

        if((elem[index]&(1<<bitIndex))==0){
           return ;
        }
        elem[index] &= ~(1<<bitIndex);
        usedSize--;
    }

    public void bitSetSort(){
        for (int i = 0; i < elem.length; i++) {
            for (int j = 0; j < 8; j++) {
                if((elem[i]&(1<<j))!=0){
                    System.out.print(i*8+j+" ");
                }
            }
        }
    }



}
