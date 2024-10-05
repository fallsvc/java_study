package graph;

import unionfindset.UnionFindSet;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/5  10:02
 */
public class GraphByMatrix {

    public char[] array;// 顶点数组
    public int[][] matrix;// 方向矩阵

    public boolean isDirect;// 是否有向

    /**
     * @param size     顶点个数
     * @param isDirect
     */
    public GraphByMatrix(int size, boolean isDirect) {
        array = new char[size];

        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], Constant.MAX);// 全赋值为无穷大
        }

        this.isDirect = isDirect;
    }

    public void initArray(char[] array) {

        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }

    }

    /**
     * @param srcV   起点
     * @param destV  终点
     * @param weight 权重
     */
    public boolean addEdge(char srcV, char destV, int weight) {
        // 找到下标
        int srcVIndex = getIndexOfV(srcV);
        int destVIndex = getIndexOfV(destV);
        if (srcVIndex == -1 || destVIndex == -1) return false;

        matrix[srcVIndex][destVIndex] = weight;
        // 无向图需要改双方
        if (isDirect == false) {
            matrix[destVIndex][srcVIndex] = weight;
        }

        return true;
    }

    private int getIndexOfV(char srcV) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == srcV) {
                return i;
            }
        }
        return -1;
    }

    public void printGraph() {
        System.out.print("  ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(" " + array[i]);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == Constant.MAX) {
                    System.out.print(" ∞");
                } else {
                    System.out.print(" " + matrix[i][j]);
                }
            }
            System.out.println();
        }

    }

    /**
     * 计算度
     */
    public int getDevOfV(char ch) {
        int chIndex = getIndexOfV(ch);
        int count = 0; // 计数

        for (int i = 0; i < matrix[chIndex].length; i++) {
            if (matrix[chIndex][i] != Constant.MAX) {
                count++;
            }
        }
        // 如果是有有向图
        if (isDirect == true) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][chIndex] != Constant.MAX) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 广度优先遍历
     */
    public void bfs(char v) {
        // 是否打印数组
        boolean[] visited = new boolean[array.length];

        // 创建队列放入需要打印元素
        Queue<Integer> queue = new LinkedList<>();
        int VIndex = getIndexOfV(v);
        queue.offer(VIndex);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            System.out.print(array[index] + "-> ");
            visited[index] = true;

            // 遍历该顶点行 找到存在路径的
            for (int i = 0; i < matrix[index].length; i++) {
                if (matrix[index][i] != Constant.MAX && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;// 放入为true 防止重复放入
                }
            }

        }

    }

    /**
     * 深度优先遍历
     *
     * @param v
     */
    public void dfs(char v) {
        int indexV = getIndexOfV(v);
        boolean[] visited = new boolean[array.length];

        dfsChild(indexV, visited);

    }

    private void dfsChild(int indexV, boolean[] visited) {
        System.out.print(array[indexV] + "-> ");
        visited[indexV] = true;

        for (int i = 0; i < matrix[indexV].length; i++) {
            if (matrix[indexV][i] != Constant.MAX && !visited[i]) {
                dfsChild(i, visited);
            }
        }
    }

    /**
     * 定义边
     */
    static class Edge {
        public int src;
        public int dest;
        public int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

    }

    /**
     * 最小生成树
     *
     * @param minTree
     */
    // Kruskal 克鲁斯卡尔算法 全局贪心
    public int kruskal(GraphByMatrix minTree) {
        // 1.创建小根堆 方便选取最小边
        Queue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        // 2.放入每条边
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j > i && matrix[i][j] != Constant.MAX) {
                    queue.offer(new Edge(i, j, matrix[i][j]));
                }
            }
        }
        // 3.选边然后 添加在最小生成树
        int n = array.length - 1;// 需要的边数
        int size = 0;
        int totalWeight = 0;
        // 创建并查集
        UnionFindSet unionFindSet = new UnionFindSet(array.length);
        while (size < n && !queue.isEmpty()) {
            Edge edge = queue.poll();
            int src = edge.src;
            int dest = edge.dest;
            int weight = edge.weight;
            if (!unionFindSet.isSameUnionFindSet(src, dest)) {
                minTree.addEdge(array[src], array[dest], weight);// 写入最小生成树

                totalWeight += weight;// 记录权值
                size++;
                unionFindSet.union(src, dest);//
            }
        }

        if (size == n) {
            return totalWeight;
        } else {
            return -1;
        }
    }

    public static void testGraphMinTree() {
        String str = "abcdefghi";
        char[] array = str.toCharArray();
        GraphByMatrix g = new GraphByMatrix(str.length(), false);
        g.initArray(array);
        g.addEdge('a', 'b', 4);
        g.addEdge('a', 'h', 8); //
        g.addEdge('a', 'h', 9);
        g.addEdge('b', 'c', 8);
        g.addEdge('b', 'h', 11);
        g.addEdge('c', 'i', 2);
        g.addEdge('c', 'f', 4);
        g.addEdge('c', 'd', 7);
        g.addEdge('d', 'f', 14);
        g.addEdge('d', 'e', 9);
        g.addEdge('e', 'f', 10);
        g.addEdge('f', 'g', 2);
        g.addEdge('g', 'h', 1);
        g.addEdge('g', 'i', 6);
        g.addEdge('h', 'i', 7);
        GraphByMatrix kminTree = new GraphByMatrix(str.length(), false);
        kminTree.initArray(array);
        System.out.println(g.kruskal(kminTree));
        kminTree.printGraph();
    }
}