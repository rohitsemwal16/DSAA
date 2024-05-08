package org.rosemwal.dsa.linkedlist;

public class SegregateOddEvenIndexList167 {

    Node head;

    class Node  {
        int data;
        Node next;

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    void segregateOddEven() {

        if(head == null || head.next == null)   {
            return;
        }
        Node odd = head;
        Node even = head.next;
        Node evenTemp = even;

        while(evenTemp != null  && evenTemp.next != null)   {
            odd.next = odd.next.next;
            evenTemp.next = evenTemp.next.next;
            odd = odd.next;
            evenTemp = evenTemp.next;
        }

        odd.next = even;
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

        SegregateOddEvenIndexList167 list = new SegregateOddEvenIndexList167();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);

        System.out.println("Before odd even seggregations .. ");
        list.printNodes();

        list.segregateOddEven();
        System.out.println("After odd even seggregations .. ");
        list.printNodes();

    }
}
