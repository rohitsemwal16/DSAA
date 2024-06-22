package org.rosemwal.dsa.queue;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LFUCache  {

    final int capacity;
    int minFrequency;
    int size;
    Map<Integer, DLLNodeList> frequencyListNodeMap;
    Map<Integer, DLLNode> keyValueMap;


    LFUCache(int capacity)  {
        this.capacity = capacity;
        this.minFrequency = 0;

        this.frequencyListNodeMap = new HashMap<>();
        this.keyValueMap = new HashMap<>();
    }

    public int get(int key) {

        DLLNode node = keyValueMap.get(key);

        if( node == null)   {
            return -1; // Key not found
        }

        updateNodeInList(node);
        printMap();
        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)  {
            return; // Total cache capacity should not be 0
        }

        if (keyValueMap.containsKey(key))   {
            DLLNode node = keyValueMap.get(key);
            node.value = value;

            updateNodeInList(node);
        }   else {
            size++;
            if (size>capacity)   {
                System.out.println("Size full");
                // Remove element from minFrequency List and remove based on LRU

                DLLNodeList nodeList = frequencyListNodeMap.get(minFrequency);
                keyValueMap.remove(nodeList.tail.prev.key); // tail.prev because we defined tail as dummy
                nodeList.removeNode(nodeList.tail.prev);
                size--;
            }

            minFrequency = 1;
            DLLNode dllNode = new DLLNode(key, value);
            DLLNodeList list = frequencyListNodeMap.getOrDefault(minFrequency, new DLLNodeList());
            list.addNodeToBeginning(dllNode);
            frequencyListNodeMap.put(minFrequency, list);
            keyValueMap.put(key, dllNode);
        }
        printMap();
    }

    private void updateNodeInList(DLLNode node) {

        // Step curr freq map se remove
        // Increased Freq map mai insert at head;

        int curFreq = node.frequency;
        DLLNodeList dllNodeList = frequencyListNodeMap.get(curFreq);
        dllNodeList.removeNode(node);

        // Update minFreq
        if(minFrequency == curFreq && dllNodeList.length ==0)   {
            minFrequency++; // Ad we will move this node to next frequency
        }

        node.frequency++;
        DLLNodeList dllNodeListForFrequency = frequencyListNodeMap.getOrDefault(node.frequency, new DLLNodeList());
        dllNodeListForFrequency.addNodeToBeginning(node);
        frequencyListNodeMap.put(node.frequency, dllNodeListForFrequency);
    }

    class DLLNode   {

        int key;
        int value;
        int frequency;
        DLLNode next;
        DLLNode prev;

        DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
            this.next = this.prev = null;
        }
    }

    class DLLNodeList   {

        DLLNode head;
        DLLNode tail;
        int length;

        DLLNodeList()   {
            head = new DLLNode(0, 0);
            tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        // add Node to head of linkedlist
        void addNodeToBeginning(DLLNode node)   {

            this.length++;
            System.out.println("Adding  node to beginning" + node.key);

            // 4 pointer update is needed
            DLLNode next = head.next;
            node.next = next;
            node.prev = head;
            head.next =node;
            next.prev = node;
        }

        void removeNode(DLLNode node)    {

            System.out.println("Removing node " + node.key);

            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.length--;
        }
    }

    void printMap()  {

        System.out.println("Key Value Map "+ keyValueMap.toString());

        for (Map.Entry<Integer, DLLNodeList> m : frequencyListNodeMap.entrySet()) {
            System.out.print("Freq Key Map " + m.getKey() + " -----> ");

            DLLNodeList node = m.getValue();
            DLLNode temp = node.head.next;

            while (temp!=node.tail)  {
                System.out.print("Freq Val Map " + temp.key + " -" + temp.value + " --- ");
                temp = temp.next;
            }
            System.out.println();

        }
    }
}


public class LFUCacheImplementation {

    public static void main(String[] args)  {

        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1, 10);
        lfuCache.put(3, 15);
        lfuCache.put(2, 12);
        lfuCache.get(3);
        lfuCache.put(4, 20);
        lfuCache.get(2);
        lfuCache.put(4,2);
        lfuCache.put(5,25);
    }

}
