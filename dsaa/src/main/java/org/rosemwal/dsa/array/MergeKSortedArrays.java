package org.rosemwal.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args)  {

        int[][] arr = { { 2, 6, 12, 34 },
                    { 1, 9, 20, 1000 },
                    { 23, 34, 90, 2000 } };

        System.out.println("Merged array is :");
        List<Integer> list = mergeKSortedArrays(arr, arr.length);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static ArrayList<Integer> mergeKSortedArrays(int[][] arr, int K) {

        ArrayList<Integer> result= new ArrayList<Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                pq.add(arr[i][j]);
            }
        }

        while(!pq.isEmpty())
        {
            result.add(pq.poll());
        }
        return result;

    }

}
