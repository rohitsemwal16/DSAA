package org.rosemwal.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWith0Sum26 {

    public static void main(String[] args)  {

        int[] arr = {4, -2, -1, 3, 5, -2 };

        System.out.println(doesSubarrayExistWith0Sum(arr)); // O(n) time and O(n) space
    }

    private static boolean doesSubarrayExistWith0Sum(int[] arr) {

        int var = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            var += arr[i];
            if(var==0 || set.contains(var)) {
                return true;
            }
            set.add(var);
        }

        return false;
    }
}
