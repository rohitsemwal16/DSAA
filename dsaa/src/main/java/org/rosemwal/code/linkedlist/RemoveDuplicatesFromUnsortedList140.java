package org.rosemwal.code.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedList140 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    RemoveDuplicatesFromUnsortedList140() {
        this.head = null;
    }

    public void insertAtEnd(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private void removeDuplicates() {

        Set<Integer> set = new HashSet<>();

        Node temp = head;
        Node prev = temp;

        while (temp!=null)   {

            if (set.contains(temp.data)) {
                prev.next = temp.next;

            }   else {
                set.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }

    }

    private void printLinkedListTraversalFromHeadToTail(Node node) {

        node = node == null ? head : node;
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {

        RemoveDuplicatesFromUnsortedList140 list = new RemoveDuplicatesFromUnsortedList140();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(50);
        list.insertAtEnd(30);
        list.insertAtEnd(30);
        list.insertAtEnd(50);


        System.out.println("Printing the list before removing duplicates");
        list.printLinkedListTraversalFromHeadToTail(null);

        list.removeDuplicates();
        System.out.println("Printing the list after removing duplicates");
        list.printLinkedListTraversalFromHeadToTail(null);

    }
}
