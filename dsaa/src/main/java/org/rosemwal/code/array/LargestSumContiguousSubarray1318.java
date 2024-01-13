package org.rosemwal.code.array;

public class LargestSumContiguousSubarray1318 {

    public static void main(String[] args)  {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println("Maximum sum sub array brute force " + findMaxSumBruteForce(arr)); // O(n^2)
        System.out.println("Maximum sum sub array Kadane Algorithm" + findMaxSumKadane(arr)); // O(n)
    }

    private static int findMaxSumBruteForce(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            sum = arr[i];
            for (int j=i+1; j<arr.length; j++)  {
                sum +=arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static int findMaxSumKadane(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {

            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
