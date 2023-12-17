package org.rosemwal.code.searchsort;

import java.util.Scanner;

public class SearchSortedRotatedArray {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.println(String.format("Found the element {%d} at {%d}", x, findElementInSortedRotatedArray(arr, x)));
        System.out.println(String.format("Found the element {%d} at {%d}", x, findElementInSortedRotatedArrayRecursive(arr, x, 0, arr.length - 1)));
    }

    private static int findElementInSortedRotatedArrayRecursive(int[] arr, int x, int start, int end) {

        int mid = start + (end - start) / 2;

        if (x == arr[mid]) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {

            if (arr[start] <= x && x <= arr[mid]) {
                return findElementInSortedRotatedArrayRecursive(arr, x, start, mid - 1);
            } else {
                return findElementInSortedRotatedArrayRecursive(arr, x, mid + 1, end);
            }
        } else {

            if (arr[mid] <= x && x <= arr[end]) {
                return findElementInSortedRotatedArrayRecursive(arr, x, mid + 1, end);
            } else {
                return findElementInSortedRotatedArrayRecursive(arr, x, start, mid - 1);
            }
        }
    }

    private static int findElementInSortedRotatedArray(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[start] <= arr[mid]) {
                if (arr[start] <= x && x < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < x && x <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
}
}
