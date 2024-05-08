package org.rosemwal.dsa.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Only root to leaf path
public class PathSum208 {

    static List<List<Integer>> result = new LinkedList<>();

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static boolean doesPathExists(Node root, int num) {

        if (root == null)   {
            return false;
        }

        if (root.left == null && root.right == null && num-root.data == 0)  {
            return true;
        }

        return doesPathExists(root.left, num-root.data) || doesPathExists(root.right, num-root.data);
    }

    private static void getAllPathsWhoseSumIsX(Node root, List<Integer> sublist, int x) {

        if(root == null)    {
            return;
        }

        sublist.add(root.data);

        if (root.left == null && root.right == null && x-root.data == 0)    {
            result.add(new ArrayList<>(sublist));
        }

        getAllPathsWhoseSumIsX(root.left, sublist, x-root.data);
        getAllPathsWhoseSumIsX(root.right, sublist, x-root.data);
        sublist.remove(sublist.size()-1);
    }

    public static void main(String[] args)  {

        Node root1 = new Node(10);
        root1.left = new Node(2);
        root1.left.left = new Node(7);

        root1.left.right = new Node(8);
        root1.right =new Node(1);
        root1.right.left = new Node(9);
        root1.right.right = new Node(15);
        root1.right.right.left = new Node(14);

        System.out.println("Path exists "+ doesPathExists(root1, 40));

        getAllPathsWhoseSumIsX(root1, new ArrayList<>(), 20);
        System.out.println("All Paths  " + Arrays.toString(result.toArray()));
    }
}
