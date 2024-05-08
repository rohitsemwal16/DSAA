package org.rosemwal.dsa.misc;

class Player    {
    Player()    {
        System.out.println("p");
    }
}

class CardPlayer {

    public static void main(String[] args)  {

        try {
            System.out.print("Hi");
            show();
        }   catch(Exception e)  {
            System.out.print("Caught");
        }   finally {
            System.out.print("finally");
        }
        System.out.print("last");
    }

    private static void show() {
        System.out.print("show ");
        throw new RuntimeException();
    }
}

