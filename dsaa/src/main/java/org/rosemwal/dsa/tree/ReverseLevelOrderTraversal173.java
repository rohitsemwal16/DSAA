package org.rosemwal.dsa.tree;

import java.util.*;

public class ReverseLevelOrderTraversal173 {
    
    Node root;

    class Node{

        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    ReverseLevelOrderTraversal173 () {
        this.root = null;
    }

    void createTree()    {

        Node root = new Node(20);
        root.left = new Node(15);
        root.left.right = new Node(18);

        root.left.left = new Node(10);
        root.left.left.right = new Node(12);

        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(1);
        root.left.left.left.right = new Node(7);

        root.right = new Node(25);
        root.right.left = new Node(23);
        root.right.left.left = new Node(21);
        root.right.left.right = new Node(24);

        root.right.right = new Node(30);
        root.right.right.left = new Node(29);

        root.right.right.right = new Node(35);
        this.root = root;
    }

    private void reverseLevelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()) {

            int size = queue.size();

            for (int i=0; i<size; i++)   {

                Node node = queue.poll();
                stack.add(node.data);
                if(node.right!=null)    {
                    queue.add(node.right);
                }
                if(node.left!=null) {
                    queue.add(node.left);
                }
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args)  {

        ReverseLevelOrderTraversal173 traversal = new ReverseLevelOrderTraversal173();
        traversal.createTree();

        System.out.println("Reverse Level Order Traversal..");
        traversal.reverseLevelOrderTraversal(traversal.root);
    }
}
