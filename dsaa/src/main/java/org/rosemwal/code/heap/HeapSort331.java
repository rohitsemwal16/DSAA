package org.rosemwal.code.heap;

import java.util.Arrays;

// Two steps -- 1. (creation of max heap) 2. Deletion of top element and putting it to end of an array
// O(logn) - > insertion of 1 element -> n elements -> nlogn + deletion of n element - nlogn -> n(log(n))
public class HeapSort331 {

    public static void main(String[] args)  {

        int[] array = {10, 20, 15, 12, 40, 25, 18};
        heapSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] arr)  {

        int N = arr.length;

        for (int i=N/2; i>=0; i--)   {
            heapify(arr, N, i);
        }

        for (int j=N-1; j>0; j--) {

            int swap = arr[0];
            arr[0]= arr[j];
            arr[j] = swap;

            heapify(arr, j, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }
}
