package org.rosemwal.code.tree;

public class DiameterOfTree180 {

    static class Node   {
        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = this.right = null;
        }
        }

    static int max = 0;

    public static void main(String[] args)  {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.right = new Node(8);

        System.out.println("Diameter is " + findDiameter(root) + " " + max);
    }

    private static int findDiameter(Node root) {

        if (root == null) {
            return 0;
        }

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);

        max = Math.max(max, 1+left+right);

        return 1 + Math.max(left, right);

    }
}

