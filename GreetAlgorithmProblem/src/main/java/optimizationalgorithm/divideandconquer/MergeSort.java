package optimizationalgorithm.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/18  14:34
 */
public class MergeSort {
    class Solution1 {
//        数组排序
//        https://leetcode.cn/problems/sort-an-array/
        int[] s;// 全局优化时间
        public int[] sortArray(int[] nums){
            s=new int[nums.length];
            mergeSort(nums,0,nums.length-1);

            return nums;
        }
        public void mergeSort(int[] nums,int left,int right){
            if(left>=right) return;
            // 1.中间点划分
            int mid=(right-left)/2+left;
            // 2.左右区间排序
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            // 3.合并两个有序数组
            merge(nums,left,mid,right);
        }
        public void merge(int[] nums,int left,int mid,int right){
            int s1=left,e1=mid;
            int s2=mid+1,e2=right;
            int i=0;
            while(s1<=e1&&s2<=e2)
                s[i++]=nums[s1]<nums[s2]?nums[s1++]:nums[s2++];

            // 还剩就赋值过来
            while(s1<=e1){
                s[i++]=nums[s1++];
            }
            while(s2<=e2){
                s[i++]=nums[s2++];
            }
            for(int j=0;j<right-left+1;j++){
                nums[j+left]=s[j];
            }
        }
    }

    class Solution2 {
//        https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
        // 逆序对  归并排序
        int[] s;
        public int reversePairs(int[] record) {
            s=new int[record.length];
            return mergeFind(record,0,record.length-1);
        }
        public int mergeFind(int[] record,int left,int right){
            if(left>=right) return 0;
            int mid=(right-left)/2+left;

            return mergeFind(record,left,mid)+mergeFind(record,mid+1,right)+merge(record,left,mid,right);
        }
        public int merge(int[] record,int left,int mid,int right){

            int s1=left,s2=mid+1;
            // 1.求逆序对
            int ret=0;
            // 2.排序
            int k=0;
            while(s1<=mid&&s2<=right){
                if(record[s1]<=record[s2]){
                    s[k++]=record[s1++];
                }else{
                    ret+=mid-s1+1;
                    s[k++]=record[s2++];
                }
            }

            while(s1<=mid) s[k++]=record[s1++];
            while(s2<=right) s[k++]=record[s2++];
            k=0;
            while(left<=right){
                record[left++]=s[k++];
            }

            return ret;
        }
    }

    public static void main1(String[] args) {
        int[] a={1,2};
        Integer[] s={1,2};
        List<Integer> list=new ArrayList<>();
    }
    class Solution3 {
//        右侧小于当前元素
        int[] numsTmp;
        int[] index;
        int[] indexTmp;
        int[] ret;
        public List<Integer> countSmaller(int[] nums) {
            int n=nums.length;
            ret=new int[n];
            numsTmp=new int[n];
            indexTmp=new int[n];
            index=new int[n];
            for(int i=0;i<n;i++){
                index[i]=i;
            }
            mergeSort(nums,0,n-1);
            List<Integer> list=new ArrayList<>();
            for(int x:ret){
                list.add(x);
            }
            return list;
        }
        public void mergeSort(int[] nums,int left,int right){
            if(left>=right) return;
            int mid=(right-left)/2+left;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            // 排序
            int s1=left,s2=mid+1;
            int k=0;
            while(s1<=mid&&s2<=right){
                if(nums[s1]<=nums[s2]){
                    numsTmp[k]=nums[s2];
                    indexTmp[k]=index[s2];
                    s2++;
                }else{
                    ret[index[s1]]+=(right-s2+1);
                    numsTmp[k]=nums[s1];
                    indexTmp[k]=index[s1];
                    s1++;
                }
                k++;
            }
            while(s1<=mid){
                numsTmp[k]=nums[s1];
                indexTmp[k]=index[s1];
                s1++;
                k++;
            }
            while(s2<=right){
                numsTmp[k]=nums[s2];
                indexTmp[k]=index[s2];
                s2++;
                k++;
            }
            for(int i=left;i<=right;i++){
                nums[i]=numsTmp[i-left];
                index[i]=indexTmp[i-left];
            }
        }
    }

    class Solution4 {
//        https://leetcode.cn/problems/reverse-pairs/
//        类似逆序对，但是需要单独求值
        int[] tmpNum;
        public int reversePairs(int[] nums) {
            int n=nums.length;
            tmpNum=new int[n];
            return mergeSort(nums,0,n-1);
        }
        // 升序排序
        public int mergeSort(int[] nums,int left,int right){
            if(left>=right) return 0;
            int mid=(right-left)/2+left;
            int l=mergeSort(nums,left,mid);
            int r=mergeSort(nums,mid+1,right);
            int s1=left,s2=mid+1;
            int ret=0,k=0;//计算返回值
            while(s1<=mid&&s2<=right){
                if((long)nums[s1]>(long)nums[s2]*2){
                    ret+=(mid-s1+1);
                    s2++;
                }else{
                    s1++;
                }
            }
            // 排序
            s1=left;
            s2=mid+1;
            while(s1<=mid&&s2<=right){
                if(nums[s1]>nums[s2]){
                    tmpNum[k++]=nums[s2++];
                }else{
                    tmpNum[k++]=nums[s1++];
                }
            }
            while(s1<=mid){
                tmpNum[k++]=nums[s1++];
            }
            while(s2<=right){
                tmpNum[k++]=nums[s2++];
            }
            //
            for(int i=left;i<=right;i++){
                nums[i]=tmpNum[i-left];
            }
            return r+l+ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(-3/2);
        System.out.println(-3/2.0);
        System.out.println(-1%2);
        System.out.println(-3%2.0);
    }
}
