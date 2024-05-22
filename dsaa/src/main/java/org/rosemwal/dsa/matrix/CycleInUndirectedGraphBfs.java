package org.rosemwal.dsa.matrix;

import javafx.util.Pair;

import java.util.*;

public class CycleInUndirectedGraphBfs {

    public static void main(String[] args)  {

        List<List<Integer>> mainList = new LinkedList<>();

        mainList.add(Arrays.asList(1));
        mainList.add(Arrays.asList(0,2,4));
        mainList.add(Arrays.asList(1,3));
        mainList.add(Arrays.asList(2,4));
        mainList.add(Arrays.asList(1, 3));
        System.out.println(isCycle(5, mainList));


        mainList = new LinkedList<>();

        mainList.add(Arrays.asList(1));
        mainList.add(Arrays.asList(0,2,4));
        mainList.add(Arrays.asList(1,3));
        mainList.add(Arrays.asList(2,4));
        mainList.add(Arrays.asList(1, 3));
        System.out.println(isCycle(5, mainList));
    }

    public static boolean isCycle(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++)  {
            visited[i] = false;
        }

        for(int i=0; i<V; i++)  {
            if(!visited[i] && isCycleDetected(i, adj, visited)) {
                return true;
            }
        }

        return false;
    }

    static boolean isCycleDetected(int vertex, List<List<Integer>> adj, boolean[] visited)   {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(vertex, -1));
        System.out.println(vertex +" vertex");

        while(!queue.isEmpty()) {

            Pair<Integer, Integer> pair = queue.poll();
            int node =  pair.getKey();
            int parent = pair.getValue();
            System.out.println(node);

            for (int n: adj.get(node)) {
//                System.out.println(n +" "+node);
                if(!visited[n]) {
                    visited[n] = true;
                    queue.offer(new Pair<>(n, node));
                }   else if (parent!=n) {
                    System.out.println(n + " " + node +" "+ parent);
                    return true;
                }
            }
        }

        return false;
    }
}
