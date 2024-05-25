package org.rosemwal.dsa.matrix;

import java.util.LinkedList;
import java.util.Queue;

// 25 May 2024
// https://leetcode.com/problems/is-graph-bipartite/description/
public class BipartiteGraphBfs378 {

    public static void main(String[] args)  {

        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println("Is Bipartitie" + isBipartite(graph));
    }

    public static  boolean isBipartite(int[][] graph) {

        int V = graph.length;
        int[] color = new int[V];

        int count = 0;
        for (int i=0; i<V; i++) {
            color[count++] = -1;
        }

        for (int i=0; i<V; i++) {

            if(color[i] ==-1 && !isBipartitie(i, color, graph))  {
                return false;
            }
        }

        return true;
    }

    public static boolean isBipartitie(int V, int[] color, int[][] graph)    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        color[V]=0;

        while(!queue.isEmpty()) {

            int n = queue.poll();
            int curColor = color[n];
            int[] arr = graph[n];
            for(int i=0; i<arr.length;i++)  {

                if(color[arr[i]]!=-1)   {
                    if (curColor == color[arr[i]])  {
                        return false;
                    }
                }   else    {
                    queue.offer(arr[i]);
                    if(curColor == 0)    {
                        color[arr[i]] = 1;
                    }   else    {
                        color[arr[i]]=0;
                    }
                }
            }
        }
        return true;
    }
}
