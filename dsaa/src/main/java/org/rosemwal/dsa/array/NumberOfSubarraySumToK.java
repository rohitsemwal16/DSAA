package org.rosemwal.dsa.array;

public class NumberOfSubarraySumToK {

    public static void main(String[] args)  {
        int[] arr = {1};
        System.out.println("Subarray is " +subarraySum(arr, 0));
    }

    public static int subarraySum(int[] nums, int k) {

        int l = 0;
        int r = 0;
        int len = nums.length;
        int sum=nums[0];
        int count=0;


            while(r<len && l<len)  {

                System.out.println(sum+" "+l + " "+r);

                if(sum==k)  {
                    count++;
                    sum-=nums[l];
                    l++;
                }   else if(sum<k)   {
                    r++;
                    if(r<len)
                    sum += nums[r];
                }else if (sum>k)    {
                    sum-=nums[l];
                    l++;
                }

            }
            return count;

    }
}
