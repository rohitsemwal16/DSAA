package org.rosemwal.code.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestSmallestElement334335 {

    public static void main(String[] args)  {

        int[] arr = {10, 5, 2, 4, 15, 20, 3, 35}; // (2,3,4,5,10,15,20,35)

        System.out.println("Enter kth position");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        // kth largest elements -> Min heap is needed - O(n(log(k)))
        System.out.println("Largest element at k index is " + kthLargestElement(arr, k));

        // k largest elements -> Min heap is needed - O(n(log(k)))
        System.out.println("K Largest element are " + Arrays.toString(kLargestElements(arr, k)));

        // kth smallest elements -> Max heap is needed - O(n(log(k)))
        System.out.println("Smallest element at k index is " + kthSmallestElement(arr, k));

        // k smallest elements -> Max heap is needed - O(n(log(k))
        System.out.println("K Smallest element at k index is " + Arrays.toString(kSmallestElements(arr, k)));
    }

    private static int kthLargestElement(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<arr.length; i++) {

            pq.offer(arr[i]);

            if (pq.size()>k) {
            }
        }
        return pq.peek();
    }

    private static int[] kLargestElements(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] out = new int[k];
        int n=0;

        for (int i=0; i<arr.length; i++) {

            pq.offer(arr[i]);

            if(pq.size()>k) {
                pq.poll();
            }
        }
        while(!pq.isEmpty())    {
            out[n++] = pq.poll();
        }
        return out;
    }

    private static int[] kSmallestElements(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] out = new int[k];
        int n=0;

        for (int i=0; i<arr.length; i++)    {
            pq.offer(arr[i]);

            if(pq.size()>k) {
                pq.poll();
            }
        }

        while(!pq.isEmpty())    {
            out[n++] = pq.poll();
        }

        return out;
    }

    private static int kthSmallestElement(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);

            if(pq.size()>k) {
                pq.poll();
            }
        }

        return pq.peek();
    }


}
