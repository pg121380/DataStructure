package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public static int getFirstVertexIndex(Graph graph, int vertexNumber){
        return ((Vertex)graph.getVertices().get(vertexNumber)).getFirstEdge().getVertexPosition();
    }

    /**
     *
     * @param graph
     * @param startVertexIndex  从哪个结点开始寻找
     * @param nowVertexIndex    现在已经找到（遍历过）的索引
     * @return
     */
    public static int getNextVertexIndex(Graph graph, int startVertexIndex, int nowVertexIndex){
        Vertex startVertex = (Vertex)graph.getVertices().get(startVertexIndex);
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

    public static Graph<String> createGraphFromFile(String filePath){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            int vertexNumber = Integer.parseInt(reader.readLine().split("=")[1]);
            int edgeNumber = Integer.parseInt(reader.readLine().split("=")[1]);
            int kind = Integer.parseInt(reader.readLine().split("=")[1]);
            String[] vertexDatas = reader.readLine().split(",");
            ArrayList<Vertex<String>> vertices = new ArrayList<>();

            for(String vertexData:vertexDatas){
                vertices.add(new Vertex<String>(vertexData));
            }

            Graph<String> graph = new Graph<String>(vertices, edgeNumber, vertexNumber, kind);

            String edgeMsg = null;
            while ((edgeMsg = reader.readLine()) != null){
                String[] singleEdgeMsg = edgeMsg.split(" ");
                int tail = Integer.parseInt(singleEdgeMsg[0]);
                int head = Integer.parseInt(singleEdgeMsg[1]);
                int weight = Integer.parseInt(singleEdgeMsg[2]);

                Edge edge = new Edge();
                edge.setVertexPosition(head);
                edge.setWeight(weight);
                edge.setNextEdge(vertices.get(tail).getFirstEdge());
                vertices.get(tail).setFirstEdge(edge);
                if(kind == 1){
                    Edge edge1 = new Edge();
                    edge1.setVertexPosition(tail);
                    edge1.setWeight(weight);
                    edge1.setNextEdge(vertices.get(head).getFirstEdge());
                    vertices.get(head).setFirstEdge(edge1);
                }
            }
            return graph;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
