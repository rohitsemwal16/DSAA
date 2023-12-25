package org.rosemwal.code.searchsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingRepeatedSingleDArray {

    public static void main(String[] args)  {
        int[] arr = {4,3,6,2,1,1};

        int[] res = findMissingRepeatedUsingHashTable(arr);
        System.out.println(Arrays.toString(res)); // Time - O(n), Space = O(n)
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
                result[1]=i;
            }   else if (map.get(i)==2) {
                result[0] = i;
            }
        }
        return result;
    }
}
