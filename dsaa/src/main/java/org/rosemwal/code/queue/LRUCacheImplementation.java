package org.rosemwal.code.queue;

import java.util.HashMap;
import java.util.Map;

class LRUCache  {

    Node head;
    Node tail;
    int capacity;
    int length;
    Map<Integer, Node> map;

    LRUCache(int capacity)  {

        this.capacity = capacity;
        head = null;
        tail = null;
        length = 0;
        this.map = new HashMap<>();
    }

    class Node  {

        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value)  {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    void insertInHead(int key, int value) {

        if (isFull())  {
            removeElementFromLinkedList(tail);
        }

        Node node = new Node(key, value);

        if (map.containsKey(key))   {
            map.remove(map.get(key));
            insertNodeAtBeginning(node);
        } else {
            map.put(key, node);
            insertNodeAtBeginning(node);
        }
    }

    int getKey(int key)    {

        if (map.containsKey(key))   {

            Node node = new Node(key, map.get(key).value);
            removeElementFromLinkedList(map.get(key));
            map.remove(map.get(key));
            insertNodeAtBeginning(node);
            return map.get(key).value;
        }   else {
            System.out.print("key Does not exist "+ key);
        }
        return -1;
    }

    private void insertNodeAtBeginning(Node node) {

        node.next=head;
        if(head!=null) {
            head.prev = node;
        }   else {
            tail=node;
        }
        head=node;

        length++;
    }

    void removeElementFromLinkedList(Node node) {

        if (node != head)   {
            node.prev.next = node.next;
            if(node ==tail) {
                tail = node.prev;
            }
        }   else if (node != tail) {
            node.next.prev = node.prev;
            if(node ==head) {
                head = head.next;
            }
        }

        map.remove(node.key);
        length--;
    }

    public void printElementsInCacheFromHeadToTail() {

        Node node = head;
        System.out.println("Elements in Cache are..");
        while(node!=null)   {
            System.out.print("Key " + node.key + " : Value " + node.value + " ,");
            node=node.next;
        }
    }

    boolean isFull()    {
        return length == capacity;
    }

    boolean isEmpty()   {
        return length == 0;
    }
}

public class LRUCacheImplementation   {

    public static void main(String[] args)  {

        LRUCache lruCache = new LRUCache(5);

        lruCache.insertInHead(1,1);
        lruCache.insertInHead(2,2);
        lruCache.insertInHead(3,3);
        lruCache.insertInHead(4,4);
        lruCache.insertInHead(5,5);
        lruCache.getKey(1);
        lruCache.insertInHead(6,6);
        lruCache.insertInHead(7,7);

        lruCache.printElementsInCacheFromHeadToTail();
    }
}
