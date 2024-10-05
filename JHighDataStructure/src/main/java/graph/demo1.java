package graph;

import java.util.HashMap;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/5  10:02
 */
public class demo1 {
    public static void main(String[] args) {
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
