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

    // Prime 普利姆算法 局部贪心
    // 天然没有环  一个集合到另一个集合

    /**
     *
     * @param minTree 最小生成树
     * @param chV 起点
     * @return
     */
    public int prime(GraphByMatrix minTree,char chV){
        int indexV=getIndexOfV(chV);// 获取顶点下标
        
        Set<Integer> setSrc=new HashSet<>();// 放入起点
        setSrc.add(indexV);
        // 放入终点下标
        Set<Integer> setDest=new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(i!=chV){
                setDest.add(i);
            }
        }
        // 建立小根堆
        Queue<Edge> queue=new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        // 放入起点到终点的边
        for (int i = 0; i < matrix[indexV].length; i++) {
            if(matrix[indexV][i]!=Constant.MAX){
                queue.add(new Edge(indexV,i,matrix[indexV][i]));
            }
        }

        int totalWeight=0;
        int edgeCount=0;
        while(!queue.isEmpty()){
            Edge edge=queue.poll();
            int srcIndex=edge.src;
            int destIndex=edge.dest;
            int weight=edge.weight;
            if(setSrc.contains(destIndex)){
                // 成环
            }else{
                minTree.addEdge(array[srcIndex],array[destIndex],weight);// 加入边
                System.out.println(array[srcIndex]+"->"+array[destIndex]+"="+weight);
                totalWeight+=weight;
                edgeCount++;
                if(edgeCount==array.length-1) return totalWeight;
                // 更新集合
                setSrc.add(destIndex);
                setDest.remove(destIndex);
                // 加入边
                for (int i = 0; i < matrix[destIndex].length; i++) {
                    if(!setSrc.contains(i)&&matrix[destIndex][i]!=Constant.MAX){
                        queue.add(new Edge(destIndex,i,matrix[destIndex][i]));
                    }
                }
            }
        }
        return -1;
    }
    /**
     * 迪杰斯特拉算法
     * @param vSrc 指定起点
     * @param dist 路径最小权值
     * @param pPath 路径
     */
   public void dijkstra(char vSrc,int[] dist,int[] pPath){
        int srcIndex=getIndexOfV(vSrc);
        // 距离数组初始化
       Arrays.fill(dist,Constant.MAX);
       dist[srcIndex]=0;
       // 路径数组初始化
       Arrays.fill(pPath,-1);
       pPath[srcIndex]=srcIndex;
       // 当前节点是否被访问
       int n=array.length;
       boolean[] s=new boolean[n];

       // n个顶点，更新n次 从0下标开始找最小
       for (int k = 0; k<n ; k++) {
           int min=Constant.MAX;
           int u=srcIndex;
           for (int i = 0; i < n; i++) {
               if(s[i]==false && dist[i]<min){
                   min=dist[i];
                   u=i;// 更新下标
               }
           }
           s[u]=true;
           // 松弛u连接出去的所有节点
           for (int v = 0; v < n; v++) {
               if(s[v]==false&&matrix[u][v]!=Constant.MAX
               && dist[u]+matrix[u][v]<dist[v]){
                    dist[v]=dist[u]+matrix[u][v];
                    pPath[v]=u;// 更新当前路径
               }
           }
       }
   }
    public void printShortPath(char srcV,int[] dist,int[] pPath){
       // 获取下标
       int srcIndex=getIndexOfV(srcV);
       int n=array.length;

       // 遍历pPath每一个值
        for (int i = 0; i < n; i++) {
            if(i!=srcIndex){
                ArrayList<Integer> arrayList=new ArrayList<>();
                int parent=i;
                // 倒序添加路径
                while(parent!=srcIndex){
                    arrayList.add(parent);
                    parent=pPath[parent];
                }
                arrayList.add(srcIndex);

                Collections.reverse(arrayList);

                for (int x:arrayList) {
                    System.out.print(array[x]+"->");
                }
                System.out.println(dist[i]);
            }

        }
    }

    /***
     * 贝尔福德曼算法  暴力遍历算法
     * @param vSrc
     * @param dist
     * @param pPath
     * @return
     */
    public boolean bellmanFord(char vSrc,int[] dist,int[] pPath) {
        //1. 获取顶点下标 
        int srcIndex = getIndexOfV(vSrc); 
        //2、初始化父顶点数组下标为-1
         Arrays.fill(pPath,-1); 
        // 3、初始化dist数组
         Arrays.fill(dist,Integer.MAX_VALUE); 
        // 4、对起点进行初始化,给一个最小值 方便第一次就能找到最小值
        dist[srcIndex] = 0;
        int n = array.length;
        
        // 暴力遍历
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j]!=Constant.MAX&&
                        dist[i]+matrix[i][j]<dist[j]){
                        dist[j]=dist[i]+matrix[i][j];
                        pPath[j]=i;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != Constant.MAX &&
                        dist[i] + matrix[i][j] < dist[j]) {
                    // 存在回路
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 弗洛伊德算法
     * @param dist
     * @param pPath
     */
    public void floydWarShall(int[][] dist,int[][] pPath) {
        int n=array.length;

        // 初始化两个数组
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],Constant.MAX);
            Arrays.fill(pPath[i],-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != Constant.MAX) {
                    dist[i][j] = matrix[i][j];
                    pPath[i][j] = i;
                } else {
                    pPath[i][j] = -1;// 不存在直接相连
                }

                if (i == j) {
                    dist[i][j]=0;
                    pPath[i][j]=-1;

                }
            }
        }
        // 以每个节点为中转点进行选择路径
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k]!=Constant.MAX&&dist[k][j]!=Constant.MAX
                    &&dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                        pPath[i][j]=pPath[k][j];
                    }
                }
            }
        }

    }
}