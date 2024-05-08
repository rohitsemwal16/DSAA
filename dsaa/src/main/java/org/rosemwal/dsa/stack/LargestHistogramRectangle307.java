package org.rosemwal.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestHistogramRectangle307 {

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int count=0;

        for(int i=0; i<heights.length; i++) {

            while(!stack.isEmpty() && heights[i]<= heights[stack.peek()])    {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = 0;
            }   else    {
                left[i] = stack.peek()+1;
            }
            stack.push(i);
        }

        stack = new Stack<>();
        count=heights.length-1;

        for(int i=heights.length-1; i>=0; i--) {

            while(!stack.isEmpty() && heights[i]<= heights[stack.peek()])    {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = heights.length-1;
            }   else    {
                right[i] = stack.peek()-1;
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(left) +" "+ Arrays.toString(right));

        int max= Integer.MIN_VALUE;
        for (int i=0;i<heights.length;i++)  {
            max = Math.max((right[i]-left[i]+1)*heights[i], max);
        }

        return max;

    }

    public static void main(String[] args)  {

        int[] arr = {2,4}; //Input: heights = [2,1,5,6,2,3]

        System.out.println("Maximum rectange is "+largestRectangleArea(arr));
    }

}
