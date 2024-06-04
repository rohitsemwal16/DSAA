package org.rosemwal.dsa.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BstCreationInsertion231 {

    Node root;
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BstCreationInsertion231()  {
        this.root =null;
    }

    Node insert(int data, Node root)    {
        if (root==null) {
            root = new Node(data);
            return root;
        }

        if(data< root.data){
            root.left = insert(data, root.left);
        }   else if (data> root.data) {
            root.right = insert(data, root.right);
        }
        return root;
    }

    void insert(int data)   {
        
        this.root = insert(data, this.root);
    }

    private static Node search(Node root, int k) {

        if (root == null || root.data == k) {
            return root;
        }

        System.out.println("Searching .. "+ root.data);

        if (k<root.data)    {
            return search(root.left, k);
        }   else
            return search(root.right, k);
    }

    void insertIterative(int data)   {

        Node temp = root;
        if(root == null)    {
            root = new Node(data);
            return;
        }
        Node prev = null;

        while(temp!=null)   {
            prev = temp;
            if(data<temp.data)  {
                temp = temp.left;
            }   else if (data >temp.data)   {
                temp = temp.right;
            }
        }

        if (data<prev.data)  {
            prev.left = new Node(data);
        }   else {
            prev.right = new Node(data);
        }

    }

    private List<Integer> levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new LinkedList<>();

        while(!queue.isEmpty()) {

            int size = queue.size();

            for (int i=0; i<size; i++)   {

                Node node = queue.poll();
                list.add(node.data);
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

    public static void main(String[] args)  {

        BstCreationInsertion231 bstCreationInsertion = new BstCreationInsertion231();

//        bstCreationInsertion.insert(10);
//        bstCreationInsertion.insert(20);
//        bstCreationInsertion.insert(30);
//        bstCreationInsertion.insert(40);
//        bstCreationInsertion.insert(50);
//        bstCreationInsertion.insert(5);

        bstCreationInsertion.insertIterative(10);
        bstCreationInsertion.insertIterative(20);
        bstCreationInsertion.insertIterative(30);
        bstCreationInsertion.insertIterative(40);
        bstCreationInsertion.insertIterative(50);
        bstCreationInsertion.insertIterative(5);
        bstCreationInsertion.insertIterative(1);
        bstCreationInsertion.insertIterative(8);

        List<Integer> list = bstCreationInsertion.levelOrderTraversal(bstCreationInsertion.root);
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println("SearchedElement "+ search(bstCreationInsertion.root, 8).data);

    }

}
