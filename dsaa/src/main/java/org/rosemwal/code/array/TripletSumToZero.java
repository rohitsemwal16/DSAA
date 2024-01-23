package org.rosemwal.code.array;

import java.util.*;

public class TripletSumToZero {

    public static void main(String[] args)  {

        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = findThreeSumZeroUsingSet(nums); // O(n2)
        System.out.println("3 sum 0 via HashSet "+ Arrays.toString(list.toArray()));

        List<List<Integer>> list2 = findThreeSumZeroUsingTwoPointerApproach(nums); // O(n2)
        System.out.println("3 sum 0 via Two pointer approach "+ Arrays.toString(list2.toArray()));
    }

    private static List<List<Integer>> findThreeSumZeroUsingTwoPointerApproach(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        int count =0;

        for(int i=0; i<nums.length-2; i++) {

            if (i>0 && nums[i] == nums[i-1])  {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                }
                if (sum < 0)
                    start++;
                else
                    end--;
            }
        }

            return list;
    }

    public static List<List<Integer>> findThreeSumZeroUsingSet(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++)    {
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j=i+1; j<nums.length; j++)   {
                if(set.contains(-(nums[i]+nums[j])))    {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], -(nums[i]+nums[j]))));
                }
                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }
}
