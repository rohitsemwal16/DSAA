package org.rosemwal.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintAllStringSubsequence60 {

    static List<List<Integer>> subsequences = new LinkedList<>();

    public static void getAllSubsequences(int[] arr, List<Integer> intermediateOutput, int index) {

        if (index == arr.length)    {
            subsequences.add(new LinkedList<>(intermediateOutput));
            return;
        }

        intermediateOutput.add(arr[index]);
        getAllSubsequences(arr, intermediateOutput, index+1);
        intermediateOutput.remove(intermediateOutput.size()-1);
        getAllSubsequences(arr, intermediateOutput, index+1);
    }

    public static void main(String[] args)  {

        int[] arr = {1, 2, 3};

        getAllSubsequences(arr,  new ArrayList<>(), 0);

        for(int i=0; i<subsequences.size(); i++)    {
            System.out.print(Arrays.toString(subsequences.get(i).toArray()));
            System.out.println();
        }
    }
}
