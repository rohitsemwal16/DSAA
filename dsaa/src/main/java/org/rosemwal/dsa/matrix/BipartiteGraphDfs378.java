package org.rosemwal.dsa.matrix;

public class BipartiteGraphDfs378 {

    public static void main(String[] args)  {

//        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Is Bipartite  " + isBipartiteDfs(graph2));
    }

    private static boolean isBipartiteDfs(int[][] graph) {

        int V = graph.length;
        int[] color = new int[V];

        for (int i=0; i<V; i++) {
            if (color[i] == 0 && !isBipartiteDfs1(i, graph, color, 1)) {
                    return false;
                }
            }
        return true;
    }

    private static boolean isBipartiteDfs1(int node, int[][] graph, int[] colorArray, int color) {

        if (colorArray[node] != 0)  {
            return colorArray[node] == color;
        }
        colorArray[node] = color;
        int[] adj = graph[node];

        for (int i=0; i<adj.length; i++)    {

            int k = adj[i];
            if (!isBipartiteDfs1(k, graph, colorArray, -color)) {
                return false;
            }
        }
        return true;
    }
}
