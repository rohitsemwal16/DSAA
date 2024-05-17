package org.rosemwal.dsa.array;

import java.util.Arrays;

public class TrappingRainWater29 {

    public static void main(String[] args)  {

        int[] height = {3,1,2,4,0,1,3,2};
        System.out.println("Trapped water " +trap(height));
    }

    public static int trap(int[] height) {

        int[] leftToRight = new int[height.length];
        int[] rightToLeft = new int[height.length];

        int max = height[0];
        leftToRight[0]=-1;

        for(int i=1; i<height.length; i++)  {
            max = Math.max(max, height[i-1]);

            if (height[i]>max)  {
                leftToRight[i] = -1;
            }   else    {
                leftToRight[i] = max;
            }
        }

        max = height[height.length-1];
        rightToLeft[height.length-1] = -1;

        for(int i=height.length-2; i>=0; i--)  {
            max = Math.max(max, height[i+1]);
            if(height[i]>max)  {
                rightToLeft[i] = -1;
            }   else    {
                rightToLeft[i] = max;
            }
        }

        System.out.println("Left "+ Arrays.toString(leftToRight));
        System.out.println("Right "+ Arrays.toString(rightToLeft));

        int trappedWater = 0;

        for(int i=0; i<height.length; i++)  {
            if(rightToLeft[i]!=-1 && leftToRight[i]!=-1)    {
                trappedWater+=Math.min(rightToLeft[i], leftToRight[i]) - height[i];
            }
        }
        return trappedWater;
    }


}
