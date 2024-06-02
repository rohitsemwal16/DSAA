package org.rosemwal.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    public static void main(String[] args)  {
        
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.right = new Node(8);

        System.out.println(isCompleteTree(root));
    }
    static class Node  {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isCompleteTree(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {

            Node node= q.poll();
            if(node == null)
                break;

            q.offer(node.left);
            q.offer(node.right);
        }

        while(!q.isEmpty()) {
            if(q.poll()!=null)
                return false;
        }
        return true;
    }
}
