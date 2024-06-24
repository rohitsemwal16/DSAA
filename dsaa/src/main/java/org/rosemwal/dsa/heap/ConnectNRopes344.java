package org.rosemwal.dsa.heap;

import java.util.PriorityQueue;

public class ConnectNRopes344 {

    public static void main(String[] args)  {

        int[] arr = {2,5,4,8,6,9};

        System.out.println(findMinCostToConnectRopes(arr));
    }

    private static int findMinCostToConnectRopes(int[] arr) {

        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++) {
            pqMin.offer(arr[i]);
        }

        while (pqMin.size()>1)   {
            int min = pqMin.poll();
            int minNext = pqMin.poll();

            int sum = min + minNext;
            pqMin.offer(sum);
        }

        return pqMin.poll();
    }
}
