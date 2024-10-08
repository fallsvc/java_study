package graph;

import java.util.HashMap;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/5  10:02
 */
public class demo1 {
    public static void testGraphFloydWarShall() {
        String str = "12345";
        char[] array = str.toCharArray();
        GraphByMatrix g = new GraphByMatrix(str.length(),true);
        g.initArray(array);
        g.addEdge('1', '2', 3);
        g.addEdge('1', '3', 8);
        g.addEdge('1', '5', -4);
        g.addEdge('2', '4', 1);
        g.addEdge('2', '5', 7);
        g.addEdge('3', '2', 4);
        g.addEdge('4', '1', 2);
        g.addEdge('4', '3', -5);
        g.addEdge('5', '4', 6);
        int[][] dist = new int[array.length][array.length];
        int[][] parentPath = new int[array.length][array.length];
        g.floydWarShall(dist,parentPath);
        for (int i = 0; i < array.length; i++) {
            g.printShortPath(array[i],dist[i],parentPath[i]);
        }
    }
    public static void main(String[] args) {
//        testGraphDijkstra();
        testGraphFloydWarShall();
    }
    public static void testGraphDijkstra() { String str = "syztx";
        char[] array = str.toCharArray();
        GraphByMatrix g = new GraphByMatrix(str.length(),true);
        g.initArray(array);
        g.addEdge('s', 't', 10);
        g.addEdge('s', 'y', 5);
        g.addEdge('y', 't', 3);
        g.addEdge('y', 'x', 9);
        g.addEdge('y', 'z', 2);
        g.addEdge('z', 's', 7);
        g.addEdge('z', 'x', 6);
        g.addEdge('t', 'y', 2);
        g.addEdge('t', 'x', 1);
        g.addEdge('x', 'z', 4);
        /*搞不定负权值 String str = "sytx";
char[] array = str.toCharArray();
 GraphByMatrix g = new GraphByMatrix(str.length(),true);
  g.initArrayV(array); g.addEdge('s', 't', 10);
  g.addEdge('s', 'y', 5);
   g.addEdge('t', 'y', -7);
    g.addEdge('y', 'x', 3);*/
        int[] dist = new int[array.length];
        int[] parentPath = new int[array.length];
        g.dijkstra('s', dist, parentPath);
        g.printShortPath('s', dist, parentPath);
    }

        public static void main3(String[] args) {
    String str = "abcdefghi";
    char[] array =str.toCharArray();
    GraphByMatrix g = new GraphByMatrix(str.length(),false);
    g.initArray(array); g.addEdge('a', 'b', 4);
    g.addEdge('a', 'h', 8);
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
    GraphByMatrix primTree = new GraphByMatrix(str.length(),false);
    primTree.initArray(array);
    System.out.println(g.prime(primTree,'a'));
    primTree.printGraph();
}
    public static void main2(String[] args) {
        GraphByMatrix.testGraphMinTree();
    }
    public static void main1(String[] args) {
        GraphByMatrix graphByMatrix=new GraphByMatrix(4,false);

        char[] array={'A','B','C','D'};
        graphByMatrix.initArray(array);

        graphByMatrix.addEdge('A','B',1);
        graphByMatrix.addEdge('A','D',1);
        graphByMatrix.addEdge('B','C',1);
        graphByMatrix.addEdge('C','D',1);

//        graphByMatrix.printGraph();

//        graphByMatrix.bfs('D');
        graphByMatrix.dfs('B');
        System.out.println("");
    }
}
