package org.rosemwal.dsa.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection136 {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    CycleDetection136()    {
        this.head = null;
    }

    void insertAtEnd(int data)  {

        Node newNode = new Node(data);
        Node node = head;

        if (node == null)    {
            head = newNode;
        }   else {
               while (node.next!=null)  {
                   node = node.next;
               }
               node.next = newNode;
        }
    }

    public void printFromHeadToTail()   {
        Node node = head;

        while(node != null) {
            System.out.println(node.data);
            node = node.next;

        }
    }

    public Node getNode(int data)   {
        Node node = head;

        while (node !=null && node.data!=data)  {
            node = node.next;
        }
        return node;
    }

    public boolean isLoopHashSet() { // T(n) -> O(n), Space -> O(n)
        Node node = head;

        Set<Node> set = new HashSet<>();

        while (node !=null && !set.contains(node))    {
            set.add(node);
            node = node.next;
        }

        if (node==null)  {
            System.out.println("Linked list does not contain a loop");
            return false;
        }
        System.out.println("Linked list contains a loop");
        return true;
    }

    public boolean isLoopHareTortoise() {

        Node slow = head;
        Node fast = head;

        while (fast !=null && fast.next != null)    {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)    {
                System.out.println("Linked list contains a loop - Hare Tortoise " + slow.data);
                return true;
            }
        }
        System.out.println("Linked list does not contains a loop - Hare Tortoise");
        return false;
    }

    public static void main(String args[])  {

        CycleDetection136 detection = new CycleDetection136();
        detection.insertAtEnd(10);
        detection.insertAtEnd(20);
        detection.insertAtEnd(30);
        detection.insertAtEnd(40);
        detection.insertAtEnd(50);
        detection.insertAtEnd(60);

        detection.printFromHeadToTail();
        detection.isLoopHashSet();
        detection.isLoopHareTortoise();

        Node node60 = detection.getNode(60);
        Node node30 = detection.getNode(30);
        node60.next = node30;
        detection.isLoopHashSet();
        detection.isLoopHareTortoise();

    }
}
