package org.rosemwal.code.array;


public class FindPivotInteger2485Leetcode {


    public static int pivotIntegerUsingBinarySearch(int n) {
        int start = 1;
        int end = n;

        int sum = n*(n+1)/2;

        while(start<=end)    {
            int mid = (start+end)/2;

            if(mid*mid == sum)  {
                return mid;
            }   else if ((mid*mid)<(sum)) {
                start = mid+1;
            }   else    {
                end = mid-1;
            }
        }

        return -1;
    }

    public static int pivotIntegerUsingTwoPointer(int n) {
        int start = 1;
        int end = n;
        int firstHalfSum = 0;
        int secondHalfSum=0;

        while(start!=end)   {

            if(firstHalfSum<secondHalfSum)  {
                firstHalfSum += start;
                start++;
            } else   {
                secondHalfSum +=end;
                end--;
            }
        }

        if(firstHalfSum == secondHalfSum)    {
            return start;
        }
        return -1;
    }

    public static void main(String[] args)  {

        int n=8;
        System.out.println(pivotIntegerUsingTwoPointer(n)); // T - O(n) S - O(1)

        System.out.println(pivotIntegerUsingBinarySearch(n)); // T - O(n) S - O(1)
    }

}
