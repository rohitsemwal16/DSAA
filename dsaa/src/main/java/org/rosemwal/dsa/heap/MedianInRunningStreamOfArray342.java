package org.rosemwal.dsa.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInRunningStreamOfArray342 {

    static PriorityQueue<Integer> pqMax = new PriorityQueue(Collections.reverseOrder());
    static PriorityQueue<Integer> pqMin = new PriorityQueue();



    public static void main(String[] args)  {

        int[] nums = {5, 10, 15, 20, 1};

        for (int i=0; i<nums.length; i++)   {
            insertNum(nums[i]);
            getMedian();
        }

    }

    private static void insertNum(int num) {

        System.out.println("Inserting  "+ num);

        if (pqMax.isEmpty() || pqMax.peek() >= num) {
            pqMax.offer(num);
        }   else {
            pqMin.offer(num);
        }

        if (pqMax.size() > pqMin.size() + 1)    {
            pqMin.offer(pqMax.poll());
        }   else if (pqMax.size() < pqMin.size())   {
            pqMax.offer(pqMin.poll());
        }

        printMinMaxHeapContents();
    }

    private static void printMinMaxHeapContents() {

        System.out.println("Max heap contents " + Arrays.toString(pqMax.toArray()));
        System.out.println("Min heap contents " + Arrays.toString(pqMin.toArray()));
    }

    private static void getMedian() {

        double median = 0;

        if (pqMax.size() == pqMin.size())  {
            median = (pqMax.peek() + pqMin.peek())/2;
        }   else {
            median = pqMax.peek();
        }

        System.out.println("Median is "+ median);
    }
}
