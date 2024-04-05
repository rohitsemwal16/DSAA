package org.rosemwal.code.tree;

import java.util.*;

public class RootToNodePathPrint {


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

    RootToNodePathPrint () {
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
        root.right.left.right = new Node(12);

        root.right.right = new Node(30);
        root.right.right.left = new Node(29);

        root.right.right.right = new Node(12);
        this.root = root;
    }

    private boolean printSingleNodePathToRootPath(Node root, List<Integer> arr, int x) {

        if (root == null)   {
            return false;
        }

        arr.add(root.data);

        if(root.data == x)  {
            return true;
        }

        if (printSingleNodePathToRootPath(root.left, arr, x) || printSingleNodePathToRootPath(root.right, arr, x))  {
            return true;
        }

        arr.remove(arr.size()-1);
        return false;
    }

    static List<List<Integer>> result = new ArrayList<>();

    private void printMultipleNodePathToRootPath(Node root, List<Integer> arr, int x) {

        if (root == null)   {
            return;
        }

        arr.add(root.data);

        if(root.data == x)  {
            result.add(new ArrayList<>(arr));
        }

        printMultipleNodePathToRootPath(root.left, arr, x);
        printMultipleNodePathToRootPath(root.right, arr, x);

        arr.remove(arr.size()-1);
    }

    public static void main(String[] args)  {

        RootToNodePathPrint traversal = new RootToNodePathPrint();
        traversal.createTree();

        System.out.println("Reverse Level Order Traversal..");
        List<Integer> arr = new LinkedList<>();
        traversal.printSingleNodePathToRootPath(traversal.root, arr, 12);
        System.out.println("Single Path is "+ Arrays.toString(arr.toArray()));

        arr = new LinkedList<>();

        traversal.printMultipleNodePathToRootPath(traversal.root, arr, 12);
        System.out.println("Multiple Path is "+ Arrays.toString(result.toArray()));

    }
}
