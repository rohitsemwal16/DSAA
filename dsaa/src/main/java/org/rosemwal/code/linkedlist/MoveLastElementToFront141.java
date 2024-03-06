package org.rosemwal.code.linkedlist;

public class MoveLastElementToFront141 {

    Node head;

    class Node  {
        int data;
        Node next;

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    private void moveLastNodeToFront() {

        Node last = head;
        Node secondLastNode = null;
        while (last.next!=null) {
            secondLastNode = last;
            last = last.next;
        }
        secondLastNode.next = null;

        last.next = head;
        head = last;
    }

    void insertAtEnd(int data)  {

        Node newNode = new Node(data);

        if (head == null)   {
            head = newNode;
        }   else {
            Node temp = head;

            while(temp.next!=null)  {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }
    void printNodes()    {

        Node temp = head;
        while(temp!=null)   {
            System.out.print(temp.data + " , ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args)  {

        MoveLastElementToFront141 list = new MoveLastElementToFront141();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);

        System.out.println("Before moving node to first.. ");
        list.printNodes();

        list.moveLastNodeToFront();
        System.out.println("After moving node to first.. ");
        list.printNodes();

    }
}
