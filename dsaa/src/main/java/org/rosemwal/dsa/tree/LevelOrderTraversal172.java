package org.rosemwal.dsa.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal172 {
    
    Node root;

    class Node{

        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    LevelOrderTraversal172 () {
        this.root = null;
    }

    void createTree()    {

        Node root = new Node(20);
        root.left = new Node(15);
        root.left.right = new Node(18);

        root.left.left = new Node(10);
        root.left.left.right = new Node(12);

        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(1);
        root.left.left.left.right = new Node(7);

        root.right = new Node(25);
        root.right.left = new Node(23);
        root.right.left.left = new Node(21);
        root.right.left.right = new Node(24);

        root.right.right = new Node(30);
        root.right.right.left = new Node(29);

        root.right.right.right = new Node(35);
        this.root = root;
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

        LevelOrderTraversal172 traversal = new LevelOrderTraversal172();
        traversal.createTree();

        System.out.println("Level Order Traversal..");
        List<Integer> list = traversal.levelOrderTraversal(traversal.root);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
