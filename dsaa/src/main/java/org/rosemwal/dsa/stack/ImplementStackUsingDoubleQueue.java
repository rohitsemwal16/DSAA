package org.rosemwal.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

class StackDQueue {

    Queue<Integer> q2 = new LinkedList<>();
    Queue<Integer> q1 = new LinkedList<>();

    void push(int x)    {

        q2.offer(x);

        while(!q1.isEmpty())    {
            q2.offer(q1.poll());
        }

        Queue q = q1;
        q1 = q2;
        q2 = q;
    }

    int peek()  {

        return q1.peek();
    }

    int pop()   {

        return q1.poll();
    }
}


public class ImplementStackUsingDoubleQueue {

    public static void main(String[] args) {

        StackDQueue stack = new StackDQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.peek());
    }

}
