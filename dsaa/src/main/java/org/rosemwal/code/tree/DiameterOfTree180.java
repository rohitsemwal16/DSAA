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


    public static void main(String[] args)  {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.right = new Node(8);
         int arr[] = new int[1];

        System.out.println("Diameter is " + findDiameter(root, arr) + " " + arr[0]);
    }

    private static int findDiameter(Node root, int[] arr) {

        if (root == null) {
            return 0;
        }

        int left = findDiameter(root.left, arr);
        int right = findDiameter(root.right, arr);

        arr[0] = Math.max(arr[0], 1+left+right);

        return 1 + Math.max(left, right);

    }
}

