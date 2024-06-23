package org.rosemwal.dsa.queue;

import java.util.Stack;

class StackToQueue  {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void offer(int x) {

        while(!stack1.isEmpty())    {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while(!stack2.isEmpty())    {
            stack1.push(stack2.pop());
        }
    }

    int poll()  {

        int pop = stack1.pop();
        System.out.println("Polling "+ pop);
        return pop;
    }

    int peek()  {
        return stack1.peek();
    }
}


class StackToQueue2 {

        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        void offer(int x) {

        input.push(x);
        }

        int poll()  {

            if (output.isEmpty())   {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            int pop = output.pop();
            System.out.println("Polling from method2  "+ pop);
            return pop;
        }

        int peek()  {
            if (output.isEmpty())   {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }
    }



public class ImplementQueueFromStack {

    public static void main(String[] args)  {

        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.offer(1);
        stackToQueue.offer(2);
        stackToQueue.offer(3);

        stackToQueue.peek();
        stackToQueue.poll();
        stackToQueue.offer(4);
        stackToQueue.offer(5);
        stackToQueue.peek();
        stackToQueue.poll();
        stackToQueue.poll();
        stackToQueue.poll();
        stackToQueue.poll();

        System.out.println("Method2 where push takes O(1)");
        StackToQueue2 stackToQueue2 = new StackToQueue2();
        stackToQueue2.offer(1);
        stackToQueue2.offer(2);
        stackToQueue2.offer(3);

        stackToQueue2.peek();
        stackToQueue2.poll();
        stackToQueue2.offer(4);
        stackToQueue2.offer(5);
        stackToQueue2.peek();
        stackToQueue2.poll();
        stackToQueue2.poll();
        stackToQueue2.poll();
        stackToQueue2.poll();

    }
}
