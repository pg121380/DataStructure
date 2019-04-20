package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph<Element> {
    private ArrayList<Vertex<Element>> vertices;        // 图的顶点表

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
            vertices.get(tail).setFirstEdge(edge);
            if(this.kind == 1){
                Edge edge1 = new Edge();
                edge1.setVertexPosition(tail);
                edge1.setWeight(weight);
                edge1.setNextEdge(vertices.get(head).getFirstEdge());
                vertices.get(head).setFirstEdge(edge1);
            }
        }
    }
}
