package org.rosemwal.code.linkedlist;

public class AddTwoNumbersLinkedList143 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    AddTwoNumbersLinkedList143() {
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

    private Node addLinkedList(AddTwoNumbersLinkedList143 list1, AddTwoNumbersLinkedList143 list2) {

        Node temp1 = list1.head;
        Node temp2= list2.head;

        Node dummyNode = new Node(0);
        Node dummyTraversal = dummyNode;

        int carry = 0;

        while (temp1!=null || temp2!=null || carry !=0) {

            int firstListData = temp1!=null ? temp1.data : 0;
            int secListData = temp2!=null ? temp2.data : 0;

            int sum = firstListData + secListData + carry;
            int digit = sum%10;
            carry = sum/10;

            Node newNode = new Node(digit);
            dummyTraversal.next = newNode;
            dummyTraversal = dummyTraversal.next;

            temp1 = temp1!=null ? temp1.next : null;
            temp2 = temp2!=null ? temp2.next : null;

        }

        Node result = dummyNode.next;
        dummyNode.next = null;
        return result;
    }

    private void printLinkedListTraversalFromHeadToTail(Node node) {

        Node temp = node;
        while (temp!=null)  {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {

        AddTwoNumbersLinkedList143 list1 = new AddTwoNumbersLinkedList143();
        list1.insertAtEnd(2);
        list1.insertAtEnd(4);
        list1.insertAtEnd(3);

        System.out.println("First List");
        list1.printLinkedListTraversalFromHeadToTail(list1.head);

        AddTwoNumbersLinkedList143 list2 = new AddTwoNumbersLinkedList143();
        list2.insertAtEnd(5);
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);
        list2.insertAtEnd(1);

        System.out.println("Second List");
        list1.printLinkedListTraversalFromHeadToTail(list2.head);

        AddTwoNumbersLinkedList143 list3 = new AddTwoNumbersLinkedList143();

        Node node = list3.addLinkedList(list1, list2);
        System.out.println("Sum List");
        list3.printLinkedListTraversalFromHeadToTail(node);
    }

}
