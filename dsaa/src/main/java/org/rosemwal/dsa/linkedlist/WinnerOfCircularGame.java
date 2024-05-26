package org.rosemwal.dsa.linkedlist;

public class WinnerOfCircularGame {

    class Node    {
        int data;
        Node next;

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    WinnerOfCircularGame()    {
        this.head = null;
        this.prev= null;
    }

    Node head;
    Node prev;

    public static void main(String[] args)  {

        WinnerOfCircularGame game = new WinnerOfCircularGame();

        System.out.println("Winner is" + game.getWinner(5,2));
    }

    private int getWinner(int n, int k) {

        constructCircularLinkedList(n);

        Node temp = head;

        while (temp.next.data != temp.data) {

            for (int i=0; i<k-1; i++) {
                prev = temp;
                temp = temp.next;
            }
            System.out.println("Skip "+ temp.data);

            prev.next = temp.next;
            temp = temp.next;

        }

        return temp.data;

    }

    private void constructCircularLinkedList(int n) {

        Node temp = head;

        for (int i=1; i<=n;i++) {
            Node newNode= new Node(i);
            if(temp == null)    {
                temp = newNode;
                head = newNode;
            }   else {
                temp.next = newNode;
                temp = temp.next;
            }
        }
        prev= temp;
        temp.next = head;
    }
}
