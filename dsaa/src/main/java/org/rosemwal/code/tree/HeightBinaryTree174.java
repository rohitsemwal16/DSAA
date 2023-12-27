package org.rosemwal.code.tree;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class HeightBinaryTree174 {

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
        System.out.println("Height of binary tree is "+ findHeightRecursive(root));
        System.out.println("Height of binary tree is "+ findHeightIterative(root));

    }

    private static int findHeightIterative(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height=0;

        while(!queue.isEmpty()) {

            int size = queue.size();
            height++;

            for(int i=0;i<size;i++) {

                Node node = queue.poll();
                if(node.left!=null)   {
                    queue.offer(node.left);
                }
                if(node.right!=null)    {
                    queue.offer(node.right);
                }
            }
        }
        return height;
    }

    private static int findHeightRecursive(Node root) {

        if(root == null)    {
            return 0;
        }

        return (1+max(findHeightRecursive(root.left), findHeightRecursive(root.right)));
    }
}
