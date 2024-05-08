package org.rosemwal.dsa.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalRecursive177 {

    Node root;
    class Node  {
        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static void inorderTraversal(Node root) {

        if(root == null)    {
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.data +" ");
        inorderTraversal(root.right);
    }

    private List<Integer> inorderTraversalIterative(Node root)    {

        Node node = root;
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        
        while (true)   {

            if(node!=null) {
                stack.push(node);
                node = node.left;
            }   else {
                if (stack.isEmpty()) {
                    break;
                }
                    Node popNode = stack.pop();
                    list.add(popNode.data);
                    node = popNode.right;
                }
        }
        return list;
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

    public static void main(String[] args) {

    InorderTraversalRecursive177 tree = new InorderTraversalRecursive177();
    tree.createTree();
    inorderTraversal(tree.root);

    System.out.println("Iterative");
    List<Integer> list = tree.inorderTraversalIterative(tree.root);
    System.out.println(Arrays.toString(list.toArray()));

    }
}
