package graph;

public class Edge {
    private int vertexPosition;     // 这条弧(边)所指向的顶点在顶点表的位置

    private Edge nextEdge;          // 下一条弧

    public int getVertexPosition() {
        return vertexPosition;
    }

    public void setVertexPosition(int vertexPosition) {
        this.vertexPosition = vertexPosition;
    }

    public Edge getNextEdge() {
        return nextEdge;
    }

    public void setNextEdge(Edge nextEdge) {
        this.nextEdge = nextEdge;
    }

    public Edge(int vertexPosition, Edge nextEdge) {
        this.vertexPosition = vertexPosition;
        this.nextEdge = nextEdge;
    }

    public Edge(){

    }

    public Edge(int vertexPosition){
        this.vertexPosition = vertexPosition;
    }
}
