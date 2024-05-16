package org.rosemwal.dsa.array;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class MaxConsecutive1WIthAtMostKZeroSliding {

    public static void main(String[] args)  {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }

    public static int longestOnes(int[] nums, int k) {

        int l = 0;
        int r = 0;

        int maxCount=0;
        int zeros = 0;
        int result = 0;
        Queue<Integer> q = new LinkedList<>(); // If space is a constraint, do while loop and find intill 0 is reached

        while (r<nums.length)    {

            if(nums[r] == 0)    {
                q.offer(r);
                zeros++;
            }

            if (nums[r] == 1 || zeros<=k)    {
                result = Math.max(result, r-l+1);
            }

            if (zeros>k) {
                l = q.poll()+1;
                zeros--;
            }
            r++;
        }
        return Math.max(result, r-l);
    }
}
