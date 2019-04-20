package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

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

    @org.junit.Test
    public void testQueue(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    @org.junit.Test
    public void testBFS(){
        Graph<String> graphFromFile = Utils.createGraphFromFile(".\\src\\graph\\graph.data");
        BFS.BFSTraverse(graphFromFile, 0);
    }
}
