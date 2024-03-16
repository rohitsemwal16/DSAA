package org.rosemwal.code.recursion;

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

    public static void main(String[] args)  {
        int n=5;
        printName(n);

        System.out.println("print number in forward ..");
        print1ToN(5);

        System.out.println("print number in reverse ..");
        printNTo1(5);
    }
}
