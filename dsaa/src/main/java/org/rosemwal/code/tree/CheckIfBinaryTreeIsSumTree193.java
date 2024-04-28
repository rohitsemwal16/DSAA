package org.rosemwal.code.tree;

import java.util.LinkedList;
import java.util.List;

public class CheckIfBinaryTreeIsSumTree193 {


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

    CheckIfBinaryTreeIsSumTree193 () {
        this.root = null;
    }

    void createTree()    {

        Node root = new Node(62);
        root.left = new Node(16);
        root.left.right = new Node(8);
        root.left.right.right = new Node(8);

        root.right = new Node(15);
        root.right.left = new Node(4);
        root.right.left.left = new Node(4);
        root.right.right = new Node(7);
        this.root = root;
    }

    static int sum = 0;
    boolean isSumTree(Node root)
    {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (!isSumTree(root.left) || !isSumTree(root.right))    {
            return false;
        }

        if(root.left == null)   {
            if (root.data!=root.right.data) {
                return false;
            }   else    {
                root.data += root.right.data;
            }
        }

        if(root.right == null)   {
            if (root.data!=root.left.data) {
                return false;
            }   else    {
                root.data +=root.left.data;
            }
        }

        if ((root.left.data + root.right.data) != root.data)  {
            return false;
        }   else    {
            root.data = root.left.data + root.right.data;
        }
        System.out.println(root.data+ " "+  root.left.data+ " "+ root.right.data);




        return true;
    }

    public static void main(String[] args)  {

        CheckIfBinaryTreeIsSumTree193 traversal = new CheckIfBinaryTreeIsSumTree193();
        traversal.createTree();

        System.out.println("Sum of  all root to leaves path..");
        boolean isSumTree = traversal.isSumTree(traversal.root);
        System.out.println("Is Sum tree " + isSumTree);
    }


}
