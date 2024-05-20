package org.rosemwal.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
public class MinimumAmountOfCupsToFillLeet2335 {

    public static void main(String[] args)  {

        int[] amount = {1, 4, 2};
        System.out.println("Total time taken " +fillCups(amount));
    }

    public static int fillCups(int[] amount) {

        int seconds = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(amount[0]);
        pq.add(amount[1]);
        pq.add(amount[2]);

        while(pq.peek()!=0)    {
            seconds++;
            int high1 = pq.poll()-1;
            int high2 = pq.poll()-1;
            pq.add(Math.max(high1, 0));
            pq.add(Math.max(high2, 0));
        }
        return seconds;
    }
}
