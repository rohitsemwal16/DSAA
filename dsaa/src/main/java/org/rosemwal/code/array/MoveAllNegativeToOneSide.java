package org.rosemwal.code.array;

import java.util.Arrays;

public class MoveAllNegativeToOneSide {

    public static void main(String[] args)  {

        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        System.out.println(Arrays.toString(moveAllNegativeNodesToOneSide(arr)));
    }

    private static int[] moveAllNegativeNodesToOneSide(int[] arr) {

        int start = 0;
        int end = arr.length-1;

        while(start<end)    {

            if(arr[start]>0 && arr[end]<0)  {
                //Swap start and end element
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }   else if (arr[start]<0 && arr[end]>0)    {
                start++;
                end--;
            }   else if (arr[start]<0 && arr[end]<0)    {
                start ++;
            }   else if (arr[start]>0 && arr[end]>0){
                end--;
            }
        }

        return arr;
    }
}
