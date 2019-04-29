package graph;

import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void testDFS(){
        Graph<String> graphFromFile = Utils.createGraphFromFile(".\\src\\graph\\graph2.data");
        DFS.DFSTraverse(graphFromFile);
    }

    @org.junit.Test
    public void testBFS(){
        Graph<String> graphFromFile = Utils.createGraphFromFile(".\\src\\graph\\graph2.data");
        BFS.BFSTraverse(graphFromFile, 0);
    }


    @org.junit.Test
    public void testPrim() {
        Graph<String> graph = Utils.createGraphFromFile(".\\src\\graph\\graph2.data");
        graph.Prim(0);

    }

    @org.junit.Test
    public void testIndegree(){
        Graph<String> graph = Utils.createGraphFromFile(".\\src\\graph\\graph4.data");
        ArrayList<Integer> integers = graph.topologicalSort();
        System.out.println(integers);
    }
}
