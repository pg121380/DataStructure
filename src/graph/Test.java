package graph;

public class Test {
    @org.junit.Test
    public void testDFS(){
        Graph<String> graphFromFile = Utils.createGraphFromFile(".\\src\\graph\\graph3.data");
        DFS.DFSTraverse(graphFromFile);
    }

    @org.junit.Test
    public void testBFS(){
        Graph<String> graphFromFile = Utils.createGraphFromFile(".\\src\\graph\\graph3.data");
        BFS.BFSTraverse(graphFromFile, 0);
    }


    @org.junit.Test
    public void testPrim() {
        Graph<String> graph = Utils.createGraphFromFile(".\\src\\graph\\graph3.data");
        graph.Prim(0);

    }
}
