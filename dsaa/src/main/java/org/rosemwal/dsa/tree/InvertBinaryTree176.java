package org.rosemwal.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree176 {


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

        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(7);

        root.left.right = new Node(8);
        root.right =new Node(3);
        root.right.left = new Node(12);
        root.right.right = new Node(15);
        root.right.right.left = new Node(14);

        System.out.println("Height");
        System.out.println("Height of binary tree is "+ findInvertedBinaryTreeRecursive(root));
        System.out.println("Height of binary tree is "+ findInvertedBinaryTreeIterative(root));

        System.out.println(root);

    }

    private static Node findInvertedBinaryTreeRecursive(Node root) {

        if (root == null)   {
            return root;
        }

        findInvertedBinaryTreeRecursive(root.left);
        findInvertedBinaryTreeRecursive(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static Node findInvertedBinaryTreeIterative(Node root) {

        if(root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            Node node = queue.poll();
            if(node.left!=null) {
                queue.offer(node.left);
            }
            if(node.right!=null)    {
                queue.offer(node.right);
            }
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }
}
