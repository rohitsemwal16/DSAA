package org.rosemwal.dsa.linkedlist;


public class RemoveDuplicatesFromSortedList139 {
    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    RemoveDuplicatesFromSortedList139() {
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

        if(head == null || head.next == null)   {
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current!=null)   {

            while(current != null && (prev.data == current.data))    {
                current = current.next;
            }

            prev.next = current;
            prev = current;

            if (current!= null) {
                current = current.next;
            }
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

        RemoveDuplicatesFromSortedList139 list = new RemoveDuplicatesFromSortedList139();
        list.insertAtEnd(10);
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(40);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(50);


        System.out.println("Printing the list before removing duplicates");
        list.printLinkedListTraversalFromHeadToTail(null);

        list.removeDuplicates();
        System.out.println("Printing the list after removing duplicates");
        list.printLinkedListTraversalFromHeadToTail(null);

    }
}
