package org.rosemwal.code.tree;

public class CheckIfBstOrNot213 {

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

        System.out.println("Its BST " + isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    static boolean isBst(Node root, int minRange, int maxRange)    {

        if(root==null)
            return true;

        if(!(root.data>minRange&& root.data<maxRange))    {
            return false;
        }

        return isBst(root.left, minRange, root.data) && isBst(root.right, root.data, maxRange);
    }
}
