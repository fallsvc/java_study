package optimizationalgorithm.divideandconquer;

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
}
