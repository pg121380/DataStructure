package graph;

import java.util.concurrent.ArrayBlockingQueue;

public class BFS {

    private static boolean[] visited;

    public static void BFSTraverse(Graph graph, int startVertexIndex){
        visited = new boolean[graph.getVertexNumber()];
        for(int i = 0;i < visited.length; i++){
            visited[i] = false;
        }
        ArrayBlockingQueue<Integer> indexQueue = new ArrayBlockingQueue<Integer>(graph.getVertexNumber());
        // visited[startVertexIndex] = true;
        indexQueue.add(startVertexIndex);

        while(!indexQueue.isEmpty()){
            int pollIndex = indexQueue.poll();
            for(int i = Utils.getFirstVertexIndex(graph, pollIndex);i >= 0;i = Utils.getNextVertexIndex(graph, pollIndex, i)){
                if(!visited[i]){
                    visited[i] = true;
                    indexQueue.add(i);
                    System.out.println("访问了" + ((Vertex)graph.getVertices().get(i)).getData());
                }
            }
        }
    }
}





