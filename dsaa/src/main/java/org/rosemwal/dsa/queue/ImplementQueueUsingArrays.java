package org.rosemwal.dsa.queue;

public class ImplementQueueUsingArrays {

    static int n=5;
    static int[] queue = new int[n];
    static int front = 0;
    static int rear = 0;
    public static void main(String[] args)  {

        offer(10);
        offer(20);
        offer(30);
        offer(40);
        offer(50);

        offer(60);
        offer(70);

        poll();
        poll();
        poll();
        poll();
        poll();
        poll();

        offer(80);
        offer(90);
    }

    private static void offer(int num) {

        if (isFull() && rear!=0)  {
            System.out.println(
                    String.format("Queue is full, cannot add elements {%s} further rear {%s}, front {%s}", num, rear, front));
        }   else {
            queue[rear % n] = num;
            rear=rear+1;

            System.out.println(String.format("Offer element {%s}, elements in queue are.. ", num));
            for(int i=front; i<rear; i++)  {
                System.out.print(queue[i%n]+" " );
            }
            System.out.println();
        }
    }

    private static void poll() {

        if(!isEmpty()) {
            System.out.println(String.format("Poll started, rear {%s}, front {%s}", rear, front));
            System.out.println(queue[front % n]);
            front += 1;
            System.out.println(String.format("Poll ended, rear {%s}, front {%s}", rear, front));
        }   else {
            System.out.println("Cannot poll as the queue is empty..");
        }

    }

    public static boolean isEmpty()    {
        return rear-front == 0;
    }

    public static boolean isFull()  {
        return rear-front-n == 0;
    }
}
