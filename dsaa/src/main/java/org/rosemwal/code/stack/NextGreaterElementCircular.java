package org.rosemwal.code.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircular {

    public static void main(String[] args)  {

        int[] arr = {1,2,3,4,3};

        int[] nge = findNextGreaterElement(arr);
        System.out.println(Arrays.toString(nge));
    }

    private static int[] findNextGreaterElement(int[] arr) {
        
        int n=arr.length;
        int[] all = new int[2*n];
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<2*n; i++)  {
            all[i] = arr[i%n];
        }

        for(int k = 2*n-1; k>=0; k--)  {

            while(!st.isEmpty() && st.peek()<=all[k])   {
                st.pop();
            }
            int num = all[k];
            if(st.isEmpty())    {
                all[k]=-1;
            }   else    {
                all[k] = st.peek();
            }
            st.push(num);
        }

        return Arrays.copyOfRange(all, 0, n);
    }
}
