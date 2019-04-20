package graph;

public class DFS {
    private static boolean[] visited;

    public static void DFSTraverse(Graph graph){
        // 初始化visited数组
        visited = new boolean[graph.getVertexNumber()];
        for (int i = 0;i < visited.length; i++){
            visited[i] = false;
        }

        for(int i  = 0;i < visited.length;i++){
            if(!visited[i]){
                DFS(graph, i);
            }
        }
    }

    /**
     *
     * @param graph
     * @param startVertexIndex  从顶点表的哪个顶点开始DFS
     */
    private static void DFS(Graph graph, int startVertexIndex){
        visited[startVertexIndex] = true;
        System.out.println("访问了" + graph.getVertices().get(startVertexIndex));

        for(int i = Utils.getFirstVertexIndex(graph, startVertexIndex);i != 0;i = Utils.getNextVertexIndex(graph, startVertexIndex,i)){
            if(!visited[i]){
                DFS(graph, i);
            }
        }
    }

}
