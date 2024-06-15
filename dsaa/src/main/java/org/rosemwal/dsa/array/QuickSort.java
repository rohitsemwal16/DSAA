package org.rosemwal.dsa.array;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args)  {

        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};

        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array is " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low<high)    {
            int partition = findPartition(arr, low, high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high);
        }
    }

    private static int findPartition(int[] arr, int low, int high) {

        int i = low;
        int j = high;
        int pivot = arr[low];

        while (i<j)  {

            while (pivot>=arr[i] && i<high)    {
                i++;
            }
            while(pivot<arr[j] && j>low)  {
                j--;
            }
            if (i<j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j)  {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
