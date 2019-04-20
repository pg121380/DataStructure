package graph;

public class Utils {
    public static int getFirstVertexIndex(Graph graph, int vertexNumber){
        return ((Vertex)graph.getVertices().get(vertexNumber)).getFirstEdge().getVertexPosition();
    }

    public static int getNextVertexIndex(Graph graph, int startVertexIndex, int nowVertexIndex){
        Vertex startVertex = (Vertex)graph.getVertices().get(startVertexIndex);
        // TODO:完成这里的逻辑
        // 首先在顶点表中 根据startVertexIndex索引到从哪个顶点开始找,然后edge = Vertex.getFirstEdge(),
        // 如果edge.vertexPosition不等于nowVertexIndex,则edge = edge.nextEdge(),重复此过程，直到edge.vertexPosition = nowVertexIndex
        // 或者edge = null(返回-1),如果edge.vertexPosition = nowVertexIndex，则edge = edge.getNextEdge()是否为null，为Null则返回-1
        // 不为null则返回edge.vertexPosition;
        Edge edge = startVertex.getFirstEdge();
        while (edge != null){
            if(edge.getVertexPosition() != nowVertexIndex){
                edge = edge.getNextEdge();
            } else {
                edge = edge.getNextEdge();
                if(edge != null){
                    return edge.getVertexPosition();
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
