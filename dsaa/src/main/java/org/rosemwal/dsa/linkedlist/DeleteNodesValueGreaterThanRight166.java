package org.rosemwal.dsa.linkedlist;

public class DeleteNodesValueGreaterThanRight166 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    DeleteNodesValueGreaterThanRight166()   {
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

    Node compute(Node head)
    {

        if(head == null || head.next == null)   {
            return head;
        }

        Node temp = head;
        Node head1 = reverseList(temp);

        Node current = head1;
        while (current.next!=null)  {

            if(current.data > current.next.data)  {
                current.next = current.next.next;
            }   else {
                current = current.next;
            }
        }

        return reverseList(head1);
    }

    Node reverseList(Node head2)    {

        Node current = head2;
        Node prev = null;

        while(current!=null)    {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

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

    public static void main(String[] args)  {

        DeleteNodesValueGreaterThanRight166 linkedlist = new DeleteNodesValueGreaterThanRight166();

        linkedlist.insertAtEnd(12);
        linkedlist.insertAtEnd(15);
        linkedlist.insertAtEnd(10);
        linkedlist.insertAtEnd(11);
        linkedlist.insertAtEnd(5);
        linkedlist.insertAtEnd(6);
        linkedlist.insertAtEnd(2);
        linkedlist.insertAtEnd(3);

        Node x = linkedlist.compute(linkedlist.head);

        linkedlist.printLinkedListTraversalFromHeadToTail(x);

    }
}
