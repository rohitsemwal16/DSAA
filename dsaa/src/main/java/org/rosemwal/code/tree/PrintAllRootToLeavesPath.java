package org.rosemwal.code.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintAllRootToLeavesPath {
    
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

    PrintAllRootToLeavesPath () {
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
    
    static List<List<Integer>> resultList = new LinkedList<>();

    private void findAllRootToLeavesPath(Node root, List<Integer> arr) {
        
        if(root == null)    {
            return; 
        }
        
        arr.add(root.data);
        
        if (root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(arr));
        }
        
        findAllRootToLeavesPath(root.left, arr);
        findAllRootToLeavesPath(root.right, arr);
        
        arr.remove(arr.size()-1);
    }
    
    

    public static void main(String[] args)  {

        PrintAllRootToLeavesPath traversal = new PrintAllRootToLeavesPath();
        traversal.createTree();

        System.out.println("Printing all root to leaves path..");
        List<Integer> arr = new LinkedList<>();
        traversal.findAllRootToLeavesPath(traversal.root, arr);
        
        for(List<Integer> list : resultList) {
            System.out.println("Leaves Path is " + Arrays.toString(list.toArray()));
        }
    }

    
}
