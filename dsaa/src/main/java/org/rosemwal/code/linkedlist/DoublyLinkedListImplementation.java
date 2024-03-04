package org.rosemwal.code.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return length == 0; // head ==null;
    }

    public int getLength()  {
        return length;
    }

    public void insertAtBeginning(int data)    {

        System.out.println("Inserting element at beginning of linked list " + data);
        Node node = new Node(data);

        if (isEmpty())    {
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
        length++;
    }

    public void removeElement(int data) {

        Node node = head;

        while(node!=null && node.data!=data)    {
            node = node.next;
        }

        if (node!=null) {

            if (node == head) {
                head = head.next;
                head.prev = null;
            }   else if (node == tail)  {
                tail = tail.prev;
                tail.next = null;
            }   else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            length--;
        }
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

    public Node reverseOrder() {

        Node current = head;
        Node prev = null;

        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        return prev.prev;
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

    public int getHead()  {
        return head.data;
    }

    public void setHead(Node node)  {
        this.head  = node;
    }

    public int getTail()  {
        return tail.data;
    }

    public List<int[]> findPairs(int sum) { // O(n) Time complexity

        Node temp1 = head;
        Node temp2 = tail;
        List<int[]> list = new ArrayList<>();

        while(temp1!=null && temp1.data < temp2.data)  {

            if ((temp1.data + temp2.data) == sum)  {
                list.add(new int[]{temp1.data, temp2.data});
                temp2 = temp2.prev;
                temp1 = temp1.next;
            }   else if ((temp1.data + temp2.data) > sum)   {
                temp2 = temp2.prev;
            }   else {
                temp1 = temp1.next;
            }
        }
        return list;
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

        System.out.println("Head is "+ doublyLinkedList.getHead());
        System.out.println("Tail is "+ doublyLinkedList.getTail());

        doublyLinkedList.removeElement(30);
        doublyLinkedList.printDoublyLinkedListFromHeadToEnd();

        doublyLinkedList.removeElement(40); // head
        doublyLinkedList.printDoublyLinkedListFromHeadToEnd();

        doublyLinkedList.removeElement(90); // tail
        doublyLinkedList.removeElement(10); // tail
        doublyLinkedList.insertAtBeginning(10);

        doublyLinkedList.printDoublyLinkedListFromHeadToEnd();

        System.out.println(" " + Arrays.toString(doublyLinkedList.findPairs(80).toArray()));

        System.out.println("Reversal DLL ..");
        doublyLinkedList.setHead(doublyLinkedList.reverseOrder());
        doublyLinkedList.printDoublyLinkedListFromHeadToEnd();

    }
}
