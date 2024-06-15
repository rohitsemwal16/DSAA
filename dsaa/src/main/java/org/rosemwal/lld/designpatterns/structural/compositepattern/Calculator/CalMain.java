package org.rosemwal.lld.designpatterns.structural.compositepattern.Calculator;

public class CalMain {

    public static void main(String[] args)  {

        //2*(1+7)

       /*

             *
           /   \
         2      +
               / \
              1   7

        */

        ArithmeticExpression two = new Number(2);

        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);

        ArithmeticExpression addExpression = new Expression(one, seven, Operation.ADD);
        ArithmeticExpression parentExpression = new Expression(addExpression, two, Operation.MULTIPLY);

        System.out.println("FINAL EXPRESSION VALUE IS "+ parentExpression.evaluate());
    }
}
