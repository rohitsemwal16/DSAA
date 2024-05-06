package org.rosemwal.code.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//          0
//        1    2
//     3    4     6
//        5(con to 4)    7 (conn to 6)
public class BfsTraversal {

    List<Integer> bfsTraversal(int vertex, List<List<Integer>> edges)   {

        List<Integer> bfsTraversalList = new LinkedList<>();
        List<Boolean> visitedNodes = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<=vertex; i++)    {
            visitedNodes.add(false);
        }

        queue.add(0);
        visitedNodes.set(0, true);

        while(!queue.isEmpty()) {

            Integer vertex1 = queue.poll();
            visitedNodes.set(vertex1, true);
            bfsTraversalList.add(vertex1);

            for (Integer nodeJoiningVertex : edges.get(vertex1))  {

                if (!visitedNodes.get(nodeJoiningVertex))    {
                    visitedNodes.set(nodeJoiningVertex, true);
                    queue.add(nodeJoiningVertex);
                }
            }
        }
        return bfsTraversalList;
    }

    public static void main(String[] args)  {

        BfsTraversal bfsTraversal = new BfsTraversal();
        List<List<Integer>> list = createList();
        List<Integer> l = bfsTraversal.bfsTraversal(list.size(), list);
        System.out.println(Arrays.toString(l.toArray()));
    }

    private static List<List<Integer>> createList() {

        List<List<Integer>> list = new LinkedList<>();

        List<Integer> l0 = new LinkedList<>();
        l0.add(1);
        l0.add(2);

        List<Integer> l1 = new LinkedList<>();
        l1.add(0);
        l1.add(3);
        l1.add(4);

        List<Integer> l2 = new LinkedList<>();
        l2.add(0);
        l2.add(6);

        List<Integer> l3 = new LinkedList<>();
        l3.add(1);

        List<Integer> l4 = new LinkedList<>();
        l4.add(1);
        l4.add(5);

        List<Integer> l5 = new LinkedList<>();
        l5.add(4);

        List<Integer> l6 = new LinkedList<>();
        l6.add(2);
        l6.add(7);

        List<Integer> l7 = new LinkedList<>();
        l7.add(6);

        list.add(l0);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        list.add(l7);

        return list;
    }
}
