package org.rosemwal.dsa.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChocolateDistributionProblem30 {

    public long findMinDiff (List<Integer> a, int m)
    {
        Collections.sort(a);

        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<a.size(); i++)   {
            if(i+m-1<a.size()) {
                minSum = Math.min(minSum, a.get(i+m-1)-a.get(i));
            }   else {
                break;
            }
        }
        return minSum;
    }

    public static void main(String[] args)  {

        ChocolateDistributionProblem30 obj = new ChocolateDistributionProblem30();
        List<Integer> arr = Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12);
        System.out.println("Mininum difference is " + obj.findMinDiff(arr, 5));
    }
}
