package org.rosemwal.code.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal179 {
    
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

    PostOrderTraversal179 () {
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

    private void postOrderTraversalRecursive(Node root) {

        if(root == null)
            return;

        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.print(root.data + " ");

    }

    private List<Integer> postOrderTraversalIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node node = root;

        while (true) {

            if(node!=null)  {
                stack.push(node);
                stack.push(node);

                node = node.left;
            }   else {
                if(stack.isEmpty()) {
                    break;
                }
                Node pop = stack.pop();
                if(!stack.empty() && stack.peek() == pop) {
                    node = pop.right;
                }   else {
                    list.add(pop.data);
                }
            }
        }
        return list;
    }

    public static void main(String[] args)  {

        PostOrderTraversal179 traversal = new PostOrderTraversal179();
        traversal.createTree();

        System.out.println("Preorder Traversal recursive..");
        traversal.postOrderTraversalRecursive(traversal.root);

        System.out.println("Preorder Traversal iterative..");
        List<Integer> list = traversal.postOrderTraversalIterative(traversal.root);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
