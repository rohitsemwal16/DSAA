package org.rosemwal.code.array;

public class Sqrt104 {

    public static void main(String[] args)  {

        int x = 28;
        System.out.println("Sqrt of number is " +findSqrt(x)); // Binary Search
    }

    public static int findSqrt(int x)  {

        if(x==1)
            return 1;
        int start = 1;
        int end = x/2;
        int ans=0;

        while(start<=end)   {
            int mid=start+(end-start)/2;

            if(mid<=x/mid)   {
                ans = mid;
                start = mid+1;
            }   else    {
                end = mid-1;
            }
        }

        return ans;
    }
}
