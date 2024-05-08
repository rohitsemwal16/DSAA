package org.rosemwal.dsa.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList164 {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    MergeKSortedLinkedList164() {
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

    private Node mergeKSortedLinkedList(List<Node> node)    {

        Node finalHead = node.get(0);
        for(int i=1; i<node.size(); i++)    {
            finalHead = mergeTowSortedLinkedList(finalHead, node.get(i));
        }
        return finalHead;

    }

    private Node mergeKSortedLinkedListViaHeap(List<Node> nodes)    {

        PriorityQueue<Node> queue = new PriorityQueue<>(nodes.size(), Comparator.comparingInt(a -> a.data));
        Node dummyNode = new Node(1);
        Node tail = dummyNode;

        for(Node node : nodes)  {
            queue.offer(node);
        }

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            tail.next = poll;
            tail = tail.next;

            if (tail.next!=null)
                queue.offer(tail.next);
        }
        return dummyNode.next;
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

        MergeKSortedLinkedList164 linkedList1 = new MergeKSortedLinkedList164();
        linkedList1.insertAtEnd(2);
        linkedList1.insertAtEnd(4);
        linkedList1.insertAtEnd(8);
        linkedList1.insertAtEnd(10);

        MergeKSortedLinkedList164 linkedList2 = new MergeKSortedLinkedList164();
        linkedList2.insertAtEnd(1);
        linkedList2.insertAtEnd(3);
        linkedList2.insertAtEnd(3);
        linkedList2.insertAtEnd(6);
        linkedList2.insertAtEnd(11);
        linkedList2.insertAtEnd(14);

        MergeKSortedLinkedList164 linkedList3 = new MergeKSortedLinkedList164();
        linkedList3.insertAtEnd(5);
        linkedList3.insertAtEnd(7);
        linkedList3.insertAtEnd(8);
        linkedList3.insertAtEnd(9);
        linkedList3.insertAtEnd(12);
        linkedList3.insertAtEnd(13);

        System.out.println("Before list merge..");

        System.out.println("List1...");
        linkedList1.printFromHeadToTail(linkedList1.head);

        System.out.println("List2...");
        linkedList2.printFromHeadToTail(linkedList2.head);

        System.out.println("List3...");
        linkedList2.printFromHeadToTail(linkedList3.head);

        Node mergeNodeHead = linkedList2.mergeKSortedLinkedListViaHeap(Arrays.asList(linkedList1.head, linkedList2.head, linkedList3.head));
        System.out.println("After list merge..");
        linkedList2.printFromHeadToTail(mergeNodeHead);
    }
}
