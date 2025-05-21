package practice5;


import java.util.*;

class Node implements Comparable<Node> {
    List<Integer> path;     // 当前路径
    int cost;               // 当前路径长度
    double bound;           // 下界值
    Set<Integer> visited;   // 已访问的城市集合

    public Node(List<Integer> path, int cost, double bound, Set<Integer> visited) {
        this.path = new ArrayList<>(path);
        this.cost = cost;
        this.bound = bound;
        this.visited = new HashSet<>(visited);
    }

    @Override
    public int compareTo(Node other) {
        // 优先队列按节点的下界值升序排列
        return Double.compare(this.bound, other.bound);
    }
}

public class TSPBranchAndBound {
    private static int[][] graph;    // 邻接矩阵
    private static int n;            // 城市数量
    private static int bestCost = Integer.MAX_VALUE; // 当前最优解

    public static void main(String[] args) {
        // 示例边界测试
        graph = new int[][]{
                {0, 5, 5},
                {5, 0, 5},
                {5, 5, 0}
        };

        n = graph.length;

        solveTSP();
        System.out.println("Optimal Path Cost: " + bestCost);
    }

    public static void solveTSP() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> initialVisited = new HashSet<>();
        initialVisited.add(0); // 起点为城市0

        // 计算根节点的下界
        double initialBound = calculateBound(Collections.singletonList(0), initialVisited);
        pq.add(new Node(Collections.singletonList(0), 0, initialBound, initialVisited));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            // 剪枝：当前节点的下界已不优于已知最优解
            if (currentNode.bound >= bestCost) continue;

            // 所有城市已访问，计算回到起点的总成本
            if (currentNode.visited.size() == n) {
                int totalCost = currentNode.cost + graph[currentNode.path.get(currentNode.path.size() - 1)][0];
                if (totalCost < bestCost) {
                    bestCost = totalCost;
                }
                continue;
            }

            // 扩展子节点：尝试访问下一个未访问的城市
            for (int nextCity = 0; nextCity < n; nextCity++) {
                if (!currentNode.visited.contains(nextCity)) {
                    List<Integer> newPath = new ArrayList<>(currentNode.path);
                    newPath.add(nextCity);

                    int newCost = currentNode.cost + graph[currentNode.path.get(currentNode.path.size() - 1)][nextCity];
                    Set<Integer> newVisited = new HashSet<>(currentNode.visited);
                    newVisited.add(nextCity);

                    double newBound = calculateBound(newPath, newVisited);

                    // 剪枝：仅当下界可能更优时加入队列
                    if (newBound < bestCost) {
                        pq.add(new Node(newPath, newCost, newBound, newVisited));
                    }
                }
            }
        }
    }

    // 计算下界：当前路径长度 + 剩余路径的最小估计
    private static double calculateBound(List<Integer> path, Set<Integer> visited) {
        int currentCost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            currentCost += graph[path.get(i)][path.get(i + 1)];
        }

        // 剩余未访问城市的最小生成树（MST）权重
        double mstWeight = calculateMST(visited);
        return currentCost + mstWeight;
    }

    // 计算剩余未访问城市的最小生成树（Prim算法）
    private static double calculateMST(Set<Integer> visited) {
        List<Integer> unvisited = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) unvisited.add(i);
        }

        if (unvisited.isEmpty()) return 0;

        // Prim算法计算MST
        double[] minEdge = new double[unvisited.size()];
        Arrays.fill(minEdge, Double.MAX_VALUE);
        boolean[] inMST = new boolean[unvisited.size()];
        minEdge[0] = 0;

        for (int i = 0; i < unvisited.size() - 1; i++) {
            int u = -1;
            for (int j = 0; j < unvisited.size(); j++) {
                if (!inMST[j] && (u == -1 || minEdge[j] < minEdge[u])) {
                    u = j;
                }
            }

            inMST[u] = true;
            for (int v = 0; v < unvisited.size(); v++) {
                if (!inMST[v] && graph[unvisited.get(u)][unvisited.get(v)] < minEdge[v]) {
                    minEdge[v] = graph[unvisited.get(u)][unvisited.get(v)];
                }
            }
        }

        double mstWeight = 0;
        for (double edge : minEdge) {
            mstWeight += edge;
        }
        return mstWeight;
    }
}