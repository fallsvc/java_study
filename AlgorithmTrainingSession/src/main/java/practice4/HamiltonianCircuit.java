package practice4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamiltonianCircuit {
    private static final int INF = Integer.MAX_VALUE;
    private int n; // 顶点数量
    private int[][] cost; // 成本矩阵
    private boolean[] visited; // 标记数组，记录顶点是否访问过
    private List<Integer> path; // 当前路径
    private int minCost; // 最小成本
    private List<Integer> bestPath; // 最优路径

    public HamiltonianCircuit(int[][] cost) {
        this.cost = cost;
        this.n = cost.length;
        this.visited = new boolean[n];
        this.path = new ArrayList<>();
        this.minCost = INF;
        this.bestPath = new ArrayList<>();
    }

    // 回溯法求解哈密尔顿回路
    public void findHamiltonianCircuit() {
        visited[0] = true; // 从顶点0开始
        path.add(0); // 将顶点0加入路径
        backtracking(0, 0); // 开始回溯
        visited[0] = false; // 回溯后恢复状态
        path.remove(path.size() - 1); // 移除路径中的顶点0
    }

    private void backtracking(int current, int currentCost) {
        if (path.size() == n && cost[current][0] != INF) { // 如果路径包含所有顶点且可以回到起点
            int totalCost = currentCost + cost[current][0]; // 计算总成本
            if (totalCost < minCost) { // 如果找到更小的成本
                minCost = totalCost;
                bestPath = new ArrayList<>(path); // 更新最优路径
            }
            return;
        }

        for (int next = 0; next < n; next++) { // 遍历所有顶点
            if (!visited[next] && cost[current][next] != INF) { // 如果顶点未访问且存在边
                visited[next] = true; // 标记为已访问
                path.add(next); // 将顶点加入路径
                backtracking(next, currentCost + cost[current][next]); // 递归回溯
                visited[next] = false; // 回溯后恢复状态
                path.remove(path.size() - 1); // 移除路径中的顶点
            }
        }
    }

    public void printResult() {
        if (minCost == INF) {
            System.out.println("No Hamiltonian Circuit exists.");
        } else {
            System.out.println("Minimum Cost: " + minCost);
            System.out.print("Path: ");
            for (int v : bestPath) {
                System.out.print(v + " ");
            }
            System.out.println("0");
        }
    }

    public static void main1(String[] args) {
        // 示例成本矩阵
        int[][] cost = {
            {0, 29, 20, 21},
            {29, 0, 15, 17},
            {20, 15, 0, 28},
            {21, 17, 28, 0}
        };

        HamiltonianCircuit hc = new HamiltonianCircuit(cost);
        hc.findHamiltonianCircuit();
        hc.printResult();
    }

        public static void main(String[] args) {
            // 测试用例1：简单图
            int[][] cost1 = {
                    {0, 29, 20, 21},
                    {29, 0, 15, 17},
                    {20, 15, 0, 28},
                    {21, 17, 28, 0}
            };
            testHamiltonianCircuit(cost1);

            // 测试用例2：无解的情况
            int[][] cost2 = {
                    {0, 1, 1, 0},
                    {1, 0, 1, 0},
                    {1, 1, 0, 0},
                    {0, 0, 0, 0}
            };
            testHamiltonianCircuit(cost2);

            // 测试用例3：大规模图
            int[][] cost3 = {
                    {0, 10, 15, 20, 25},
                    {10, 0, 35, 25, 30},
                    {15, 35, 0, 30, 10},
                    {20, 25, 30, 0, 15},
                    {25, 30, 10, 15, 0}
            };
            testHamiltonianCircuit(cost3);

            // 测试用例4：包含不连通顶点的图
            int[][] cost4 = {
                    {0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE},
                    {10, 0, 20, 30},
                    {Integer.MAX_VALUE, 20, 0, 10},
                    {Integer.MAX_VALUE, 30, 10, 0}
            };
            testHamiltonianCircuit(cost4);

            // 测试用例5：完全图
            int[][] cost5 = {
                    {0, 1, 1},
                    {1, 0, 1},
                    {1, 1, 0}
            };
            testHamiltonianCircuit(cost5);

            // 测试用例6：特殊情况（所有边权重相同）
            int[][] cost6 = {
                    {0, 1, 1, 1},
                    {1, 0, 1, 1},
                    {1, 1, 0, 1},
                    {1, 1, 1, 0}
            };
            testHamiltonianCircuit(cost6);

            // 测试用例7：大规模图（顶点数较多）
            int[][] cost7 = {
                    {0, 10, 20, 30, 40, 50},
                    {10, 0, 25, 35, 45, 55},
                    {20, 25, 0, 30, 40, 50},
                    {30, 35, 30, 0, 40, 50},
                    {40, 45, 40, 40, 0, 50},
                    {50, 55, 50, 50, 50, 0}
            };
            testHamiltonianCircuit(cost7);

            // 测试用例8：包含负权重边的图
            int[][] cost8 = {
                    {0, -10, 20, 30},
                    {-10, 0, -25, 35},
                    {20, -25, 0, -30},
                    {30, 35, -30, 0}
            };
            testHamiltonianCircuit(cost8);

            // 测试用例9：完全不连通的图
            int[][] cost9 = {
                    {0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                    {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                    {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                    {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
            };
            testHamiltonianCircuit(cost9);

            // 测试用例10：包含部分连通的图
            int[][] cost10 = {
                    {0, 10, Integer.MAX_VALUE, 20},
                    {10, 0, 15, Integer.MAX_VALUE},
                    {Integer.MAX_VALUE, 15, 0, 25},
                    {20, Integer.MAX_VALUE, 25, 0}
            };
            testHamiltonianCircuit(cost10);
        }

        private static void testHamiltonianCircuit(int[][] cost) {
            HamiltonianCircuit hc = new HamiltonianCircuit(cost);
            hc.findHamiltonianCircuit();
            hc.printResult();
            System.out.println("--------------------------------------------------");
        }

}