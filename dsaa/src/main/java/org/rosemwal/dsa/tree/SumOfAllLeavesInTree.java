package org.rosemwal.dsa.tree;

import java.util.LinkedList;
import java.util.List;

public class SumOfAllLeavesInTree {

    Node root;

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    SumOfAllLeavesInTree () {
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

    static List<List<Integer>> resultList = new LinkedList<>();

    static int sum = 0;
    private void findSumOfRootToLeavesPath(Node root) {

        if(root == null)  {
            return;
        }

        if (root.left == null && root.right == null) {
            sum+=root.data;
        }

        findSumOfRootToLeavesPath(root.left);
        findSumOfRootToLeavesPath(root.right);
    }

    public static void main(String[] args)  {

        SumOfAllLeavesInTree traversal = new SumOfAllLeavesInTree();
        traversal.createTree();

        System.out.println("Sum of  all root to leaves path..");
        traversal.findSumOfRootToLeavesPath(traversal.root);
        System.out.println("Leaves Path sum is " + sum);
    }
}

