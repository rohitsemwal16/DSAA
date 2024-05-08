package org.rosemwal.dsa.array;

import java.util.Arrays;

// 15 March
public class ProductExceptSelfLeetCode238 {

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] = right * result[j];
            right = right * nums[j];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));

        int[] arr2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr2)));
    }
}
