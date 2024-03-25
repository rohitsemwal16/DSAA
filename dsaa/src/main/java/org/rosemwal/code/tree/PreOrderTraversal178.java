package org.rosemwal.code.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal178 {
    
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
    
    PreOrderTraversal178 () {
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

    private void preOrderTraversalRecursive(Node root) {

        if(root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);
    }

    private List<Integer> preOrderTraversalIterative(Node root) {

        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node node= root;

        while(true) {

            if(node!=null)  {
                list.add(node.data);
                stack.push(node);
                node = node.left;
            }   else {
                if(stack.isEmpty()) {
                    break;
                }
                Node pop = stack.pop();
                if(pop.right!=null) {
                    node = pop.right;
                }
            }
        }
        return list;
    }

    public static void main(String[] args)  {

        PreOrderTraversal178 traversal = new PreOrderTraversal178();
        traversal.createTree();

        System.out.println("Preorder Traversal recursive..");
        traversal.preOrderTraversalRecursive(traversal.root);

        System.out.println();
        System.out.println("Preorder Traversal iterative..");

        List<Integer> nodes = traversal.preOrderTraversalIterative(traversal.root);
        System.out.println(Arrays.toString(nodes.toArray()));

    }

}
