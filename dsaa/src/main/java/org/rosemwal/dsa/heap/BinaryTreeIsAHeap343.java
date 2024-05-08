package org.rosemwal.dsa.heap;

import java.util.LinkedList;
import java.util.Queue;


// For a Binary Tree to be max heap - it should be either max/min heap and a complete binary tree
public class BinaryTreeIsAHeap343 {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args)  {

        Node root1 = new Node(30);
        root1.left = new Node(20);
        root1.left.left = new Node(10);

        root1.left.right = new Node(8);
        root1.right =new Node(19);
        root1.right.left = new Node(9);
        root1.right.right = new Node(2);
//        root1.right.right.left = new Node(14);
        
        boolean isHeap =  isHeap1(root1);
        boolean isCompleteTree = isCompleteTree(root1);
        System.out.println("Binary tree is a heap " + String.valueOf(isHeap && isCompleteTree));
    }

    static boolean isHeap1(Node tree)  {

        if (tree == null || tree.left == null || tree.right == null) {
            return true;
        }

        if (!(tree.data >= tree.left.data && tree.data >= tree.right.data )) {
            return false;
        }

        return isHeap1(tree.left) && isHeap1(tree.right);

    }

    static boolean isCompleteTree(Node tree)   {

        Queue<Node> queue = new LinkedList<>();

        queue.offer(tree);

        boolean isCompleteTree = false;

        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if (node == null)   {
                isCompleteTree = true;
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
            }

            if (node != null && isCompleteTree) {
                return false;
            }

        }

        return isCompleteTree;

    }
}
