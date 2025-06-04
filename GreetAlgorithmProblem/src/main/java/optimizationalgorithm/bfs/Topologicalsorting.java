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
    public static void main2(String[] args) {
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

//    https://leetcode.cn/problems/Jf1JuT/submissions/634506720/
//    火星单词
    public static String alienOrder(String[] words) {
        Map<Character,Set<Character>> edgs=new HashMap<>();
        Map<Character,Integer> in=new HashMap<>();
        // 初始化，添加每一个字符 需要找到 入度为0的字符，然后添加到队列中进行拓扑排序的源点
        for(String x:words) {
            for(int i=0;i<x.length();i++) {
                in.put(x.charAt(i),0);
            }
        }

        // 添加边
        int n=words.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                for(int k=0;k<words[i].length();k++) {
                    if(k<words[j].length() && words[i].charAt(k)!=words[j].charAt(k)) {
                        char a=words[i].charAt(k),b=words[j].charAt(k);
                        Set<Character> s= edgs.getOrDefault(a,new HashSet<Character>());
                        if(!s.contains(b)) {
                            s.add(b);
                            edgs.put(a,s);
                            in.put(b,in.get(b)+1);
                        }
                        break;
                    }
                    // 前缀相同，但是长的字符串在前面 则不可能存在合理序列
                    if(k >= words[j].length()) return "";
                }
            }
        }
        // 拓扑排序
        Queue<Character> q=new ArrayDeque<>();
        StringBuilder s=new StringBuilder();// 返回值
        // 添加源点
        for (Character ch: in.keySet()) {
            if(in.get(ch) ==0) {
                q.add(ch);
            }
        }
        // 依次去源点，减相关边，添加新源点
        while(!q.isEmpty()) {
            Character ch=q.poll();
            s.append(ch);
            for(Character x: edgs.getOrDefault(ch,new HashSet<>())) {
                Integer num=in.get(x)-1;
                if(num==0) q.add(x);
                in.put(x,num);
            }
        }
        // 如果还存在字符没有排序成功，或者成顺序需求环，则不符合题目要求
        for(Integer x : in.values()) {
            if(x!=0) return "";
        }
        return s.toString(); // 返回值
    }

    public static void main(String[] args) {
        String[] s={"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(s));
//        Set<Character> s=new HashSet<>();
//        s.add('c');
//        s.add('a');
//        s.add('b');
//        for (char ch :
//                s) {
//            System.out.println(ch);
//        }
    }
}
