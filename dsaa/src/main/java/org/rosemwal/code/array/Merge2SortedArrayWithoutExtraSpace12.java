package org.rosemwal.code.array;

import java.util.Arrays;

public class Merge2SortedArrayWithoutExtraSpace12 {

    public static void main(String[] args)  {

        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        // Using swap elements so we remain with min elements in arr1 and max elements in arr2
        merge2SortedArray(arr1, arr2); // O(nlogn) + O(mlogm)

        arr1 = new int[]{1, 3, 5, 7};
        arr2 = new int[]{0, 2, 6, 8, 9};
        merge2SortedArrayShellSort(arr1, arr2); // Gap Method // ((log(m+n) (gap while) * (n+m) (inner loop)

        System.out.println("Shell sort Arr1 "+ Arrays.toString(arr1));
        System.out.println("Shell sort Arr2 "+ Arrays.toString(arr2));

    }

    private static void merge2SortedArrayShellSort(int[] arr1, int[] arr2) {

        int len = arr1.length + arr2.length;

        int gap = len/2 + len%2;

        while(gap>0) {

            int left = 0; int right = gap;

            while(right<len) {
                if (left < arr1.length) {
                    if(right < arr1.length && arr1[right]< arr1[left])  {
                        swap(arr1, left, arr1, right);
                    }   else if (right >= arr1.length && arr2[right-arr1.length]< arr1[left])    {
                        swap(arr1, left, arr2, right-arr1.length);
                    }
                }   else {
                    if (arr2[left-arr1.length] > arr2[right-arr1.length])   {
                        swap(arr2, left-arr1.length, arr2, right-arr1.length);
                    }
                }
                left++;
                right++;
            }
            if(gap==1)
                break;
            gap = gap/2 + gap%2;
        }
    }

    private static void swap(int[] arr1, int left, int[] arr2, int right) {

        int temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
    }

    private static void merge2SortedArray(int[] arr1, int[] arr2) {

        // Swapping last element of arr1 (largest) with first element(smallest) of arr2
        int comp1 = arr1.length-1;
        int comp2 = 0;

        while(comp1 >=0 && comp2<arr2.length)   {

            if(arr1[comp1]>arr2[comp2]) {
                int temp = arr1[comp1];
                arr1[comp1] = arr2[comp2];
                arr2[comp2] = temp;
                comp1--;
                comp2++;
            }   else {
                break;
            }
        }

        System.out.println("Arr1 "+ Arrays.toString(arr1));
        System.out.println("Arr2 "+ Arrays.toString(arr2));

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println("Arr1 after sorting "+ Arrays.toString(arr1));
        System.out.println("Arr2 after sorting "+ Arrays.toString(arr2));
    }
}
