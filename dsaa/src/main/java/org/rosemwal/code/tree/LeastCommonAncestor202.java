package org.rosemwal.code.tree;

public class LeastCommonAncestor202 {

    Node root;

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data)  {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    LeastCommonAncestor202 () {
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

    public Node findLCA(Node root, int p, int q)    {

        if (root==null || root.data == p || root.data == q) {
            return root;
        }

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left == null)   {
            return right;
        }

        if (right == null)  {
            return left;
        }
        // left and right is not null
        return root;
    }

    public static void main(String[] args)  {

        LeastCommonAncestor202 traversal = new LeastCommonAncestor202();
        traversal.createTree();

        System.out.println("Sum of  all root to leaves path..");
        Node lca = traversal.findLCA(traversal.root, 7, 35);
        System.out.println("LCA is " + lca.data);

        Node lca1 = traversal.findLCA(traversal.root, 7, 15);
        System.out.println("LCA is " + lca1.data);
    }
}
