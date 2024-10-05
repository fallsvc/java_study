package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/5  11:23
 */
public class GraphByNode {
    static class Node{
        public int src;
        public int dest;
        public int weight;
        public Node next;

        public Node(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;

        }
    }

    public char[] arrayV;
    public ArrayList<Node> edgList;
    public boolean isDirect;

    public GraphByNode(int size,boolean isDirect){
        arrayV=new char[size];
        edgList=new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            edgList.add(null);
        }
        this.isDirect=isDirect;
    }

    /**
     * 初始化顶点数组
     * @param array
     */
    public void initArrayV(char[] array) {
        for (int i = 0; i < array.length; i++) {
            arrayV[i] = array[i];
        }
    }

    public void addEdge(char srcV,char destV,int weight){
        int srcVIndex=getIndexOfV(srcV);
        int destVIndex=getIndexOfV(destV);
        if(srcVIndex==-1||destVIndex==-1) return ;

        addEdgeChild(srcVIndex,destVIndex,weight);

        // 无向图需要添加双向
        if(isDirect==false){
            addEdgeChild(destVIndex,srcVIndex,weight);
        }

    }

    private void addEdgeChild(int srcVIndex, int destVIndex, int weight) {
        // 拿到头节点
        Node cur=edgList.get(srcVIndex);
        while(cur!=null){
            if(cur.dest==destVIndex){
                cur.weight=weight;
                return;
            }
            cur=cur.next;
        }
        // 没有路径  头插
        Node node=new Node(srcVIndex,destVIndex,weight);
        node.next=edgList.get(srcVIndex);
        edgList.set(srcVIndex,node);

    }


    private int getIndexOfV(char v) {
        for (int i = 0; i < arrayV.length; i++) {
            if(arrayV[i] == v) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 打印表
     */
    public void printGraph(){
        for (int i = 0; i < edgList.size(); i++) {
            System.out.print(arrayV[i]+"->");
            Node cur=edgList.get(i);
            while(cur!=null){
                System.out.print(" "+arrayV[cur.dest]);
                cur=cur.next;
            }
            System.out.println();
        }
    }

    /**
     *
     * @param v
     * @return
     */
    public int getDevOfV(char v){
        int count=0; // 计数
        int vIndex=getIndexOfV(v);

        Node cur=edgList.get(vIndex);
        while(cur!=null){
            count++;
            cur=cur.next;
        }

        // 如果有向
        if(isDirect==true){
            for (int i = 0; i < edgList.size(); i++) {
                if(i!=vIndex){
                    cur=edgList.get(i);
                    while(cur!=null){
                        if(cur.dest==vIndex){// 目的地为要找顶点
                            count++;
                        }
                        cur=cur.next;
                    }
                }else{
                    continue;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

        GraphByNode graph = new GraphByNode(4,true);
        char[] array = {'A','B','C','D'};
        graph.initArrayV(array);

        graph.addEdge('A','B',1);
        graph.addEdge('A','D',1);
        graph.addEdge('B','A',1);
        graph.addEdge('B','C',1);
        graph.addEdge('C','B',1);
        graph.addEdge('C','D',1);
        graph.addEdge('D','A',1);
        graph.addEdge('D','C',1);

        System.out.println("getDevOfV:: "+graph.getDevOfV('A'));
        graph.printGraph();
    }


}
