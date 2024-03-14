package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList; // 存储顶点的集合
    private int[][] edges; // 存储图对应的邻结矩阵
    private int numOfEdges; // 表示边的数目
    // 定义一个数组boolean[],记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {

        // 测试一把图是否被创建ok
        int n = 8; // 节点的个数
        // String[] Vertexs = {"A","B","C","D","E"};
        String[] Vertexs = {"1","2","3","4","5","6","7","8"};

        // 创建图对象
        Graph graph = new Graph(n);
        // 循环的添加顶点
        for (String Vertex : Vertexs) {
            graph.insertVertex(Vertex);
        }
        // 添加边
        // A-B A-C B-C B-D B-E
/*        graph.insertEdge(0,1,1); // A-B
        graph.insertEdge(0,2,1); // A-C
        graph.insertEdge(1,2,1); // B-C
        graph.insertEdge(1,3,1); // B-D
        graph.insertEdge(1,4,1); // B-E*/

        // 更新边的关系
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,1);

        // 显示一把邻接矩阵
        graph.showGraph();

        // 测试一把，我们的dfs遍历是否ok
        System.out.println("深度遍历");
        graph.dfs(); // A->B->C->D->E // 1->2->4->8->5->3->6->7->

        System.out.println();

        System.out.println("广度优先");
        graph.bfs(); // A->B->C->D->E // 1=>2=>3=>4=>5=>6=>7=>8=>

    }

    // 构造器
    public Graph(int n) {
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    // 得到第一个邻接节点的下标 w
    /**
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 深度优先遍历算法
    // i 第一次就是 0
    private void dfs(boolean[] isVisited,int i) {
        // 首先我们访问该节点，输出
        System.out.printf(getValueByIndex(i) + "->");
        // 将节点设置为已经访问过
        isVisited[i] = true;
        // 查找节点 i 的第一个邻接节点的下标 w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            // 说明有邻接节点
            if (!isVisited[w]) {
                dfs(isVisited,w);
            }
            // 如果 w 节点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }

    // 对dfs 进行一个重载，遍历我们所有的节点，并进行dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        // 遍历所有的节点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }

    // 对一个节点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i) {
        int u; // 表示队列的头节点对应的下标
        int w; // 邻接节点w
        // 队列，记录节点访问的顺序
        LinkedList<Object> queue = new LinkedList<>();
        // 访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + "=>");
        // 标记为已访问
        isVisited[i] = true;
        // 将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            // 取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            // 得到第一个邻接节点的下标 w
            w = getFirstNeighbor(u);
            while (w != -1) {
                // 找到了
                // 是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    // 标记已经访问
                    isVisited[w] = true;
                    // 入队
                    queue.addLast(w);
                }
                // 以 u 为前驱点，找w后面的下一个邻接节点
                w = getNextNeighbor(u,w); // 体现出我们的广度优先
            }
        }
    }

    // 遍历所有的节点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited,i);
            }
        }
    }

    // 图中常用的方法
    // 返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    // 得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点下标（i）对应的数据 0 -> "A" 1 -> "B" 2 -> "C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // 添加边
    /**
     * @param v1 表示点的下标 即第几个顶点 “A” - “B” "A" -> 0 "B" -> 1
     * @param v2 第二个顶点对应的下标
     * @param weight 表示是否相连
     */
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
