package org.rosemwal.dsa.array;

import java.util.Arrays;

public class Sort012Colors9 {

    public static void main(String[] args)  {
        int [] nums = {2,0,2,1,1,0};

        sortByPointers(nums); //Dutch national flag algo

        System.out.println(Arrays.toString(nums));
    }

    private static void sortByPointers(int[] nums) {

        // 0->low-1 ->0
        // low -> mid-1 -> 1
        // mid -> high -> unsorted
        // high+1 -> len-1 -> 2

        int low =0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high)    {

            if(nums[mid] ==0)   {
                swap(nums, low, mid);
                low++;
                mid++;
            }   else if(nums[mid] ==1){
                mid++;
            }   else if (nums[mid]==2)  {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int start, int end)    {
        int temp = nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }

}
