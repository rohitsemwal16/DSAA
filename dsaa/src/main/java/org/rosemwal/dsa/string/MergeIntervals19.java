package org.rosemwal.dsa.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals19 {

    public static void main(String[] args)  {

        int[][] arr = {{1,3}, {2,4}, {8,9}, {8,10}, {15,18}, {16,17}, {2,6}, {9,11}};
        int[][] result = mergeIntervals(arr);

        for(int i=0; i<result.length;i++)   {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    private static int[][] mergeIntervals(int[][] arr) {

        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(arr[0]);

        int[][] result = new int[arr.length][2];

        for (int i= 1; i<arr.length; i++)   {

            int start = stack.peek()[0];
            int end = stack.peek()[1];

            int currentStart = arr[i][0];
            int currentEnd = arr[i][1];

            if(end>=currentStart)    {
                end = Math.max(end, currentEnd);
                stack.pop();
                stack.push(new int[]{start, end});
            }   else {
                stack.push(arr[i]);
            }
        }
        int index =0;
        while(!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }
}
