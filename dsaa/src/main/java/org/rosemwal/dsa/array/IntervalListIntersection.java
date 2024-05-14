package org.rosemwal.dsa.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersection {

    public static void main(String[] args)  {

       int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
       int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        IntervalListIntersection listIntersection = new IntervalListIntersection();
        int[][] result = listIntersection.intervalIntersection(firstList, secondList);

        for (int i=0; i<result.length; i++)   {
            System.out.println(result[i][0] + " " + result[i][1] +", ");
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<List<Integer>> list = new ArrayList<>();

        int firstListSize = firstList.length;
        int secondListSize = secondList.length;

        int firstListIndex = 0;
        int secondListIndex = 0;

        while(firstListIndex<firstListSize && secondListIndex<secondListSize)    {

            int startFirstList = firstList[firstListIndex][0];
            int endFirstList = firstList[firstListIndex][1];

            int startSecondList = secondList[secondListIndex][0];
            int endSecondList = secondList[secondListIndex][1];

            if (startSecondList <= endFirstList)    {
                // Scope of Intersection
                List<Integer> sublist = new LinkedList<>();
                int maxO = Math.max(startFirstList, startSecondList);
                int minO = Math.min(endFirstList, endSecondList);
                if(maxO <= minO)        {
                    sublist.add(Math.max(startFirstList, startSecondList));
                    sublist.add(Math.min(endFirstList, endSecondList));
                    list.add(new ArrayList<>(sublist));
                }
                if(endSecondList>endFirstList)  {
                    firstListIndex++;
                }   else if (endSecondList<endFirstList)   {
                    secondListIndex++;
                }   else    {
                    firstListIndex++;
                    secondListIndex++;
                }
            }   else if (startFirstList < startSecondList)  {
                firstListIndex++;
            }   else    {
                secondListIndex++;
            }
        }

        int[][] arr = new int[list.size()][2];
        for(int i=0; i<list.size();i++) {
            arr[i][0] = list.get(i).get(0);
            arr[i][1] = list.get(i).get(1);
        }
        return arr;
    }

}
