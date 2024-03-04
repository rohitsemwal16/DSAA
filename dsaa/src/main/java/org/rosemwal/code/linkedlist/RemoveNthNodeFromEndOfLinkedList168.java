package org.rosemwal.code.linkedlist;

public class RemoveNthNodeFromEndOfLinkedList168 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    RemoveNthNodeFromEndOfLinkedList168() {
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

    private void printLinkedListTraversalFromHeadToTail(Node node) {

        node = node == null ? head : node;
        Node temp = node;
        while (temp!=null)  {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void removeFromEnd(int n) {

        Node slow = head;
        Node fast = head;

        while(n>=0 && fast!=null)   {
            fast = fast.next;
            n--;
        }
        while(fast!=null)   {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow == head) {
            Node node = slow;
            head = node.next;
            node.next = null;
        }   else {
            Node nodeToBeRemoved = slow.next;
            slow.next = slow.next.next;
            nodeToBeRemoved.next = null;
        }

    }

    public static void main(String args[]) {

        RemoveNthNodeFromEndOfLinkedList168 list = new RemoveNthNodeFromEndOfLinkedList168();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.printLinkedListTraversalFromHeadToTail(null);

        int index = 5;
        list.removeFromEnd(index);

        System.out.println("LL after removing element from " + index);
        list.printLinkedListTraversalFromHeadToTail(null);
    }




}
