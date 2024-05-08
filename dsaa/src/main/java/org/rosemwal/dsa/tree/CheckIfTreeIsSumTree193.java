package org.rosemwal.dsa.tree;

import java.util.*;

public class CheckIfTreeIsSumTree193 {


    static class Node  {
        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = this.right =null;
        }
    }

    public static void main(String[] args)  {
        Node root = new Node(41);
        root.left = new Node(15);
        root.left.left = new Node(7);

        root.left.right = new Node(8);
        root.right =new Node(26);
        root.right.left = new Node(12);
        root.right.right = new Node(14);
        root.right.right.left = new Node(14);

        System.out.println(checkIfTreeIsSumTree(root));
    }

    private static boolean checkIfTreeIsSumTree(Node root) {

        if(root == null)    {
            return true;
        }

        if(root.left!=null && root.right!= null) {
            if (root.data != ((root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0))) {
                return false;
            }
        }

        return checkIfTreeIsSumTree(root.left) && checkIfTreeIsSumTree(root.right);
    }

    // O(n) is time and space complexity
    private static List<Integer> printLevelOrderTraversal(Node node) {

        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> viewList = new ArrayList<Integer>();

        queue.offer(node);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0; i<size; i++)   {

                Node n = queue.poll();
                viewList.add(n.data);

                if (n.left != null)  {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }

        }
        return viewList;
    }
}
