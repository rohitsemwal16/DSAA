package org.rosemwal.dsa.tree;

import java.util.*;

public class SpiralLevelOrderTraversal {

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

    SpiralLevelOrderTraversal () {
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

    private List<List<Integer>> spiralLevelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();

        int count =1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();

                for (int i = 0; i < size; i++) {

                    Node poll = queue.poll();
                    if (count % 2 == 0) {
                        sublist.add(0,poll.data);
                    }   else {
                        sublist.add(poll.data);
                    }

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                result.add(sublist);
            count++;
        }
        return result;
    }

    public static void main(String[] args)  {

        SpiralLevelOrderTraversal traversal = new SpiralLevelOrderTraversal();
        traversal.createTree();

        System.out.println("Spiral Level Order Traversal..");
        List<List<Integer>> list = traversal.spiralLevelOrderTraversal(traversal.root);

        System.out.println(Arrays.toString(list.stream().flatMap(List::stream).toArray()));
    }
}
