package org.rosemwal.code.stack;

public class ImplementStackUsingArrays {

    static int[] stack = new int[10];
    static int top=0;

    public static void main(String[] args)  {

        push(10);
        push(20);
        push(30);

        peek();
        pop();
        pop();

        push(40);
        push(50);
        push(60);
        push(70);

        peek();
        pop();

        System.out.println("Stack Size is " + size());

    }

    private static int size() {
        return top;
    }

    public static void push(int num)  {
        stack[top++] = num;
    }

    private static void peek() {
        System.out.println("Peek " + stack[top-1]);
    }

    public static void pop()    {
        top--;
        System.out.println("Pop " + stack[top]);
    }

    public static boolean isEmpty() {
        return top ==0;
    }

    public static boolean isFull() {
        return top+1 == 10;
    }
}
