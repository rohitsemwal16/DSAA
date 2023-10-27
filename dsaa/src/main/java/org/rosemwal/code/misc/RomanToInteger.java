package org.rosemwal.code.misc;

import org.apache.commons.collections.functors.ExceptionPredicate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class RomanToInteger extends Thread{

    public void run()   {
        System.out.println("running");
    }
        public static void main(String args[])  {
            RomanToInteger t1= new RomanToInteger();
            t1.start();
            t1.start();
        }

    }

