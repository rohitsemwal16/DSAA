package org.rosemwal.dsa.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsCousinsInBinaryTree {

    static class Node {

        int val;
        Node left;
        Node right;

        Node(int data) {
            this.val = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(7);

        root.left.right = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(12);
        root.right.right = new Node(15);
        root.right.right.left = new Node(14);

        System.out.println(isCousins(root, 2, 3));
        System.out.println(isCousins(root, 7, 15));

    }

    public static boolean isCousins(Node root, int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, Integer> parentChildMapNode = new HashMap<>();

        while(!queue.isEmpty()) {

            boolean xPresentInLevel = false;
            boolean yPresentInLevel = false;

            int size = queue.size();

            for(int i=0; i<size; i++)   {

                Node poll = queue.poll();

                if(poll.val == x )  {
                    xPresentInLevel = true;
                } else if (poll.val == y )  {
                    yPresentInLevel = true;
                }

                if(poll.left!=null) {
                    parentChildMapNode.put(poll.left.val, poll.val);
                    queue.offer(poll.left);
                }
                if(poll.right!=null)    {
                    parentChildMapNode.put(poll.right.val, poll.val);
                    queue.offer(poll.right);
                }
            }

            if (xPresentInLevel && yPresentInLevel &&  parentChildMapNode.get(x) != parentChildMapNode.get(y))    {
                return true;
            }
        }
        return false;

    }
}
