package optimizationalgorithm.bfs;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/5/26  14:35
 */
public class Demo2 {
    class Solution1 {
//        https://leetcode.cn/problems/word-ladder/
//        单词接龙
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int n=beginWord.length();

            Set<String> words=new HashSet<>();// 字典
            Set<String> used=new HashSet<>();// 遍历过
            for(String x:wordList) {
                words.add(x);
            }
            Queue<String> q=new ArrayDeque<>();
            q.offer(beginWord);
            used.add(beginWord);
            int count=1;

            while(!q.isEmpty()) {
                count++;
                int size=q.size();
                for(int i=0;i<size;i++) {
                    String t=q.poll();
                    for(int j=0;j<n;j++) {
                        char[] tmp=t.toCharArray();
                        for(char ch='a';ch<='z';ch++) {
                            tmp[j]=ch;
                            String newT=new String(tmp);
                            if(words.contains(newT) && !used.contains(newT)) {
                                if(newT.equals(endWord)) return count;
                                q.offer(newT);
                                used.add(newT);
                            }
                        }
                    }


                }
            }
            return 0;
        }
    }
    class Solution2 {
//        https://leetcode.cn/problems/cut-off-trees-for-golf-event/
//        按树高砍树
        int m;
        int n;
        public int cutOffTree(List<List<Integer>> forest) {
            m=forest.size();
            n=forest.get(0).size();
            // 确定砍树顺序
            List<int[]> trees=new ArrayList<>();
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(forest.get(i).get(j)>1) {
                        trees.add(new int[]{i,j});
                    }
                }
            }
            Collections.sort(trees,(a,b)->{
                return forest.get(a[0]).get(a[1])-forest.get(b[0]).get(b[1]);
            });

//      按排序顺序砍树
            int ret=0;
            int bx=0,by=0;
            for(int[] tree: trees) {
                int x =tree[0],y=tree[1];
                int step=bfs(bx,by,x,y,forest);
                if(step == -1) return -1;
                bx=x;
                by=y;
                ret+=step;
            }

            return ret;
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        public int bfs(int bx,int by, int x,int y,List<List<Integer>> forest) {
            if(bx == x && by == y) return 0;

            boolean[][] vis=new boolean[m][n];
            Queue<int[]> q=new ArrayDeque<>();
            q.add(new int[]{bx,by});
            vis[bx][by]=true;

            int step=0;

            while (!q.isEmpty()) {
                step++;
                int size = q.size();
                while(size-- != 0) {
                    int[] t=q.poll();

                    for(int k = 0; k < 4;k++) {
                        int tx = dx[k]+t[0],ty = dy[k]+t[1];

                        if(tx >= 0 && tx < m && ty >= 0&& ty < n &&forest.get(tx).get(ty)!=0&&vis[tx][ty]==false) {
                            if(tx==x&&ty==y) return step;
                            q.add(new int[]{tx,ty});
                            vis[tx][ty]=true;
                        }
                    }
                }
            }
            return -1;
        }
    }

//    static int m;
//   static int n;
//    public static int cutOffTree(List<List<Integer>> forest) {
//        m=forest.size();
//        n=forest.get(0).size();
//        // 确定砍树顺序
//        List<int[]> trees=new ArrayList<>();
//        for(int i=0;i<m;i++) {
//            for(int j=0;j<n;j++) {
//                if(forest.get(i).get(j)>1) {
//                    trees.add(new int[]{i,j});
//                }
//            }
//        }
//        Collections.sort(trees,(a,b)->{
//            return forest.get(a[0]).get(a[1])-forest.get(b[0]).get(b[1]);
//        });
//
////      按排序顺序砍树
//        int ret=0;
//        int bx=0,by=0;
//        for(int[] tree: trees) {
//            int x =tree[0],y=tree[1];
//            int step=bfs(bx,by,x,y,forest);
//            if(step == -1) return -1;
//            bx=x;
//            by=y;
//            ret+=step;
//        }
//
//        return ret;
//    }
//
//
//    static int[] dx={0,0,-1,1};
//    static int[] dy={-1,1,0,0};
//    public static int bfs(int bx,int by, int x,int y,List<List<Integer>> forest) {
//        if(bx==x&&by==y) return 0;
//
//        boolean[][] vis=new boolean[m][n];
//        Queue<int[]> q=new ArrayDeque<>();
//        q.add(new int[]{bx,by});
//        vis[bx][by]=true;
//
//        int step=-1;
//
//        while(!q.isEmpty()) {
//            step++;
//            int size=q.size();
//            while(size--!=0) {
//                int[] t=q.poll();
//                if(t[0]==x&&t[1]==y) return step;
//                for(int k=0;k<4;k++) {
//                    int tx=dx[k]+t[0],ty=dy[k]+t[1];
//
//                    if(tx>=0&&tx<m&&ty>=0&&ty<n&&forest.get(tx).get(ty)!=0&&vis[tx][ty]==false) {
//                        q.add(new int[]{tx,ty});
//                        vis[tx][ty]=true;
//                    }
//                }
//            }
//        }
//        return -1;
//    }
    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        t.add(1);
        t.add(2);
        t.add(3);
        list.add(t);
        int[] a={0,0,4};
        list.add(Arrays.asList(0,0,4));
        list.add(Arrays.asList(7,6,5));
//        System.out.println(cutOffTree(list));
        t.set(1,3);
        System.out.println(t);
    }
}
