package org.rosemwal.code.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations61 {

    public void permutationsOfInteger(int[] arr, List<List<Integer>> result, List<Integer> subResult, boolean[] visited )  {

        if(arr.length == subResult.size())  {
            result.add(new ArrayList<>(subResult));
            return;
        }


        for (int i=0; i<arr.length; i++) {

            if (!visited[i]) {
                subResult.add(arr[i]);
                visited[i] = true;

                permutationsOfInteger(arr, result, subResult, visited);
                subResult.remove(subResult.size()-1);
                visited[i] = false;
            }

        }
    }

    public void permutationsOfIntegerWithoutVisitedButSwap(int[] arr, int index, List<List<Integer>> result)   {

        if(index == arr.length) {

            List<Integer> subResult = new LinkedList<>();
            for (int i=0; i<arr.length; i++) {
                subResult.add(arr[i]);
            }

            result.add(new ArrayList<>(subResult));
            return;
        }

        for(int i=index; i<arr.length; i++) {
            swap(arr, i, index);
            permutationsOfIntegerWithoutVisitedButSwap(arr, index+1, result);
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int i, int index) {

        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }


    public static void main(String[] args)  {

        int[] arr = {1, 2, 3};

        Permutations61 permutations61 = new Permutations61();
        List<Integer> subResult = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        permutations61.permutationsOfInteger(arr, result, subResult, new boolean[arr.length]);

        for (int i=0; i<result.size(); i++)   {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }

        System.out.println("Method2 without visited array but swap");
        result = new LinkedList<>();
        permutations61.permutationsOfIntegerWithoutVisitedButSwap(arr, 0, result);

        for (int i=0; i<result.size(); i++)   {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }
    }
}
