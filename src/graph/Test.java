package graph;

import java.io.File;
import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void test(){
        Graph<String> graphFromFile = Utils.createGraphFromFile(".\\src\\graph\\graph.data");
        DFS.DFSTraverse(graphFromFile);
    }

    public static void main(String[] args) {
        ArrayList<Vertex<String>> vertices = new ArrayList<>();
        vertices.add(new Vertex<String>("v1"));
        vertices.add(new Vertex<String>("v2"));
        vertices.add(new Vertex<String>("v3"));
        vertices.add(new Vertex<String>("v4"));
        vertices.add(new Vertex<String>("v5"));
        Graph<String> graph = new Graph<String>(vertices, 12, 5, 1);
        DFS.DFSTraverse(graph);
    }
}
