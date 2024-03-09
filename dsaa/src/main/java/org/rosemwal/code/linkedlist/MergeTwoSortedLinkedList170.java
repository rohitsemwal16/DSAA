package org.rosemwal.code.linkedlist;

public class MergeTwoSortedLinkedList170 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    MergeTwoSortedLinkedList170() {
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

    private Node mergeTowSortedLinkedList(Node head1, Node head2) {

        Node t1 = head1;
        Node t2 = head2;

        Node newNode = new Node(-1);
        Node temp = newNode;

        while(t1 != null && t2 != null)  {

            if(t1.data < t2.data)   {
                temp.next = t1;
                t1 = t1.next;
            }   else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        if(t2!=null)    {
            temp.next=t2;
        }
        if(t1!=null)    {
            temp.next = t1;
        }

        return newNode.next;
    }

    public void printFromHeadToTail(Node node)   {
        Node temp = node!=null ? node : head;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args)  {

        MergeTwoSortedLinkedList170 linkedList1 = new MergeTwoSortedLinkedList170();
        linkedList1.insertAtEnd(2);
        linkedList1.insertAtEnd(4);
        linkedList1.insertAtEnd(8);
        linkedList1.insertAtEnd(10);

        MergeTwoSortedLinkedList170 linkedList2 = new MergeTwoSortedLinkedList170();
        linkedList2.insertAtEnd(1);
        linkedList2.insertAtEnd(3);
        linkedList2.insertAtEnd(3);
        linkedList2.insertAtEnd(6);
        linkedList2.insertAtEnd(11);
        linkedList2.insertAtEnd(14);

        System.out.println("Before list merge..");

        System.out.println("List1...");
        linkedList1.printFromHeadToTail(linkedList1.head);

        System.out.println("List2...");
        linkedList2.printFromHeadToTail(linkedList2.head);

        Node mergeNodeHead = linkedList2.mergeTowSortedLinkedList(linkedList1.head, linkedList2.head);
        System.out.println("After list merge..");
        linkedList2.printFromHeadToTail(mergeNodeHead);
    }
}
