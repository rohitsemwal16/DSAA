package org.rosemwal.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.rosemwal.dsa.string.PrintAllStringSubsequence60.getAllSubsequences;


public class ArraySubsequenceSumToK {

    static List<List<Integer>> subsequences = new ArrayList<>();

    private static void getAllSubsequencesSumToK(int[] arr, ArrayList<Integer> output, int i, int sum, int k) {

        if(i == arr.length) {
            if(sum==k) {
                subsequences.add(new ArrayList<>(output));
            }
            return;
        }
        output.add(arr[i]);
        sum+=arr[i];
        getAllSubsequencesSumToK(arr, output, i+1, sum, k);
        sum-=arr[i];
        output.remove(output.size()-1);
        getAllSubsequencesSumToK(arr, output, i+1, sum, k);

    }

    public static void main(String[] args)  {

        int[] arr = {1, 3, 2, 4, 5, 1};
        int[] arr5 = {1, 2, 3, 4};

        System.out.println("All Subsequences..");
        getAllSubsequences(arr5, new ArrayList<>(), 0);

        System.out.println("Subsequence with Sum 5 .." );
        getAllSubsequencesSumToK(arr,  new ArrayList<>(), 0, 0, 5);

        for (int i=0; i<subsequences.size(); i++)    {
            System.out.print(Arrays.toString(subsequences.get(i).toArray()));
            System.out.println();
        }

        System.out.println("First subsequence.. ");
        getFirstSubsequenceSumToK(arr, new ArrayList<>(), 0, 0, 5);

        System.out.println("Number of Occurrences.. ");
        System.out.println(getNumberOfOccurrences(arr, new ArrayList<>(), 0, 0, 5));

        System.out.println("Multiple sum.. ");

        int[] arr1 = {1,2,3,4,5,6};
        subsequences = new LinkedList<>();
        getAllSubsequencesSumToKOneElementMultipleTimes(arr1, new ArrayList<>(), 0, 0, 7);

        for (int i=0; i<subsequences.size(); i++)    {
            System.out.print(Arrays.toString(subsequences.get(i).toArray()));
            System.out.println();
        }

        System.out.println("One sum without set");

        int[] arr2 = {1,1,1,2,2};
        subsequences = new LinkedList<>();
        getAllSubsequencesSumToKOneElementAtATimeOnlyOneCombination(arr2, new ArrayList<>(), 0, 4);

        for (int i=0; i<subsequences.size(); i++)    {
            System.out.print(Arrays.toString(subsequences.get(i).toArray()));
            System.out.println();
        }
    }

    private static void getAllSubsequencesSumToKOneElementAtATimeOnlyOneCombination(int[] arr, ArrayList<Integer> subArray, int index, int target) {

        if (target == 0) {
           subsequences.add(new ArrayList<>(subArray));
           return;
        }

        for (int i=index; i<arr.length; i++)   {

            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i]>target) break;

            subArray.add(arr[i]);
            getAllSubsequencesSumToKOneElementAtATimeOnlyOneCombination(arr, subArray, i+1, target-arr[i]);
            subArray.remove(subArray.size()-1);
        }
    }

    private static void getAllSubsequencesSumToKOneElementMultipleTimes(int[] arr, List<Integer> output, int index, int sum, int k)    {

        if(index == arr.length) {
            if(sum == k)    {
                subsequences.add(new ArrayList<>(output));
            }
            return;
        }

        if(sum>k)   {
            return;
        }

        sum+=arr[index];
        output.add(arr[index]);
        getAllSubsequencesSumToKOneElementMultipleTimes(arr, output, index, sum, k);

        sum-=arr[index];
        output.remove(output.size()-1);
        getAllSubsequencesSumToKOneElementMultipleTimes(arr, output, index+1, sum, k);

    }

    private static int getNumberOfOccurrences(int[] arr, ArrayList<Object> objects, int index, int sum, int k) {

        if (index == arr.length)    {
            if (sum == k)    {
                return 1;
            }   else {
                return 0;
            }
        }

        sum+=arr[index];
        objects.add(arr[index]);
        int left = getNumberOfOccurrences(arr, objects, index+1, sum, k);

        sum-=arr[index];
        objects.remove(objects.size()-1);
        int right = getNumberOfOccurrences(arr, objects, index+1, sum, k);

        return left+right;
    }

    private static boolean getFirstSubsequenceSumToK(int[] arr, ArrayList<Object> objects, int index, int sum, int k) {

        if(index == arr.length)    {
            if(sum == k) {
                System.out.println(Arrays.toString(objects.toArray()));
                return true;
            }   else {
                return false;
            }
        }

        objects.add(arr[index]);
        sum+=arr[index];
        if (getFirstSubsequenceSumToK(arr, objects, index+1, sum, k)) return true;

        sum-=arr[index];
        objects.remove(objects.size()-1);
        if (getFirstSubsequenceSumToK(arr, objects, index+1, sum, k)) return true;

        return false;

    }
}
