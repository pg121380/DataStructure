package graph;

import java.util.ArrayList;

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

    public Graph(ArrayList<Vertex<Element>> vertices, int edgeNumber, int vertexNumber) {
        this.vertices = vertices;
        this.edgeNumber = edgeNumber;
        this.vertexNumber = vertexNumber;
    }

    public Graph(int edgeNumber, int vertexNumber) {
        this.edgeNumber = edgeNumber;
        this.vertexNumber = vertexNumber;
    }

    public Graph(ArrayList<Vertex<Element>> vertices) {
        this.vertices = vertices;
        this.setVertexNumber(vertices.size());
    }
}
