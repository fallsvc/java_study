package optimizationalgorithm.priorityqueue;

//import javafx.util.Pair;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/12  16:20
 */
public class Demo1 {
    class Solution1 {
        public static int lastStoneWeight(int[] stones) {
//          https://leetcode.cn/problems/last-stone-weight/
            //最后一块石头重量

            PriorityQueue<Integer> p=new PriorityQueue<>((s1,s2)->s2-s1);
//        PriorityQueue<Integer> p=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
            for(int x : stones) {
                p.offer(x);
            }
            while(p.size() > 1) {
                int a=p.poll();
                int b=p.poll();
                // 相减为0的不加入
                if(a>b) {
                    p.offer(a-b);
                }
            }
            return p.isEmpty()?0 : p.peek();
        }
    }
    class KthLargest {
//        https://leetcode.cn/problems/kth-largest-element-in-a-stream/
        // 数据流中第k大元素
        private PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();// 小根堆
        int _k;
        public KthLargest(int k, int[] nums) {
            int len=nums.length;
            _k=k;
            // k个元素入堆
            // 剩下的与堆顶比较入堆
            for(int x : nums) {
                priorityQueue.offer(x);
                if(priorityQueue.size()>k) {
                    priorityQueue.poll();
                }
            }
        }

        public int add(int val) {
            priorityQueue.offer(val);// 入堆

            if(priorityQueue.size() > _k) {
                priorityQueue.poll();
            }

            return priorityQueue.peek();
        }
    }

//    https://leetcode.cn/problems/top-k-frequent-words/submissions/629521488/
//    前k个高频词
//    public List<String> topKFrequent(String[] words, int k) {
//        // 1. 记录单词频率
//        Map<String,Integer> hash=new HashMap<>();
//        for(String x : words ) {
//            hash.put(x,hash.getOrDefault(x,0)+1);
//        }
//        // 2. 建堆
//        PriorityQueue<Pair<String,Integer>> priorityQueue=new PriorityQueue<Pair<String, Integer>>(
//                (a,b)->{
//                    if(a.getValue().equals(b.getValue())) {// 频次相同 大根堆
//                        return b.getKey().compareTo(a.getKey()); // 频次不同 小根堆
//                    }
//                    return a.getValue()-b.getValue();
//                }
//        );
//        for(Map.Entry<String,Integer> e : hash.entrySet()) {
//            priorityQueue.offer(new Pair<>(e.getKey(),e.getValue()));
//            if(priorityQueue.size()>k) {
//                priorityQueue.poll();
//            }
//        }
//        // 3. 出堆
//        List<String> list=new ArrayList<>();
//        while(!priorityQueue.isEmpty()) {
//            list.add(priorityQueue.poll().getKey());
//        }
//        Collections.reverse(list);// 逆序才是 最后结果
//        return list;
//    }

    public static void main(String[] args) {
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>();
        int[] arr=new int[]{2,7,4,1,8,1};
//        System.out.println(lastStoneWeight(arr));
        int mod= (int) (1e9 + 7);
        System.out.println(mod);
        List<Integer> list=new ArrayList<>();
        Queue<int[]> a=new LinkedList<>();

    }
    class MedianFinder {
//        https://leetcode.cn/problems/find-median-from-data-stream/submissions/629796301/
//        数据流中的中位数
//        使用大小堆来实现
        private PriorityQueue<Integer> maxHeap;// 记录最小一半 可能比小根堆多一个数据
        private PriorityQueue<Integer> minHeap;// 记录最大的一半数据

        private int maxHeapSize; // 记录堆大小
        private int minHeapSize;


        public MedianFinder() {
            maxHeap=new PriorityQueue<>((a,b)->b-a);
            minHeap=new PriorityQueue<>();

        }

        public void addNum(int num) {
            if(maxHeapSize==minHeapSize) {
                if(maxHeapSize==0 || num<maxHeap.peek()) {
                    maxHeap.offer(num);
                }else{
                    minHeap.offer(num);
                    Integer tmp=minHeap.poll();
                    maxHeap.offer(tmp);
                }
                maxHeapSize++;
            }else {
                if(maxHeap.peek()<num) {
                    minHeap.offer(num);
                }else {
                    maxHeap.offer(num);
                    Integer tmp=maxHeap.poll();
                    minHeap.offer(tmp);
                }
                minHeapSize++;
            }
        }

        public double findMedian() {
            if(minHeapSize==maxHeapSize) { // 偶数个数返回平均值
                return (maxHeap.peek()+minHeap.peek())/2.0;
            }else { // 奇数个数就直接返回中间值
                return maxHeap.peek()/1.0;
            }
        }
    }




}
