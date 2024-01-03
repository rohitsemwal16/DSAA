package org.rosemwal.code.heap;

import java.util.Arrays;

public class MinHeapToMaxHeap352 {

    public static void main(String[] args)  {

        int arr[] = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };

        buildMaxHeap(arr);
    }

    private static void buildMaxHeap(int[] arr) {

        int N = arr.length;

        for(int i=N/2-1; i>=0; i--) {
            heapify(arr, N, i);
        }

        System.out.println("Max heap is "+ Arrays.toString(arr));
    }

    private static void heapify(int[] arr, int n, int i) {

        int largest = i;

        int left = 2*i+1;
        int right = 2*i+2;

        if (left<n && arr[largest] < arr[left]) {
            largest = left;
        }

        if (right<n && arr[largest] < arr[right])   {
            largest = right;
        }

        if(largest!=i)  {

            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }

    }
}
