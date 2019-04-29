package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph<Element> {
    private ArrayList<Vertex<Element>> vertices;        // 图的顶点表

    private ArrayList<Edge> edges = new ArrayList<>();

    private int edgeNumber;     // 图的边的数量

    private int vertexNumber;     // 图的结点的数量

    private int kind;       // 图的种类(后期最好改为枚举类型)

    public ArrayList<Vertex<Element>> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex<Element>> vertices) {
        this.vertices = vertices;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public void setEdgeNumber(int edgeNumber) {
        this.edgeNumber = edgeNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    /**
     *
     * @param vertices  顶点表
     * @param edgeNumber    边数
     * @param vertexNumber  顶点数
     * @param kind  图的种类: 0有向图 | 1 无向图
     */
    public Graph(ArrayList<Vertex<Element>> vertices, int edgeNumber, int vertexNumber, int kind) {
        this.vertices = vertices;
        this.edgeNumber = edgeNumber;
        this.vertexNumber = vertexNumber;
        this.kind = kind;
    }

    public void createGraph(){
        if(this.vertexNumber == 0 || this.edgeNumber == 0) {
            System.err.println("请至少输入一个点/边");
            return;
        }
        if(this.vertices.isEmpty()){
            System.err.println("顶点表中必须有信息！");
            return;
        } else {
            for(Vertex<Element> vertex:vertices){
                vertex.setFirstEdge(null);
            }
        }
        Scanner scanner = new Scanner(System.in);
        if(this.edgeNumber == 0){
            System.out.println("请输入图的边数:");
            int edgeNumber = scanner.nextInt();
            this.setEdgeNumber(edgeNumber);
        }
        // 输入边
        for(int i = 0;i < this.edgeNumber;i++){
            int tail;   // 边尾(发出边的结点在节点表中的位置)
            int head;   // 边头(边指向的结点在节点表的位置)
            int weight; // 权重
            Edge edge = new Edge();
            System.out.println("以下是输入第" + (i + 1) + "条边的信息");
            System.out.println("输入边头的位置:");
            head = scanner.nextInt();
            System.out.println("输入边尾的位置:");
            tail = scanner.nextInt();
            System.out.println("输入权重:");
            weight = scanner.nextInt();

            edge.setVertexPosition(head);
            edge.setWeight(weight);
            edge.setNextEdge(vertices.get(tail).getFirstEdge());
            edge.setTail(tail);
            vertices.get(tail).setFirstEdge(edge);
            edges.add(edge);
            if(this.kind == 1){
                // 无向图
                Edge edge1 = new Edge();
                edge1.setVertexPosition(tail);
                edge1.setWeight(weight);
                edge1.setNextEdge(vertices.get(head).getFirstEdge());
                edge1.setTail(head);
                vertices.get(head).setFirstEdge(edge1);
                edges.add(edge1);
            }
        }
    }

    public void Prim(int startIndex){
        // 首先初始化一个数组inArray，用于保存已在生成树里的结点，初始化另一个数组notInArray，用于保存不在生成树中的结点
        // 将开始结点放入数组，首先寻找所有tail在inArray中,head在notInArray中的边，然后找出权值最小的edge
        // inArray增加edge.getHead notInArray删除edge.getHead
        ArrayList<Integer> inList = new ArrayList<>();
        ArrayList<Integer> notInList = new ArrayList<>();
        ArrayList<Edge> msTree = new ArrayList<>();

        for(int i = 0;i < this.vertices.size();i++){
            if(vertices.get(i) != null && i != startIndex){
                notInList.add(i);
            }
        }

        inList.add(startIndex);

        while(inList.size() != this.vertices.size()){
            // TODO:首先寻找所有tail在inArray中,head在notInArray中的边，然后找出权值最小的edge
            Edge targetEdge = getPrimEdge(inList, notInList);
            inList.add(targetEdge.getVertexPosition());
            notInList.remove(notInList.indexOf(targetEdge.getVertexPosition())); // 这里的问题
            msTree.add(targetEdge);
            System.out.println("inList:" + inList);
            System.out.println("notInList:" + notInList);
            System.out.println("-------------------");
        }
//        System.out.println(msTree);
        for(int i = 0;i < msTree.size();i++){
            System.out.println(this.vertices.get(msTree.get(i).getTail()).getData() + "--->" +this.vertices.get(msTree.get(i).getVertexPosition()).getData());
        }
    }

    public Edge getPrimEdge(ArrayList<Integer> inList, ArrayList<Integer> notInList){
        ArrayList<Edge> edges = new ArrayList<>();
        for(Edge edge : this.edges){
            if(inList.contains(edge.getTail()) && notInList.contains(edge.getVertexPosition())){
                edges.add(edge);
            }
        }
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < edges.size();i++){
            if(edges.get(i).getWeight() < min){
                min = edges.get(i).getWeight();
                minIndex = i;
            }
        }
        return edges.get(minIndex);
    }

    /**
     * @return 返回图的拓扑排序序列
     */
    public ArrayList<Integer> topologicalSort(){
        // 首先要计算所有顶点的入度，给出一个入度数组
        // 每次从入度表中拿出来一个入度为0的点
        // 将所有以它为tail的边的head节点的入度-1
        // 将此点放入列表
        return null;
    }

}
