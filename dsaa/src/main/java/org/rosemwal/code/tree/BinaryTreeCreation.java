package org.rosemwal.code.tree;

import java.util.Scanner;

public class BinaryTreeCreation {

    static Scanner sc = null;
    public static void main(String args[])  {

        sc = new Scanner(System.in);
        Node node = createTree();

        inorderTraversal(node);
    }

    public static Node createTree() {

        System.out.println("Enter Data : ");
        int data = sc.nextInt();

        if(data == -1)  {
            return null;
        }

        Node node = new Node(data);

        System.out.println("Enter left data for " + data);
        node.left = createTree();

        System.out.println("Enter right data for " + data);
        node.right = createTree();

        return node;
    }

    public static void inorderTraversal(Node node)  {

        if(node != null) {
            inorderTraversal(node.left);
            System.out.println(node.data);
            inorderTraversal(node.right);
        }
    }

    static class Node   {
        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = this.right = null;
        }
    }

}
