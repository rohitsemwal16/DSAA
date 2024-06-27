package org.rosemwal.dsa.stack;

import java.util.Stack;

public class SortStackUsingRecursion {

    public static void main(String[] args)  {

        Stack<Integer> s = new Stack<>();

        // Push elements into the stack
        s.push(2);
        s.push(0);
        s.push(5);
        s.push(1);

        // Sort the stack
        sortStack(s);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void sortStack(Stack<Integer> s) {

        if (s.empty())
            return;

        int x = s.pop();

        sortStack(s);

        Stack<Integer> tempStack = new Stack<>();

        while (!s.empty() && s.peek() > x) {
            tempStack.push(s.pop());
        }

        s.push(x);

        while (!tempStack.empty()) {
            s.push(tempStack.pop());
        }
    }
}
