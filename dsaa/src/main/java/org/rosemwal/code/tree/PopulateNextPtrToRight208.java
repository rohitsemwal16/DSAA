package org.rosemwal.code.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulateNextPtrToRight208 {
    
    Node root;

    class Node{

        int data;
        Node left;
        Node right;
        Node next;

        Node(int data)  {
            this.data = data;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    PopulateNextPtrToRight208 () {
        this.root = null;
    }

    void createTree()    {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);


        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        this.root = root;
    }

    private void printLevelOrderTraversal(Node root) {

        

    }

    private void populateNextPtr(Node root) {


        if (root == null)   {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i=0;i<size; i++)  {

                Node node = queue.poll();
                Node next = i!=(size-1) ? queue.peek() : null;
                node.next = next;

                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null)    {
                    queue.offer(node.right);
                }
            }

        }
    }

    private List<Node> levelOrderTraversal(Node root) {

        {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            List<Node> list = new LinkedList<>();

            while(!queue.isEmpty()) {

                int size = queue.size();

                for (int i=0; i<size; i++)   {

                    Node node = queue.poll();
                    list.add(node);
                    if(node.left!=null) {
                        queue.add(node.left);
                    }
                    if(node.right!=null)    {
                        queue.add(node.right);
                    }
                }
            }
            return list;
        }
    }

    public static void main(String[] args)  {

        PopulateNextPtrToRight208 populateNextPtrToRight208 = new PopulateNextPtrToRight208();
        populateNextPtrToRight208.createTree();

        System.out.println("Populating next ptr..");
        populateNextPtrToRight208.populateNextPtr(populateNextPtrToRight208.root);

        List<Node> x = populateNextPtrToRight208.levelOrderTraversal(populateNextPtrToRight208.root);
        for(int i=0;i<x.size(); i++) {
            System.out.println(x.get(i).data + " "+ (x.get(i).next!=null? x.get(i).next.data : null));
        }
    }
}
