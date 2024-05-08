package org.rosemwal.dsa.linkedlist;

public class StartingOfLoop138 {

    Node head;
    class Node  {

        int data;
        Node next;

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    StartingOfLoop138() {
        this.head = null;
    }

    public void insertAtEnd(int data)   {
        Node node = new Node(data);

        if(head == null)    {
            head = node;
        }   else {
            Node temp = head;

            while(temp.next!=null)  {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public Node findStartingOfLoop()    {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)    {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)   {
                slow = head;

                while(slow!=fast)   {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    private int findLengthOfLoop() {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)    {
                return findLengthOfLoop(slow, fast);
            }
        }

        return 0;
    }

    private int findLengthOfLoop(Node slow, Node fast)  {
        int count = 1;
        fast = fast.next;

        while(slow != fast) {
            fast = fast.next;
            count++;
        }
        return count;
    }

    private Node getNode(int data) {

        Node temp = head;
        while(temp!=null)   {
            if(temp.data == data)   {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args)  {

        StartingOfLoop138 linkedList = new StartingOfLoop138();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(15);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(13);
        linkedList.insertAtEnd(6);
        linkedList.insertAtEnd(7);
        linkedList.insertAtEnd(8);
        linkedList.insertAtEnd(9);

        Node node9 = linkedList.getNode(9);
        Node node15 = linkedList.getNode(15);
        node9.next = node15;

        Node startingLoop = linkedList.findStartingOfLoop();
        System.out.println("Starting point of loop is "+ startingLoop.data);

        int length = linkedList.findLengthOfLoop();
        System.out.println("Length of loop of linkedlist is " + length);

    }
}
