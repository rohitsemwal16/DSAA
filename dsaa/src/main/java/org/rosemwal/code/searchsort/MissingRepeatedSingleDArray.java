package org.rosemwal.code.searchsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingRepeatedSingleDArray {

    public static void main(String[] args)  {
        int[] arr = {4,3,6,2,1,1};

        int[] res = findMissingRepeatedUsingHashTable(arr);
        System.out.println(Arrays.toString(res)); // Time - O(n), Space = O(n)

        int[] res1 = findMissingRepeatedUsingMath(arr);
        System.out.println(Arrays.toString(res1)); // Time - O(n), Space = O(1)

        int[] res2 = findMissingMissingRepeatedUsingXor(arr);
        System.out.println(Arrays.toString(res2)); // Time - O(n), Space = O(1)

    }

    private static int[] findMissingRepeatedUsingMath(int[] arr) {

        // Solve by two equations:

        //1. SumGiven+m-r = Sum(1ToN) --> m-r = Sum(1-N) - Sum(Given)
        //2. Square-> SumGivenElements individual suqres + m^2-r^2 = n(n+1)(2n+1)/6 -> (m+r)(m-r) = Sum(1-n)^2 - Sum(Given)^2
        // -> (m+r) = Sum sq diff/(Sum(1-N) - Sum(Given))
        // 3. Find m and r with two equations

        int[] res = new int[2];
        int sum = 0;
        int sumSquare = 0;

        for (int i=0; i<arr.length; i++) {
            sum+=arr[i];
            sumSquare+=Math.pow(arr[i],2);
        }

        int fullArraySum = arr.length* (arr.length+1)/2;
        int fullArraySumSquare = arr.length*(arr.length+1)*(2*arr.length+1)/6;

        int differenceFullArrayGivenArraySum = fullArraySum - sum;
        int differenceFullArraySumSquareGivenArraySumSquare = fullArraySumSquare - sumSquare;

        int a = differenceFullArrayGivenArraySum;
        int b = differenceFullArraySumSquareGivenArraySumSquare/differenceFullArrayGivenArraySum;

        res[0] = (a+b)/2;
        res[1] = (b-a)/2;

        return res;
    }

    private static int[] findMissingMissingRepeatedUsingXor(int[] arr) {


        // First arr^allnumexor will be left with repeat^missing
        // Find right most set bit of repeat&missing and divide the numbers (arr+fullarray) into two groups
        // One element xor with one group gives missing other gives repeating
        int[] res = new int[2];

        int xor=arr[0]^1;

        for(int i=1;i<arr.length;i++)   {
            xor^=arr[i]^(i+1);
        }

        int setbit = xor & ~(xor-1);
        int x=0;
        int y=0;

        for(int i=0;i<arr.length;i++)   {

            if((setbit&arr[i])!=0)  {
                x = x^arr[i];
            }   else {
                y = y^arr[i];
            }
        }

        for(int i=1;i<arr.length+1;i++)   {

            if((setbit&i)!=0)  {
                x = x^i;
            }   else {
                y = y^i;
            }
        }

        res[0] =x;
        res[1] = y;



        return res;


    }

    private static int[] findMissingRepeatedUsingHashTable(int[] arr) {

        int[] result = new int[2];
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int k=0; k<len; k++)   {
            map.put(arr[k], map.getOrDefault(arr[k], 0)+1);
        }

        for(int i=1; i<=len;i++) {
            if (!map.containsKey(i))    {
                result[0]=i;
            }   else if (map.get(i)==2) {
                result[1] = i;
            }
        }
        return result;
    }
}
