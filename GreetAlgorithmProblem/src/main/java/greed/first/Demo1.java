package greed.first;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/19  16:06
 */
public class Demo1 {
    class Solution1 {
//        https://leetcode.cn/problems/lemonade-change/
//        柠檬水找零
        public boolean lemonadeChange(int[] bills) {
            int five=0,ten=0;
            for(int i=0;i<bills.length;i++) {
                if(bills[i] == 5) {
                    five++;
                }else if (bills[i]==10) {
                    if(five == 0) return false;

                    ten++;
                    five--;
                }else {//20
                    if(ten != 0 && five != 0) {
                        ten--;
                        five--;
                    }else if(five >= 3) {
                        five-=3;
                    }else {
                        return false; // 没有找钱方案
                    }
                }
            }
            return true;
        }
    }

    public static void main1(String[] args) {
        PriorityQueue<Double> priorityQueue=new PriorityQueue<>();
        priorityQueue.offer(1.0);
        priorityQueue.offer(2.0);
        System.out.println(priorityQueue.poll());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(10);
        stringBuilder.append(10);
        stringBuilder.append('a');
        System.out.println(stringBuilder.toString());


    }

    class Solution2 {
//        https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
//        将数组和减半的最小操作次数

        public int halveArray(int[] nums) {
            PriorityQueue<Double> p=new PriorityQueue<>((a,b)->b.compareTo(a));// 大根堆

            // 入堆 并计算总和
            double sum=0.0;
            for(int x:nums) {
                sum+=x;
                p.offer((double)x);
            }
            double sub=sum/2.0;
            int count=0;
            while(sub > 0) {
                double t=p.poll()/2.0;
                sub-=t;
                count++;
                p.offer(t);
            }
            return count;
        }
    }
    class Solution3 {
//        https://leetcode.cn/problems/largest-number/
//        最大数
        public String largestNumber(int[] nums) {
            Integer[] arr=new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i]=nums[i];
            }

            Arrays.sort(arr ,(a,b)->{
                StringBuilder s1=new StringBuilder();
                StringBuilder s2=new StringBuilder();
                s1.append(a);
                s1.append(b);
                s2.append(b);
                s2.append(a);

                if(s1.compareTo(s2)>0) {
                    return -1;
                }else {
                    return 1;
                }
            });
            StringBuilder s=new StringBuilder();
            for(int x: arr) {
                s.append(x);
            }
            if (s.charAt(0)=='0') return "0";
            return s.toString();
        }
    }
    class Solution4 {
//        https://leetcode.cn/problems/wiggle-subsequence/
//        摆动数字
        public int wiggleMaxLength(int[] nums) {
            int n=nums.length;
            if(n<2) return n;

            int left=0; // left>0 左边递增
            int count=0;// 两端点

            // 统计波峰和波谷
            for(int i=0;i<n-1;i++) {
                int right=nums[i+1]-nums[i];
                if(right==0) continue;
                if(left*right<=0) {
                    count++;
                    left=right;
                }
            }

            return count+1;
        }
    }

    class Solution5 {
//        https://leetcode.cn/problems/longest-increasing-subsequence/
//        最长递增子序列      贪心
        public int lengthOfLIS(int[] nums) {
            List<Integer> ret = new ArrayList<>();
            ret.add(nums[0]);

            for (int i = 1; i < nums.length; i++) {
                int n = ret.size() - 1;
                if (nums[i] > ret.get(n)) ret.add(nums[i]);// 可以添加到最后面形成递增子序列
                else { // 找到插入位置
                    int left = 0, right = n;
                    while (left < right) {
                        int mid = (right - left) / 2 + left;
                        if (nums[i] > ret.get(mid)) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    ret.set(left, nums[i]);
                }


            }

            return ret.size();
        }
    }

    class Solution6 {
//        https://leetcode.cn/problems/increasing-triplet-subsequence/description/
//        递增三元子序列
        public boolean increasingTriplet(int[] nums) {

            int a=nums[0],b=Integer.MAX_VALUE;
            for(int i=1;i<nums.length;i++) {
                if(nums[i]>b) return true;
                else if(nums[i]>a) b=nums[i];
                else a=nums[i];
            }

            return false;
        }
    }
    public static void main(String[] args) {
        int[] arr={2,1,5,0,4,6};

    }
}
