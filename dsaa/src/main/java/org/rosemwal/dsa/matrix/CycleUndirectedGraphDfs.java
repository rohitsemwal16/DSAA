package org.rosemwal.dsa.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CycleUndirectedGraphDfs {

    public static void main(String[] args) {

        List<List<Integer>> mainList = new LinkedList<>();

        mainList.add(Arrays.asList(1));
        mainList.add(Arrays.asList(0, 2, 4));
        mainList.add(Arrays.asList(1, 3));
        mainList.add(Arrays.asList(2, 4));
        mainList.add(Arrays.asList(1, 3));
        System.out.println(isCycle(5, mainList));
    }

    public static boolean isCycle(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
}

    private static boolean dfs(int i, int parent, List<List<Integer>> adj, boolean[] visited) {

        List<Integer> adjList = adj.get(i);
        visited[i] = true;

        for (Integer adjacency : adjList)   {

            if (!visited[adjacency])    {
                if (dfs(adjacency, i, adj, visited))    {
                    return true;
                }
            }   else {
                if (parent != adjacency)    {
                    return true;
                }
            }
        }
        return false;
    }
}
