package optimizationalgorithm.bfs;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/6/3  14:46
 */
public class Topologicalsorting {

    class Solution1 {
//        https://leetcode.cn/problems/course-schedule/
//        课程表
        public boolean canFinish(int n, int[][] p) {

            Map<Integer,List<Integer>> map=new HashMap<>();
            int[] in=new int[n]; // 入度

            // 邻接表存储边
            // in存储入度
            for(int i=0;i<p.length;i++) {
                int a=p[i][0],b=p[i][1];
                in[a]++;
                List<Integer> t=map.getOrDefault(b,new ArrayList<Integer>());
                t.add(a);
                map.put(b,t);
            }
            Queue<Integer> q=new ArrayDeque<>();
            // 加入起始节点
            for(int i=0;i<n;i++) {
                // 没有入度
                if(in[i] == 0) {
                    q.add(i);

                }
            }

            while(!q.isEmpty()) {
                int size=q.size();
                while(size--!=0) {
                    Integer src=q.poll();
                    List<Integer> t=map.get(src);
                    if(t!=null) {
                        for(Integer x: t) {
                            in[x]--;
                            if(in[x] == 0) {
                                q.add(x); // 入度为0加入队列
                            }
                        }
                    }

                    // 清除这个节点和 相关边
                    map.remove(src);
                }
            }

            return map.isEmpty();
        }
    }

    class Solution2 {
//        https://leetcode.cn/problems/course-schedule-ii/
//          课程表二
//不太需要k-v 映射 可以采用链表
        public int[] findOrder(int n, int[][] p) {
            List<List<Integer>> map=new ArrayList<>();
            int[] in=new int[n];
            for(int i=0;i<n;i++) map.add(new ArrayList<Integer>());
            // 加入边，计算入度
            for(int[] x: p) {
                int a=x[0],b=x[1];
                in[a]++;
                map.get(b).add(a);
            }
            //
            Queue<Integer> q=new ArrayDeque<>();

            for(int i=0;i<n;i++) {
                if(in[i]==0) {
                    q.add(i);
                }
            }
            // 选课
            int[] ret=new int[n];
            int k=0;
            while(!q.isEmpty()) {
                int sel=q.poll();
                ret[k++]=sel;
                for(Integer x : map.get(sel)) {
                    in[x]--;
                    if(in[x]==0) q.add(x);
                }
            }

            for(int x:in) {
                if(x!=0) return new int[0] ;
            }

            return ret;

        }
//      public int[] findOrder(int n, int[][] p) {
//                        Map<Integer,List<Integer>> map=new HashMap<>();
//                        int[] in=new int[n];
//                        // 加入边，计算入度
//                        for(int[] x: p) {
//                            int a=x[0],b=x[1];
//                            in[a]++;
//                            List<Integer> t=map.getOrDefault(b,new ArrayList<Integer>());
//                            t.add(a);
//                            map.put(b,t);
//                        }
//                        //
//                        Queue<Integer> q=new ArrayDeque<>();
//
//                        for(int i=0;i<n;i++) {
//                            if(in[i]==0) {
//                                q.add(i);
//                }
//            }
//            // 选课
//            int[] ret=new int[n];
//            int k=0;
//            while(!q.isEmpty()) {
//                int sel=q.poll();
//                ret[k++]=sel;
//                for(Integer x : map.getOrDefault(sel,new ArrayList<Integer>())) {
//                    in[x]--;
//                    if(in[x]==0) q.add(x);
//                }
//            }
//
//            for(int x:in) {
//                if(x!=0) return new int[0] ;
//            }
//
//            return ret;
//
//        }
    }
    public static void main(String[] args) {
        int[][] a=new int[][]{{1,0},{0,1}};
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);

        l.toArray(new Integer[0]);
    }
    public static void main1(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for (Integer x :
                list) {
            
        }
    }
}
