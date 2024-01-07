package org.rosemwal.code.tree;

/*
Created on 2022-09-11
 */

import java.util.*;

public class ViewsIterativeInTrees180 {

    static class Node  {
        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = this.right = null;
        }
}

    public static void main(String[] args)  {

        Node node = new Node(10);
        node.left = new Node(7);
        node.left.right = new Node(9);
        node.left.left =  new Node(5);
        node.left.left.left = new Node(3);

        node.right = new Node(15);
        node.right.left = new Node(13);
        node.right.right = new Node(20);
        node.right.right.left = new Node(17);

        List<Integer> leftViewList = printLeftViewIterative(node);
        System.out.println("Left View " + Arrays.toString(leftViewList.toArray()));

        List<Integer> rightViewList = printRightViewIterative(node);
        System.out.println("Right View " + Arrays.toString(rightViewList.toArray()));

        List<Integer> zigzagTraversal = printZigZagTraversal(node);
        System.out.println("ZigZag Traversal " + Arrays.toString(zigzagTraversal.toArray()));

        Map<Integer, Node> topViewMap = printTopViewIterative(node);

        System.out.println("Top View of tree ");
        for(Map.Entry<Integer, Node> m : topViewMap.entrySet())   {
            System.out.printf("Key %d -- Value %d %n", m.getKey(), m.getValue().data);
        }

        Map<Integer, Node> bottomViewMap = printBottomViewIterative(node);

        System.out.println("Bottom View of tree ");
        for(Map.Entry<Integer, Node> m : bottomViewMap.entrySet())   {
            System.out.printf("Key %d -- Value %d %n", m.getKey(), m.getValue().data);
        }

        Map<Node, Integer> diagonalViewMap = printDiagonalViewIterative(node); // left (root diagonal +1) // right no change

        System.out.println("Diagonal View of tree ");
        for(Map.Entry<Node, Integer> m : diagonalViewMap.entrySet())   {
            System.out.printf("Key %d -- Value %d %n", m.getKey().data, m.getValue());
        }
    }

    private static Map<Node, Integer> printDiagonalViewIterative(Node root) {

        Map<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        map.put(root, 0);
        queue.offer(root);

        while(!queue.isEmpty()) {

            Node node = queue.poll();
            int diag = map.get(node);
            if(node.left!= null)   {
                map.put(node.left, diag+1);
                queue.offer(node.left);
            }

            if(node.right!=null)    {
                map.put(node.right, diag);
                queue.offer(node.right);
            }
        }
        return map;
    }

    // even row in reverse
    private static List<Integer> printZigZagTraversal(Node node) {

        Queue<Node> queue = new LinkedList<>();
        List<Integer> zigZagList = new LinkedList<>();

        queue.add(node);
        int iteration = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> sublist = new LinkedList<>();
            boolean printInReverse = iteration % 2 == 0;

            for (int i=0; i<size; i++) {
                Node n = queue.poll();

                if(printInReverse)
                    sublist.add(0, n.data);
                else
                    sublist.add(n.data);

                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }

            iteration ++;
            zigZagList.addAll(sublist);
        }
        return zigZagList;
    }


    private static Map<Integer, Node> printBottomViewIterative(Node node) {

        Map<Integer, Node> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        map.put(0, node);
        queue.add(node);

        while(!queue.isEmpty()) {

            Node n = queue.poll();
            Optional<Map.Entry<Integer, Node>> nodeLevel = map.entrySet().stream()
                    .filter(e -> Objects.equals(n, e.getValue())).findFirst();

            int level = 0;
            if(nodeLevel.isPresent())   {
                level = nodeLevel.get().getKey();
            }

            if(n.left != null)  {
                map.put(level-1, n.left);
                queue.add(n.left);
            }
            if(n.right != null) {
                map.put(level+1, n.right);
                queue.add(n.right);
            }
        }

        return map;
    }

    // O(n) is time and space complexity
    private static List<Integer> printLeftViewIterative(Node node) {

        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> leftViewList = new ArrayList<Integer>();

        queue.offer(node);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0; i<size; i++)   {

                Node n = queue.poll();
                if (i == 0 ) {
                    leftViewList.add(n.data);
                }
                if (n.left != null)  {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }

        }
        return leftViewList;
    }

    // O(n) is time and space complecity
    private static List<Integer> printRightViewIterative(Node node) {

        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> rightViewList = new LinkedList<Integer>();

        queue.offer(node);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node n = queue.poll();
                if(i == size-1) {
                    rightViewList.add(n.data);
                }
                if(n.left != null)  {
                    queue.add(n.left);
                }
                if(n.right != null) {
                    queue.add(n.right);
                }
            }
        }
        return rightViewList;
    }

    private static Map<Integer, Node> printTopViewIterative(Node node) {

        Map<Integer, Node> map = new TreeMap<Integer, Node>();  // (key, value) -> (index, node)
        Queue<Node> queue = new LinkedList<Node>();

        queue.offer(node);
        map.put(0, node);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++)   {
                Node n = queue.poll();
                int level = 0;

                Optional<Map.Entry<Integer, Node>> nodeLevel = map.entrySet().stream().filter(x-> Objects.equals(x.getValue(), n)).findFirst();

                if (nodeLevel.isPresent())   {
                    level = nodeLevel.get().getKey();
                }
                if (n.left != null)  {
                    queue.offer(n.left);
                    map.putIfAbsent(level-1, n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    map.putIfAbsent(level+1, n.right);
                }
            }

        }
        return map;
    }
}
