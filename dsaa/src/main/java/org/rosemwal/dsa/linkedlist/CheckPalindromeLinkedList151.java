package org.rosemwal.dsa.linkedlist;

public class CheckPalindromeLinkedList151 {
    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    CheckPalindromeLinkedList151() {
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

    public boolean isPalindrome(Node head) {

        if(head == null || head.next == null)   {
            return true;
        }

        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null && fast.next.next!=null)   {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node slowNext = slow.next;
        Node reverseHead = reverse(slow.next);

        while(reverseHead!=null)    {

            if(head.data!=reverseHead.data) {
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }

    private Node reverse(Node node) {

        Node prev = null;

        while(node!=null)   {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String[] args)  {

        CheckPalindromeLinkedList151 linkedList = new CheckPalindromeLinkedList151();
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(10);
//        linkedList.insertAtEnd(10);

        System.out.println("Palindrome " + String.valueOf(linkedList.isPalindrome(linkedList.head)));
    }
}

