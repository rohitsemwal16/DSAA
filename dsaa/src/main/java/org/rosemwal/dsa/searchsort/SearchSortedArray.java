package org.rosemwal.dsa.searchsort;

import java.util.Scanner;

public class SearchSortedArray {

    // Case1: Simple increasing array (non duplicates)
    // Case2: Simple increasing array (recursive)
    // Case2: Increasing array (duplicates)
    // Case3: Duplicates increasing array (first occurrence of an element)
    // Case4: Duplicates increasing array (last occurrence of an element)

    public static void main(String args[])  {

        int[] arr = {3,4,5,6,7,8,9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to be searched");
        int num = sc.nextInt();

        System.out.println(String.format("Element is at %s index ",findElementSortedRotatedArray(arr, num)));
        System.out.println(String.format("Element is at %s index ",findElementSortedRotatedArrayRecursive(arr, num, 0, arr.length-1)));


        int[] arr2 = {3,4,4,4,4,4,5,6,7,8,8,8,9};
        // I/p (4) -> O/p 1 (index)

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the element to be searched in duplicate array for first occurrence");
        int num2 = sc2.nextInt();

        System.out.println(String.format("Element is at %s index first occurrence ",findElementSortedDuplicatesFirstOccurrence(arr2, num2)));

        int[] arr3 = {3,4,4,4,4,4,5,6,7,8,8,8,9};
        // I/p (4) -> O/p 5 (index)

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the element to be searched in duplicate array for last occurrence");
        int num3 = sc3.nextInt();

        System.out.println(String.format("Element is at %s index first occurrence ",findElementSortedDuplicatesLastOccurrence(arr3, num3)));

    }

    private static int findElementSortedRotatedArrayRecursive(int[] arr, int num, int start, int end) {

        int mid = start + (end - start)/2;

        if ( num == arr [mid])  {
            return mid;
        }

        if (num <arr[mid])  {
            return findElementSortedRotatedArrayRecursive (arr, num, start, mid-1);
        }   else {
            return findElementSortedRotatedArrayRecursive (arr, num, mid+1, end);
        }
    }

    private static int findElementSortedRotatedArray(int[] arr, int num)  {

        int first = 0;
        int last = arr.length-1;

        while(first<=last)  {

            int mid = first + (last-first)/2;

            if (arr[mid] == num)   {
                return mid;
            }

            if(num < arr[mid])  {
                last = mid-1;
            }   else {
                first = mid+1;
            }
        }
        return -1;
    }

    private static int findElementSortedDuplicatesFirstOccurrence(int[] arr, int num)    {

        int start = 0;
        int end = arr.length-1;

        while (start <= end)    {

            int mid = start + (end-start)/2;

            if (arr[mid] == num && (mid == 0 || arr[mid] != arr[mid-1]))    {
                return mid;
            }

            if( num <= arr[mid])    {
                end = mid-1;
            }   else {
                start = mid+1;
            }
        }
        return -1;
    }

    private static int findElementSortedDuplicatesLastOccurrence(int[] arr, int num)    {

        int start = 0;
        int end = arr.length-1;

        while (start <= end)    {

            int mid = start + (end-start)/2;

            if (arr[mid] == num && (mid == arr.length-1 || arr[mid] != arr[mid+1]))    {
                return mid;
            }

            if( num >= arr[mid])    {
                start = mid+1;
            }   else {
                end = mid-1;
            }
        }
        return -1;
    }
}
