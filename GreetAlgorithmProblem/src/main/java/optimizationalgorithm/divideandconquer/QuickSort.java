package optimizationalgorithm.divideandconquer;

import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/15  17:37
 */
public class QuickSort {
    class Solution1 {
//        /
        // https://leetcode.cn/problems/sort-colors/
        //        颜色分类
//       采用三指针法

        public void sortColors(int[] nums) {
            // [0-left] 为0区间  [left+1,i-1] 1区间 [right,len-1] 2区间
            int left=-1,i=0,right=nums.length;
            while(i<right){
                if(nums[i]==0){
                    swap(nums,i++,++left);
                }else if(nums[i]==1){
                    i++;
                }else{
                    swap(nums,i,--right);
                }
            }
        }
        public void swap(int[] nums,int i,int j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
    class Solution2 {
//        https://leetcode.cn/problems/sort-an-array/
        // 数组排序，三指针 （颜色划分） + 随机中间值
        public int[] sortArray(int[] nums) {
            quickSort(nums,-1,nums.length);
            return nums;
        }
        //[0-left] 为<val区间  [left+1,i-1] val区间 [right,len-1] >val区间

        public void quickSort(int[] nums,int left1,int right1){
            int left=left1,right=right1;
            if(left+1>=right) return;

            int val=nums[new Random().nextInt(right-left-1)+left+1];

            int i=left+1;
            while(i<right){
                if(nums[i]<val){
                    swap(nums,++left,i++);
                }else if(nums[i]==val){
                    i++;
                }else{
                    swap(nums,--right,i);
                }
            }
            quickSort(nums,left1,left+1);
            quickSort(nums,right-1,right1);
        }
        public void swap(int[] nums,int i,int j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }


    }

    public static void main1(String[] args) {
//        System.out.println(Solution2.randomNum(1));
//        Random random=new Random();
//        System.out.println(random.nextInt(2));
    }

    class Solution3 {
//        https://leetcode.cn/problems/kth-largest-element-in-an-array/
        // 找第k个最大值
        // 快速排序 分三块 + 随机取中间值
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums,0,nums.length-1,k);
        }

        public int quickSort(int[] nums,int l,int r,int k){
            if(l==r) return nums[l]; // 只剩一个数了就是找的数
            int val=nums[new Random().nextInt(r-l+1)+l];// 随机取中间值
            // 三指针 分三块
            int left=l-1,right=r+1,i=l;
            while(i<right){
                if(nums[i]<val)
                    swap(nums,++left,i++);
                else if(nums[i]==val) i++;
                else swap(nums,--right,i);
            }

            // 寻找返回值
            if(r-right+1>=k) return quickSort(nums,right,r,k);
            else if(r-left>=k) return nums[left+1];
            else return quickSort(nums,l,left,k-(r-left));

        }

        public void swap(int[] nums,int i,int j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
    public static void main(String[] args) {
//        Solution3 solution3=new Solution3();
        int[] nums={3,2,3,1,2,4,5,5,6};
//        System.out.println(solution3.findKthLargest(nums, 4));
    }

    class Solution4 {
//        https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
        // 找前k个最小值
        public int[] inventoryManagement(int[] stock, int cnt) {
            quickSort(stock,0,stock.length-1,cnt);// 排序到需要长度
            // 创建放回数组
            int[] ret=new int[cnt];
            for(int i=0;i<cnt;i++){
                ret[i]=stock[i];
            }
            return ret;
        }
        // 三块划分排序
        public void quickSort(int[] nums,int l,int r,int k){
            if(l>=r) return;

            int left=l-1,i=l,right=r+1;
            int val=nums[new Random().nextInt(r-l+1)+l];
            while(i<right){
                if(nums[i]<val)
                    swap(nums,++left,i++);
                else if(nums[i]==val) i++;
                else swap(nums,--right,i);
            }

//          在长度合适时返回
            if(left-l+1>k) quickSort(nums,l,left,k);
            else if(right-l>=k) return;
            else quickSort(nums,right,r,k-(right-l));
        }
        public void swap(int[] nums,int i,int j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
}
