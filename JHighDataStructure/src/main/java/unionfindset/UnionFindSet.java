package unionfindset;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/30  19:32
 */
public class UnionFindSet {
    public int[] elem;
    public int usedSize;

    public UnionFindSet(int n){
        this.elem=new int[n];

        Arrays.fill(elem,-1);// 全写入-1
    }


    // 是否是同一集合
    public boolean isSameUnionFindSet(int x1,int x2){
        // 找根节点
        int index1=findRoot(x1);
        int index2=findRoot(x2);

        if(index1==index2){
            return true;
        }

        return false;
    }

    private int findRoot(int x) {
        if(x<0) {
            throw new IndexOutOfBoundsException();
        }
        // 向前找值为负数的下标值
        while(elem[x]>=0){
            x=elem[x];
        }

        return x;
    }

    /**
     *
     * 合并两个集合
     * @param x1
     * @param x2
     */
    public void union(int x1,int x2){
        int index1=findRoot(x1);
        int index2=findRoot(x2);

        if(index1==index2) return ; // 是同一个集合

        elem[index1]=elem[index1]+elem[index2];

        elem[index2]=index1;

    }

    /**
     * 有多少个集合
     * @return
     */
    public int getCount(){
        int count=0;

        for (int x :
                elem) {
            if(x<0) count++;
        }

        return count;
    }
}
