package org.rosemwal.dsa.linkedlist;

public class CLoneLinkedListRandomPointer163 {

    Node head;

    class Node {

        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    CLoneLinkedListRandomPointer163() {
        this.head = null;
    }

    void printLinkedListFromHeadToTail(Node node)    {

        node = node == null ? head : node;
        Node temp = node;
        while (temp!=null)  {
            System.out.print(temp.data + " " +  (temp.random!=null ? temp.random.data : null) + " -- ");
            temp = temp.next;
        }
        System.out.println();
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

    public void updateRandomPointerLink(int source, int destination)   {

        Node node = getNode(source);
        node.random = destination == -1 ? null : getNode(destination);
    }

    public Node getNode(int data)   {

        Node temp = head;

        while (temp!=null)   {
            if(temp.data == data)   {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    private Node cloneListWithRandomPointers(CLoneLinkedListRandomPointer163 linkedList) {

        // Step1: Modify existing list to insert clone list element in middle

        Node temp = linkedList.head;

        while (temp!=null)   {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        Node temp2 = linkedList.head;
        while(temp2!=null) {
            Node next = temp2.next;
            if(temp2.random == null) {
                next.random = null;
            } else{
                next.random = temp2.random.next;
            }
            temp2 = temp2.next.next;
        }

        Node dummyNode = new Node(-1);
        Node result = dummyNode;

        temp = linkedList.head;

        while (temp!=null)   {
            result.next = temp.next;
            result = result.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;

    }

    public static void main(String args[])  {

        CLoneLinkedListRandomPointer163 linkedList = new CLoneLinkedListRandomPointer163();

        linkedList.insertAtEnd(7);
        linkedList.insertAtEnd(13);
        linkedList.insertAtEnd(11);
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(1);

        linkedList.updateRandomPointerLink(7, -1);
        linkedList.updateRandomPointerLink(13, 7);
        linkedList.updateRandomPointerLink(11, 1);
        linkedList.updateRandomPointerLink(10, 11);
        linkedList.updateRandomPointerLink(1, 7);
        linkedList.printLinkedListFromHeadToTail(linkedList.head);

        System.out.println("After list cloning..");

        Node node = linkedList.cloneListWithRandomPointers(linkedList);
        linkedList.printLinkedListFromHeadToTail(node);
    }

}
