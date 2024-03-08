package org.rosemwal.code.linkedlist;

public class Segregate012LinkedList162 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Segregate012LinkedList162() {
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
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private Node sortList012() {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        Node temp0 = node0;
        Node temp1 = node1;
        Node temp2 = node2;

        Node temp = head;

        while (temp!=null)   {
            if (temp.data == 0)  {
                temp0.next = temp;
                temp0 = temp0.next;
            }   else if (temp.data == 1)    {
                temp1.next = temp;
                temp1 = temp1.next;
            }   else if (temp.data == 2)    {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        temp0.next = node1.next!= null ? node1.next : node2.next;
        temp1.next = node2.next;
        temp2.next = null;

        return node0.next;
    }

    public static void main(String args[]) {

        Segregate012LinkedList162 list = new Segregate012LinkedList162();
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.insertAtEnd(0);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(0);
        list.insertAtEnd(0);

        System.out.println("Printing the list before sorting");
        list.printLinkedListTraversalFromHeadToTail(null);

        Node node = list.sortList012();
        System.out.println("Printing the list after sorting");
        list.printLinkedListTraversalFromHeadToTail(node);
    }
}
