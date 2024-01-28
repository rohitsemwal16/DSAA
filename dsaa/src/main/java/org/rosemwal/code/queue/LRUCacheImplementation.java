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

    void put(int key, int value) {

        if (isFull())  {
            removeElementFromLinkedList(tail);
        }

        Node node = new Node(key, value);

        if (map.containsKey(key))   {
            removeElementFromLinkedList(map.get(key));
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

        if (node!=null) {
            map.remove(node.key);

            if (node == head) {
                head = head.next;
                head.prev = null;
            }   else if (node == tail)  {
                tail = tail.prev;
                tail.next = null;
            }   else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            length--;
        }
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

        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);
        lruCache.getKey(1);
        lruCache.put(6,6);
        lruCache.put(7,7);

        lruCache.printElementsInCacheFromHeadToTail();
    }
}
