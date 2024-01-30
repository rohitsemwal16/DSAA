package org.rosemwal.code.stack;

import java.util.LinkedList;
import java.util.Queue;

class StackSqueue {

    Queue<Integer> queue = new LinkedList<>();

    void push(int x)    {

        int queueSize = queue.size();
        queue.offer(x);

        while(queueSize>0) {
            queue.offer(queue.poll());
            queueSize--;
        }
    }

    int peek() {
        return queue.peek();
    }

    int pop() {
        return queue.poll();
    }
}

public class ImplementStackUsingSingleQueue {

    public static void main(String[] args)  {

        StackSqueue stack = new StackSqueue();
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
