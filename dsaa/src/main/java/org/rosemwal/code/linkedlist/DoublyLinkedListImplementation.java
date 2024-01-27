package org.rosemwal.code.linkedlist;

class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    private class Node {

        Node next;
        Node prev;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public DoublyLinkedList()   {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty()    {
        return length ==0; // head ==null;
    }

    public int getLength()  {
        return length;
    }

    public void insertAtBeginning(int data)    {

        System.out.println("Inserting element at beginning of linked list " + data);
        Node node = new Node(data);

        if(isEmpty())    {
            tail = node;
        }   else {
            head.prev = node;
        }
        node.next = head;
        head = node;
        length++;
    }

    public void insertAtEnd(int data)    {

        System.out.println("Inserting element at end of linked list " + data);
        Node node = new Node(data);

        if (isEmpty())  {
            head = node;
        }   else {
            tail.next = node;
        }

        node.prev = tail;
        tail = node;
    }

    public void printDoublyLinkedListFromHeadToEnd() {

        Node start = head;
        System.out.println("Printing Doubly Linked List from head to end ..");

        while (start!=null)  {
            System.out.print(start.data + " , ");
            start = start.next;
        }
        System.out.println();
    }

    public void printDoublyLinkedListFromTailToStart() {

        Node end = tail;
        System.out.println("Printing Doubly Linked List from tail to start ..");

        while (end!=null)  {
            System.out.print(end.data + " , ");
            end = end.prev;
        }
        System.out.println();
    }
}

public class DoublyLinkedListImplementation {

    public static void main(String[] args)  {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtBeginning(10);
        doublyLinkedList.insertAtBeginning(20);
        doublyLinkedList.insertAtBeginning(30);
        doublyLinkedList.insertAtBeginning(40);

        doublyLinkedList.printDoublyLinkedListFromHeadToEnd();
        doublyLinkedList.printDoublyLinkedListFromTailToStart();

        doublyLinkedList.insertAtEnd(60);
        doublyLinkedList.insertAtEnd(70);
        doublyLinkedList.insertAtEnd(80);
        doublyLinkedList.insertAtEnd(90);

        doublyLinkedList.printDoublyLinkedListFromHeadToEnd();
        doublyLinkedList.printDoublyLinkedListFromTailToStart();
    }
}
