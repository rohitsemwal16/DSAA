package org.rosemwal.dsa.tree;

public class IfBalancedBinaryTree185 {
    
    Node tree;
    
    static class Node  {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Function to check whether a binary tree is balanced or not.
    static boolean isBalanced(Node root)
    {

        if(isBalanced1(root) == -1) {
            return false;
        }

        return true;
    }

    static int isBalanced1(Node root)  {

        if(root == null)
            return 0;

        int left = isBalanced1(root.left);
        int right = isBalanced1(root.right);

        if(left == -1 || right == -1)   {
            return -1;
        }

        if(Math.abs(left-right)>1)  {
            return -1;
        }

        return 1+Math.max(left, right);
    }
    
    public static void main(String[] args)  {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.right = new Node(8);
        root.left.right.right = new Node(4);

        System.out.println("IsBalanced is " + isBalanced(root));
    }
}
