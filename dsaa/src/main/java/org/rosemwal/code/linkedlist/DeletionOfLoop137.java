package org.rosemwal.code.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DeletionOfLoop137 {

    DeletionOfLoop137.Node head;
    class Node  {

        int data;
        DeletionOfLoop137.Node next;

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    DeletionOfLoop137() {
        this.head = null;
    }

    private Node getNode(int data) {

        Node temp = head;
        while(temp!=null)   {
            if(temp.data == data)   {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void insertAtEnd(int data)   {
        Node node = new Node(data);

        if(head == null)    {
            head = node;
        }   else {
            Node temp = head;

            while(temp.next!=null)  {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private void deleteLoop() {

        Node node = findPreviousStartingLoopElement();

        System.out.println("Preveious to loop starting node " + node.data);
        node.next = null;
    }

    private Node findPreviousStartingLoopElement() {

        Node slow = head;
        Node fast = head;
        Node prevLoopStartingNode = null;

        while(fast != null && fast.next != null)    {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)    {

                slow = head;
                while(slow!=fast)   {
                    prevLoopStartingNode = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
                return prevLoopStartingNode;
            }
        }
        return prevLoopStartingNode;
    }

    private void printLinkedList() {

        Set<Node> set = new HashSet<>();

        Node temp = head;
        while(temp!= null && !set.contains(temp))  {
            System.out.print(temp.data + " ,  ");
            set.add(temp);
            temp = temp.next;
        }

        if(set.contains(temp))  {
            System.out.println("There was a loop at " + temp.data);
        }
    }

    public static void main(String[] args)  {

        DeletionOfLoop137 linkedList = new DeletionOfLoop137();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(15);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(13);
        linkedList.insertAtEnd(6);
        linkedList.insertAtEnd(7);
        linkedList.insertAtEnd(8);
        linkedList.insertAtEnd(9);

        Node node9 = linkedList.getNode(9);
        Node node15 = linkedList.getNode(15);
        node9.next = node15;

        linkedList.printLinkedList();
        linkedList.deleteLoop();
        linkedList.printLinkedList();
    }
}
