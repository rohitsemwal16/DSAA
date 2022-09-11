package org.rosemwal.code.tree;

/*
Created on 2022-09-11
 */

import java.util.*;

public class ViewsInTrees {

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

        node.right = new Node(15);
        node.right.right = new Node(20);

        List<Integer> leftViewList = printLeftViewIterative(node);
        System.out.println(Arrays.toString(leftViewList.toArray()));
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
}
