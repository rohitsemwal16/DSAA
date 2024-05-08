package org.rosemwal.dsa.bits;

import java.util.Scanner;

public class BitOperands472 {

    public static void main(String[] args)  {

        int num = 9;
        System.out.println(num<<4); // (9*2*2*2*2)
        System.out.println(num>>1); // (9/2)
        System.out.println(~4);

        // Set a bit in a number at position (pos)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position");
        int position = sc.nextInt();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter number");
        int num2 = sc2.nextInt();

        System.out.println("Bit set at " + position + " result " + setBit(num2, position));
        System.out.println("Bit unset at " + position + " result " + unSetBit(num2, position));
        System.out.println("Bit flipped at " + position + " result " + flipBit(num2, position));
        System.out.println("Bit is set|unset at position " + position + " " + setUnset(num2, position));
        System.out.println("Number is square " + num2 + " " + isSquareNumber(num2));

        System.out.println("Number of set bits in num " + num2 + " is " + countSetBits(num2));
        System.out.println("Number of set bits in num " + num2 + " is " + countSetBitsBrianKernighan(num2)); // o(logn)

    }

    private static int countSetBitsBrianKernighan(int num) {

        int count = 0;

        while(num!=0) {

            num = num & (num-1);
            count++;
        }
        return count;
    }


    // countSetBitsBrianKernighanRecursive (9,0)
    private static int countSetBitsBrianKernighanRecursive(int num) {

        if (num == 0)
            return 0;

        return 1+ countSetBitsBrianKernighanRecursive(num & (num-1));
    }

    private static int countSetBits(int num2) {

        int count =0;
        while(num2>0)   {
            count+=num2&1;
            num2=num2>>1; // right shift by 1 (num/2)
        }
        return count;
    }

    // Iterative count setbits
    private static int countSetBitsRecursive(int num)   {

        if (num==0) {
            return 0;
        }   else {
            return num&1 + countSetBitsRecursive(num>>1);
        }
    }

    private static int setBit(int num, int position) {
        return num |= (1 << position);
    }

    private static int unSetBit(int num, int position) {
        return num &= ~(1 << position);
    }

    private static int flipBit(int num, int position) {
        return num ^= (1 << position);
    }

    private static boolean setUnset(int num, int position) {

        num &= (1<<position);
        return num != 0;
    }

    private static boolean isSquareNumber(int num) {

        return (num & (num-1)) == 0;
    }
}
