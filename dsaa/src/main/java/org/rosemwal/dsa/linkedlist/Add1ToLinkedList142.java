package org.rosemwal.dsa.linkedlist;

public class Add1ToLinkedList142 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Add1ToLinkedList142() {
        this.head = null;
    }


    public Node addOne(Node head)
    {
        Node reverseNode = reverse(head);

        Node temp = reverseNode;
        int carry = 1;
        Node prev = null;

        while (temp!=null && carry !=0)   {

            int sum = temp.data+carry;
            temp.data = sum%10;
            carry = sum/10;
            prev = temp;
            temp = temp.next;
        }

        if (carry!=0)   {
            prev.next = new Node(carry);
        }

        return reverse(reverseNode);

    }

    public static Node reverse (Node node)  {
        Node current = node;
        Node prev = null;

        while(current!=null)    {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
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

    public static void main(String args[]) {

        Add1ToLinkedList142 list1 = new Add1ToLinkedList142();
        list1.insertAtEnd(2);
        list1.insertAtEnd(4);
        list1.insertAtEnd(9);

        System.out.println("Before adding 1");
        list1.printLinkedListTraversalFromHeadToTail(null);

        list1.addOne(list1.head);
        System.out.println("After adding 1");

        list1.printLinkedListTraversalFromHeadToTail(null);

    }
}
