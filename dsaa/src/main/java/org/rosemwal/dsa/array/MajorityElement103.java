package org.rosemwal.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement103 {

    public static void main(String[] args)  {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Majority element is " + findMajorityElement(arr)); // Time O(n), Space O(n)

        findMajorityElementMoore(arr); // Time O(n), Space O(1) -- Moore Votings algorithm
    }

    private static int findMajorityElement(int[] nums) {
        int len = nums.length;
        if(len==1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)    {

            if (map.containsKey(nums[i]))   {
                map.put(nums[i], map.get(nums[i])+1);
                if(map.get(nums[i])>len/2)  {
                    return nums[i];
                }
            }   else    {
                map.put(nums[i], 1);
            }
        }
        return -1;

    }

    private static int findMajorityElementMoore(int[] nums)  {

        // More's voting
        int element = nums[0];
        int count = 1;

        for (int i=1; i<nums.length; i++)   {

            if (nums[i] != element)   {
                count--;
            }   else    {
                count++;
            }

            if(count <= 0)   {
                element=nums[i];
                count=1;
            }
        }
        return element;
    }



}
