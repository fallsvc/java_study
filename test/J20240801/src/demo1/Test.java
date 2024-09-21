package demo1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/1  10:32
 */
public class Test {
    //合并有序数组

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //判空
        if(nums1==null){
            nums1=nums2;
            return;
        }
        //从后开始比较放元素
        int j=nums1.length-1;//从nums1的最后开始放元素
        int l1=m-1;//nums1的下标
        int l2=n-1;
        while(l1>=0&&l2>=0){
            if(nums1[l1]>nums2[l2]){
                nums1[j--]=nums1[l1];
                l1--;
            }else{
                nums1[j--]=nums2[l2];
                l2--;
            }
        }
        while(l2>=0){
            nums1[j--]=nums2[l2--];
        }
    }

    //删除数组元素

    public int removeElement(int[] nums, int val) {
        if(nums==null) return 0;
        //双指针
        int i=0;//前
        int j=0;//后
        int count=0;//返回不相等val个数
        while(i<nums.length){
            if(nums[i]!=val){
                count++;
                if(i!=j){
                    nums[j]=nums[i];
                }
                i++;
                j++;
            }else{
                i++;
            }
        }
        return count;
    }
    //删除相同元素

    public int removeDuplicates(int[] nums) {
        if(nums==null) return 0;
        int i=1;//前
        int j=0;//后
        int count=1;
        while(i<nums.length){
            if(nums[i]==nums[j]){
                i++;
            }else{
                nums[++j]=nums[i];
                count++;
            }
        }
        return count;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums==null) return 0;
        Set<Integer> set=new HashSet<>();
        int j=0;//遍历数组
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(!set.contains(val)){
                set.add(val);
                nums[j++]=val;
            }
        }
        return set.size();
    }

    public void mergeSort(int[] nums){
        merge(nums,0,nums.length-1);
        return;
    }

    //包含一半的元素

    public int majorityElement(int[] nums) {
        if(nums==null) return -1;
        mergeSort(nums);
        return nums[nums.length/2];
    }
    public void merge(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        merge(nums,start,mid);
        merge(nums,mid+1,end);
        //归并
        mergeS(nums,start,mid,end);
    }
    public void mergeS(int[] nums,int left,int mid,int right){
        int len=right-left+1;
        if(len<=1) return;
        int[] tmp=new int[len];
        int s1=left;
        int e1=mid;
        int s2=mid+1;
        int e2=right;
        int k=0;
        while(s1<=e1&&s2<=e2){
            if(nums[s1]<nums[s2]){
                tmp[k++]=nums[s1++];
            }else{
                tmp[k++]=nums[s2++];
            }
        }
        while(s1<=e1){
            tmp[k++]=nums[s1++];
        }
        while(s2<=e2){
            tmp[k++]=nums[s2++];
        }
        for(int i=0;i<k;i++){
            nums[left+i]=tmp[i];
        }
    }

    //
    public static int majorityElement2(int[] nums) {
        if(nums==null) return -1;
        Map<Integer,Integer> map=count(nums);
        Map.Entry<Integer,Integer> entry=null;
        for(Map.Entry<Integer,Integer> x:map.entrySet()){
            if(entry==null||entry.getValue()<x.getValue()){
                entry=x;
            }
        }
        return entry.getKey();
    }
    public static Map<Integer,Integer> count(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(map.get(val)==null){
                map.put(val,1);
            }else{
                int c=map.remove(val);
                map.put(val,c+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] arr={7,5,4,2,2,4,5};
        int ret=majorityElement2(arr);
        System.out.println(ret);
    }

}
