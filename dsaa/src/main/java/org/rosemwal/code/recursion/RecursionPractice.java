package org.rosemwal.code.recursion;

import java.util.Arrays;

public class RecursionPractice {

    static void printName(int n)  {

        if (n==0)    {
            return;
        }
        System.out.println("ROHIT");
        printName(n-1);
    }

    static void print1ToN(int n)    {

        if(n==0)    {
            return;
        }
        print1ToN(n-1);
        System.out.println(n);
    }

    static void printNTo1(int n)    {

        System.out.println(n);

        if(n==1)    {
            return;
        }
        printNTo1(n-1);
    }

    private static int findSumOfFirstNNumbers(int i) {

        if (i==1)    {
            return 1;
        }

        return i + findSumOfFirstNNumbers(i-1);
    }

    private static int findFactorial(int n) {

        if(n==1)    {
            return 1;
        }
        return n * findFactorial(n-1);
    }

    private static void reverseArr(int[] arr, int l , int r) {

        if(l>r) {
            return;
        }

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reverseArr(arr, l+1, r-1);
    }

    public static void main(String[] args)  {
        int n=5;
        printName(n);

        System.out.println("print number in forward ..");
        print1ToN(5);

        System.out.println("print number in reverse ..");
        printNTo1(5);

        System.out.println("Sum of N numbers..");
        System.out.println(findSumOfFirstNNumbers(5));

        System.out.println("Factorial of a number..");
        System.out.println(findFactorial(5));

        int[] arr = {1,2,3,4,5,6,7,8};
        reverseArr(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        System.out.println("Fibonacci "+ printFibonacci(5)); // 0 1 1 2 3 5 8
    }

    static int printFibonacci(int n)    {

        if(n<=1)   {
            return 1;
        }
        return printFibonacci(n-1) + printFibonacci(n-2);
    }

}
