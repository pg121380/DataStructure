package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static boolean[] visited;

    public static void BFSTraverse(Graph graph, int startVertexIndex){
        visited = new boolean[graph.getVertexNumber()];
        for(int i = 0;i < visited.length; i++){
            visited[i] = false;
        }
        Queue<Integer> indexQueue = new LinkedList<Integer>();
        visited[startVertexIndex] = true;
        System.out.println("访问了" + ((Vertex)graph.getVertices().get(startVertexIndex)).getData());
        indexQueue.add(startVertexIndex);

        while(!indexQueue.isEmpty()){
            int pollIndex = indexQueue.poll();
            for(int i = Utils.getFirstVertexIndex(graph, pollIndex);i >= 0;i = Utils.getNextVertexIndex(graph, pollIndex, i)){
                if(!visited[i]){
                    visited[i] = true;
                    indexQueue.offer(i);
                    System.out.println("访问了" + ((Vertex)graph.getVertices().get(i)).getData());
                }
            }
        }
    }
}





