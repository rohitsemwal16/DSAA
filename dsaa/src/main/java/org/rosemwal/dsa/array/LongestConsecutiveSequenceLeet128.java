package org.rosemwal.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceLeet128 {

    public static void main(String[] args)  {
        int[] nums = {100,4,200,1,3,2};
        System.out.println("Longest Consecutive Seq is of size "+ longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length; i++)    {
            set.add(nums[i]);
        }

        int res= 0;

        for (int i=0; i<nums.length; i++)    {

            if(!set.contains(nums[i]-1))    {
                int max=1;
                int next = nums[i]+1;
                while(set.contains(next))   {
                    max+=1;
                    next+=1;
                }
                res = Math.max(max, res);

            }
        }
        return res;
    }
}
