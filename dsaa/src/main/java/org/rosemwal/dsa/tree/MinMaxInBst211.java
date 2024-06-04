package org.rosemwal.dsa.tree;

public class MinMaxInBst211 {
    
    public static  void main(String[] args) {
        
        Node root1 = new Node(10);
        root1.left = new Node(2);

        root1.left.right = new Node(8);
        root1.right =new Node(15);
        root1.right.left = new Node(13);
        root1.right.right = new Node(20);
        root1.right.right.left = new Node(18);
        
        System.out.println("Min " + findMin(root1));
        System.out.println("Min " + findMax(root1));
    }

    private static Integer findMax(Node root) {

        Node node = root;

        int max = 0;

        if (node == null)
            return max;

        while (node!=null)  {
            max = node.data;
            node = node.right;
        }
        return max;
    }

    private static Integer findMin(Node root) {
        Node node = root;

        int min = -1;

        if (node == null)
            return min;

        while (node!=null)  {
            min = node.data;
            node = node.left;
        }

        return min;
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
}
