package org.rosemwal.dsa.linkedlist;

public class ReverseLinkedListSizeK135 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    ReverseLinkedListSizeK135() {
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

    private Node reverseListSizeK(Node head, int k) {

        Node temp = head;
        Node prevNode = null;
        Node next = null;

        while(temp!=null)   {

            Node kthNode = getKthNode(temp, k);

            if (kthNode == null) {
                if(prevNode!=null) {
                    prevNode.next = temp;
                }
                break;

            }   else {

                next = kthNode.next;
                kthNode.next = null;

                reverse(temp);

                if (temp == head)    {
                    head = kthNode;
                }

                if (prevNode!=null)    {
                    prevNode.next = kthNode;
                }
                prevNode = temp;
                temp = next;
            }
        }
        return head;
    }

    private Node getKthNode(Node temp, int k) {

        while(temp!=null && (k-1)>0)   {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private Node reverse(Node current) {

        Node prev = null;

        while(current!=null)    {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private void printLinkedList(Node node) {

        node = node == null ? head : node;
        while(node!=null)   {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ReverseLinkedListSizeK135 linkedList = new ReverseLinkedListSizeK135();
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.insertAtEnd(50);
        linkedList.insertAtEnd(60);
        linkedList.insertAtEnd(70);
        linkedList.insertAtEnd(80);
        linkedList.insertAtEnd(90);
        linkedList.insertAtEnd(100);

        linkedList.printLinkedList(null);

        System.out.print("LinkedList before reversing in K size.. ");
        linkedList.printLinkedList(null);

        Node node  = linkedList.reverseListSizeK(linkedList.head, 3);
        System.out.print("LinkedList after recursive reversing in K size.. ");
        linkedList.printLinkedList(node);
    }

}
