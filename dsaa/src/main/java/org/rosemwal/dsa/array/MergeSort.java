package org.rosemwal.dsa.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args)  {

        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3, 4};

        mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array is via merge Sort " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {

        if(low == high) {
            return;
        }

        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high-low+1];

        int left = low;
        int right = mid+1;
        int c = 0;

        while(left <= mid && right<=high)   {
            if (arr[left]<=arr[right])  {
                temp[c] = arr[left];
                left++;
            }   else {
                temp[c] = arr[right];
                right++;
            }
            c++;
        }

        while(left<=mid)    {
            temp[c] = arr[left];
            left++;
            c++;
        }

        while(right<=high)  {
            temp[c] = arr[right];
            right++;
            c++;
        }

        for (int i=low; i<=high; i++)   {
            arr[i] = temp[i-low];
        }
    }
}
