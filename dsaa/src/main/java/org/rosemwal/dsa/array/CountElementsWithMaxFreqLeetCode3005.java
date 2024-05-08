package org.rosemwal.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaxFreqLeetCode3005 {

    // https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2024-03-08

    public int maxFrequencyElements(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : nums)    {
            int value = map.getOrDefault(num, 0) + 1;
            map.put(num, value);
            max = Math.max(max, value);
        }
        final int max1 = max;

        return map.values().stream()
                .filter(x -> x.equals(max1))
                .mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args)   {

        CountElementsWithMaxFreqLeetCode3005 obj = new CountElementsWithMaxFreqLeetCode3005();
        int[] nums = {1,2,2,3,1,4};

        System.out.println(obj.maxFrequencyElements(nums));

    }
}
