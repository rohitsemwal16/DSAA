package org.rosemwal.dsa.array;

import java.util.HashMap;
import java.util.Map;

// Numbers can be duplicate
public class CountPairsWithGivenSum18 {

    private static int countCombinationWhoseSumIsK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i=0; i<arr.length; i++) {
            if(map.containsKey(k-arr[i]))   {
                count+= map.get(k-arr[i]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args)  {

        int[] arr = {1, 1, 5, 5, 5, 5, 5, 7};
        System.out.printf(String.format("Combinations is %s%n", countCombinationWhoseSumIsK(arr, 6)));
    }

}
