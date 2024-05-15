package org.rosemwal.dsa.array;

import java.util.Arrays;

public class NextPermutation15 {

    public static void main(String[] args)  {

        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        nextPermutation(nums);

        System.out.println("Next Permutations is " + Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {

        int pivot = findPivot(nums);
        System.out.println(pivot);

        if(pivot !=-1)  {

            int index = findNextGreaterElementThanPivot(nums, nums[pivot]);
            swap(nums, index, pivot);
            reverse(nums, pivot+1);
        }   else    {
            reverse(nums, 0);
        }
    }

    static void reverse(int[] arr, int p)  {

        int start = p;
        int end = arr.length-1;

        while(start<end)    {
            swap(arr, start, end);
            start++;
            end--;

        }
    }

    static void swap(int[] arr, int x, int y)  {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int findNextGreaterElementThanPivot(int[] nums , int k) {

        for(int i=nums.length-1; i>0; i--)  {
            if(nums[i] > k) {
                return i;
            }
        }
        return -1;
    }

    static int findPivot(int[] nums)   {
        int pivot =-1;
        for(int i=nums.length-1; i>0; i--)    {
            if(nums[i-1]<nums[i])   {
                return i-1;
            }
        }
        return pivot;
    }

}
