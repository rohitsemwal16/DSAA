package org.rosemwal.dsa.tree;

public class ViewsRecursiveTrees180 {

static class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
    static int maxLevel = 0;

    public static void main(String[] args)  {

        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(7);

        root.left.right = new Node(8);
        root.right =new Node(3);
        root.right.left = new Node(12);
        root.right.right = new Node(15);
        root.right.right.left = new Node(14);

        System.out.println("Left View");
        printLeftView(root, 1);

        maxLevel = 0;
        System.out.println("\nRight View");
        printRightView(root, 1);

    }

    private static void printLeftView(Node root, int level) {

        if(root == null)    {
            return;
        }

        System.out.println("Recursion" +root.data);

        if (maxLevel<level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }

        printLeftView(root.left, level+1);
        printLeftView(root.right, level+1);
    }

    private static void printRightView(Node root, int level) {

        if (root == null)    {
            return;
        }
        if (maxLevel<level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        printRightView(root.right, level+1);
        printRightView(root.left, level+1);
    }
}

