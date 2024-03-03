package org.rosemwal.code.linkedlist;

public class MiddleElementLinkedList148 {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    MiddleElementLinkedList148()    {

        this.head = null;
    }

    private void insertAtEnd(int data) {

        Node node = new Node(data);
        if (head == null)   {
            head = node;
        } else {

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private int findMiddleElement() {

        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null)   {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public static void main(String[] args)  {

        MiddleElementLinkedList148 linkedList = new MiddleElementLinkedList148();

        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.insertAtEnd(50);
        linkedList.insertAtEnd(60);
        linkedList.insertAtEnd(70);

        System.out.println("Odd Middle element in linked list is " + linkedList.findMiddleElement());
        linkedList.insertAtEnd(80);
        System.out.println("Even Middle element in linked list is " + linkedList.findMiddleElement());
    }




}
