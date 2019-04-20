package graph;

public class Vertex<Element> {
    private Element data;   // 图结点保存的数据

    private Edge firstEdge; // 第一条依附于该结点的弧

    public Element getData() {
        return data;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public Edge getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(Edge firstEdge) {
        this.firstEdge = firstEdge;
    }

    public Vertex(Element data, Edge firstEdge) {
        this.data = data;
        this.firstEdge = firstEdge;
    }

    public Vertex(Element data) {
        this.data = data;
    }

    public Vertex() {

    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", firstEdge=" + firstEdge +
                '}';
    }
}
