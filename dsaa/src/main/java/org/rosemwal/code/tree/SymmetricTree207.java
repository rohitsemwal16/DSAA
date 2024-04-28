package org.rosemwal.code.tree;

public class SymmetricTree207 {

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

        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.left = new Node(4);

        System.out.println("IsSymmetric is " + isSymmetric(root));
    }
    
    public static boolean isSymmetric(Node root) {

        return root==null || isSymmetric1(root.left, root.right);
    }

    public static boolean isSymmetric1(Node left, Node right)  {

        if(left == null && right == null)  {
            return true;
        }

        if((left == null || right == null) || (left.data!=right.data))    {
            return false;
        }
        return isSymmetric1(left.left, right.right) && isSymmetric1(left.right, right.left);
    }
    
    
}
