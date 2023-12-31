package org.rosemwal.code.tree;

public class SameOrMirrorTree196 {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args)  {

        Node root1 = new Node(10);
        root1.left = new Node(2);
        root1.left.left = new Node(7);

        root1.left.right = new Node(8);
        root1.right =new Node(3);
        root1.right.left = new Node(12);
        root1.right.right = new Node(15);
        root1.right.right.left = new Node(14);


        Node root2 = new Node(10);
        root2.left = new Node(2);
        root2.left.left = new Node(7);

        root2.left.right = new Node(8);
        root2.right =new Node(3);
        root2.right.left = new Node(12);
        root2.right.right = new Node(15);
        root2.right.right.left = new Node(14);

        Node root3 = new Node(10);
        root3.right = new Node(2);
        root3.right.right = new Node(7);

        root3.right.left = new Node(8);
        root3.left =new Node(3);
        root3.left.right = new Node(12);
        root3.left.left = new Node(15);
        root3.left.left.right = new Node(14);

        System.out.println("Same tree is "+ isSameTree(root1, root2));

        System.out.println("Mirror tree is "+ isMirrorTree(root1, root3));

    }

    private static boolean isMirrorTree(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }

        return isMirrorTree(root1.left, root2.right) && isMirrorTree(root1.right, root2.left);
    }

    public static boolean isSameTree(Node root1, Node root2)    {

        if (root1 == null && root2 == null)  {
            return true;
        }

        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public static int sumTree(Node root)    {

        if (root ==null)
            return 0;
        if(root.left == null && root.right ==null)  {
            return root.data;
        }

        root.data = sumTree(root.left) + sumTree(root.right);
        return root.data;
    }

}
