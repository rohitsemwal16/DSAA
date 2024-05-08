package org.rosemwal.dsa.queue;

public class MaxMinSubarrayOfSizeK325 {

    private static int findMaxSubarrayOfSizekUsingQueue(int[] arr, int k) {

        return 0;
    }

    private static int findMaxSubarrayOfSizekUsingSlidingWindow(int[] arr, int k) {

        int j=0;
        int i=0;
        int maxSum = Integer.MIN_VALUE;
        int intermediateSum=0;

        while (j<arr.length) {

            intermediateSum+=arr[j];
            if(j-i+1==k)    {
                maxSum = Math.max(maxSum, intermediateSum);
                intermediateSum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2 , 1, 2, 5, -1, 7, -3, -1, -2};

        findMaxSubarrayOfSizekUsingQueue(arr, 4);

        System.out.println(findMaxSubarrayOfSizekUsingSlidingWindow(arr, 4)); // TIME AND SPACE - O(1),
    }

}

