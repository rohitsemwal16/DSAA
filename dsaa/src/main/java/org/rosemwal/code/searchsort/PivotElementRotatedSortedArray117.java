package org.rosemwal.code.searchsort;

public class PivotElementRotatedSortedArray117 {

    public static void main(String[] args)  {

        int[] nums = {3,4,5,6,7,1,2};

        System.out.println("pivot element is at index "+ findPivot(nums));
    }

    private static int findPivot(int[] nums) {

        int start =0;
        int end = nums.length-1;

        while(start<=end)   {
            int mid = start + (end-start)/2;
            System.out.println(mid);

            if (nums[0]<=nums[mid-1] && nums[mid] <= nums[nums.length-1])    {
                return mid;
            }  else if(nums[0]<=nums[mid-1])    {
                start = mid+1;
            }   else {
                end = mid-1;
            }
        }
        return -1;
    }
}
