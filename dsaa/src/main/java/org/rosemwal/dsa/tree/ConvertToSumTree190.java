package org.rosemwal.dsa.tree;

import java.util.*;

public class ConvertToSumTree190 {
    
    static class Node  {
        int data;
        Node left;
        Node right;
        
        Node(int data)  {
            this.data = data;
            this.left = this.right =null;
        }
    }
    
    public static void main(String[] args)  {
        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(7);

        root.left.right = new Node(8);
        root.right =new Node(3);
        root.right.left = new Node(12);
        root.right.right = new Node(15);
        root.right.right.left = new Node(14);
        
        convertTreeToSumTree(root);
        System.out.println(Arrays.toString(printLevelOrderTraversal(root).toArray()));
    }


    // O(n) is time and space complexity
    private static List<Integer> printLevelOrderTraversal(Node node) {

        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> viewList = new ArrayList<Integer>();

        queue.offer(node);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0; i<size; i++)   {

                Node n = queue.poll();
                viewList.add(n.data);

                if (n.left != null)  {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }

        }
        return viewList;
    }

    private static int convertTreeToSumTree(Node root) {
        
        if(root == null)    {
            return 0;
        }
        root.data = root.data + convertTreeToSumTree(root.left) + convertTreeToSumTree(root.right);
        return root.data;
    }

}
