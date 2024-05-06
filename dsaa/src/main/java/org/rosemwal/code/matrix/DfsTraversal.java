package org.rosemwal.code.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DfsTraversal {

                /*
                        0
                    1         4
                2      3     5    6
                                        7
                 */

    public static void main(String[] args)  {

        List<List<Integer>> list = createDfsList();
        List<Boolean> visited = new LinkedList<>();

        for(int i=0;i<list.size(); i++) {
            visited.add(false);
        }

        List<Integer> dfsResult = new LinkedList<>();

        List<Integer> dfsList = dfsTraversal(0, visited, list, dfsResult);
        System.out.println(Arrays.toString(dfsList.toArray()));
    }

    private static List<Integer> dfsTraversal(int node, List<Boolean> visited,
                                              List<List<Integer>> list,
                                              List<Integer> dfsResult) {

        visited.set(node, true);
        dfsResult.add(node);
        List<Integer> edges = list.get(node);

        for (Integer edge: edges)   {
            if(!visited.get(edge))  {
                dfsTraversal(edge, visited, list, dfsResult);
            }
        }
        return dfsResult;
    }

    private static List<List<Integer>> createDfsList() {

        List<List<Integer>> list = new LinkedList<>();

        List<Integer> l0 = new LinkedList<>();
        l0.add(1);
        l0.add(4);

        List<Integer> l1 = new LinkedList<>();
        l1.add(0);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new LinkedList<>();
        l2.add(1);

        List<Integer> l3 = new LinkedList<>();
        l3.add(1);

        List<Integer> l4 = new LinkedList<>();
        l4.add(0);
        l4.add(5);
        l4.add(6);

        List<Integer> l5 = new LinkedList<>();
        l5.add(4);

        List<Integer> l6 = new LinkedList<>();
        l6.add(4);
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
