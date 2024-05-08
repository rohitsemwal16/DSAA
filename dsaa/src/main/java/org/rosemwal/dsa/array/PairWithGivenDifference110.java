package org.rosemwal.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenDifference110 {

    public static void main(String[] args)  {

        int[] arr = {5, 20, 3, 2, 5, 80};

        System.out.println("Pair with given difference " + findPairWithGivenDifference(arr, 78)); // Time O(n), Space O(n)
    }

    private static boolean findPairWithGivenDifference(int[] arr, int n) {

        Set<Integer> set = new HashSet<>();

        for (int i=0; i<arr.length; i++)   {

            if(set.contains(Math.abs(arr[i]-n)) || set.contains(Math.abs(arr[i] + n)) )    {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
