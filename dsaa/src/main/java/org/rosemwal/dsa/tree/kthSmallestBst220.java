package org.rosemwal.dsa.tree;

import java.util.Stack;

public class kthSmallestBst220 {

    public static void main(String[] args)  {

        Node root1 = new Node(10);
        root1.left = new Node(2);

        root1.left.right = new Node(8);
        root1.right =new Node(15);
        root1.right.left = new Node(13);
        root1.right.right = new Node(20);
        root1.right.right.left = new Node(18);

        System.out.println("kth Smallest "+ findKthSmallestNode(root1, 4));

        findKthMinimumNodeRecursive(root1, 2);
        System.out.println("kth Largest "+ res);
    }

    static int count = 0;
    static int res = -1;
    static void findKthMinimumNodeRecursive(Node root, int k)    {

        if  (root == null)
            return;

        findKthMinimumNodeRecursive(root.left, k);
        count++;
        if(count == k)  {
            res = root.data;
            return;
        }
        findKthMinimumNodeRecursive(root.right, k);
    }
    
    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static int findKthSmallestNode(Node root, int k)  {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node node = root;
        int count = 0;
        while(true) {

            if(node.left!=null)  {
                node = node.left;
                stack.push(node);
            }   else    {
                if(stack.isEmpty())
                    return -1;
                Node pop = stack.pop();
                count++;
                if(count == k)  {
                    return pop.data;
                }
                if(pop.right!=null) {
                    stack.push(pop.right);
                    node = pop.right;
                }
            }
        }
    }
}