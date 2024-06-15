package org.rosemwal.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfAllLeavesAreAtSameLevel194 {

    public static void main(String[] args)  {

        String str = "1";

        System.out.println(find(str));
        System.out.println(find("899"));

        System.out.println(find("98"));


//        Node root1 = new Node(10);
//        root1.left = new Node(2);
//
//        root1.left.right = new Node(8);
//        root1.right =new Node(15);
//        root1.right.left = new Node(13);
//        root1.right.right = new Node(20);
//        root1.right.right.left = new Node(18);
//
//        System.out.println("Leaves in same level " + isLeavesInSameLevel(root1));

    }

    private static String find(String str) {
        String output = "";

        char[] charArray = str.toCharArray();

        if (charArray[0] != '1')    {
            output += charArray[0] -'1';
        }
        for(int k=1; k<charArray.length; k++)   {
            output = output + "9";
        }

        return output;

    }

    private static boolean isLeavesInSameLevel(Node root) {

        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        int leafLevel = 0;

        while(!queue.isEmpty()) {

            level++;
            int size = queue.size();

            for (int i=0; i<size; i++)  {

                Node poll = queue.poll();

                if (poll.left == null && poll.right == null) {
                    if (leafLevel == 0) {
                        leafLevel = level;
                    } else if (level != leafLevel) {
                        System.out.println("Node " + poll.data + " has different level than other leaf - current level" + level +
                                " first encountered leaf level " + leafLevel);
                        return false;
                    }
                }

                if (poll.left != null)  {
                    queue.offer(poll.left);
                }
                if (poll.right != null)  {
                    queue.offer(poll.right);
                }
            }
        }
        return true;
    }

    static class Node   {
        
        int data;
        Node left; 
        Node right;
        
        Node (int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

}
