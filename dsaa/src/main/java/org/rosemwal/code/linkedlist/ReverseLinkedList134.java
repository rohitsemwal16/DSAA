package org.rosemwal.code.linkedlist;

public class ReverseLinkedList134 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    ReverseLinkedList134() {
        this.head = null;
    }

    private Node reverseList() {

        Node current = head;
        Node prev = null;

        while(current != null)  {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
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

    private void printLinkedList(Node node) {

        node = node == null ? head : node;
        while(node!=null)   {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private Node reverseListRecursive(Node head) {

        if (head == null || head.next == null)  {
            return head;
        }

        Node newHead = reverseListRecursive(head.next);

        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        ReverseLinkedList134 linkedList = new ReverseLinkedList134();
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.insertAtEnd(50);

        linkedList.printLinkedList(null);

        linkedList.reverseList();
        System.out.print("LinkedList after reverse.. ");
        linkedList.printLinkedList(null);

        Node node  = linkedList.reverseListRecursive(linkedList.head);
        System.out.print("LinkedList after recursive reverse.. ");
        linkedList.printLinkedList(node);
    }


}