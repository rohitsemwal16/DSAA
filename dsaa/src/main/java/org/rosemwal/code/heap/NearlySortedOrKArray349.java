package org.rosemwal.code.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedOrKArray349 {

    public static void main(String[] args)  {
        int[] arr = {10, 9, 8, 7, 4, 70, 60, 50};
        int k=4; // where each element is at most K away from its target position

        System.out.println("Sorted array " + Arrays.toString(sortingByHeap(arr, k))); //nlogk (top element is always min
    }

    private static int[] sortingByHeap(int[] arr, int k) {
        //Min heap

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<k+1; i++)    {
            pq.add(arr[i]);
        }
        int[] result = new int[arr.length];
        int index =0;

        for(int j=k+1; j<arr.length; j++)   {
            result[index++] = pq.peek();
            pq.poll();
            pq.add(arr[j]);
        }

        while(!pq.isEmpty())    {
            result[index++] = pq.poll();
        }

        return result;
    }
}
