package org.rosemwal.dsa.matrix;

import java.util.*;

public class TopologicalSort363 {

    public static void main(String args[])  {

        List<List<Integer>> mainList = new LinkedList<>();

        mainList.add(Arrays.asList());
        mainList.add(Arrays.asList());
        mainList.add(Arrays.asList(3));
        mainList.add(Arrays.asList(1));
        mainList.add(Arrays.asList(0, 1));
        mainList.add(Arrays.asList(0, 2));

        System.out.println(Arrays.toString(topoSort(5, mainList)));
        System.out.println(Arrays.toString(topoSortKahn(5, mainList)));
    }

    private static int[] topoSortKahn(int V, List<List<Integer>> adjList) {

        Queue<Integer> queue = new LinkedList<>();

        int[] degree = new int[V+1];

        for (int i=0;i<=V; i++) {
            List<Integer> adjacencyL = adjList.get(i);
            for (int adj : adjacencyL)  {
                degree[adj]++;
            }
        }

        int[] res = new int[V+1];
        int count = 0;

        for (int i=0; i<=V; i++)    {
            if(degree[i]==0)    {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty())    {

            int q = queue.poll();
            res[count++] = q;

            int size = adjList.get(q).size();

            for (int i=0; i<size; i++)    {

                int el = adjList.get(q).get(i);

                degree[el]--;

                if(degree[el] == 0)   {
                    queue.offer(el);
                }
            }
        }
        return res;

    }

    static int[] topoSort(int V, List<List<Integer>> adj)
    {
        boolean[] visited = new boolean[V+1];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=V; i++)  {
            if(!visited[i]) {
                dfs(i, visited, adj, stack);
            }
        }

        int[] res = new int[V+1];
        int count = 0;

        while(!stack.isEmpty()) {
            res[count++] = stack.pop();
        }

        return res;
    }

    static void dfs(int node, boolean[] visited, List<List<Integer>> adj, Stack<Integer> stack)   {

        List<Integer> subadj = adj.get(node);
        visited[node] = true;

        for (int i=0; i<subadj.size(); i++)   {
            if(!visited[subadj.get(i)])   {
                dfs(subadj.get(i), visited, adj, stack);
            }
        }
        stack.push(node);

    }
}
