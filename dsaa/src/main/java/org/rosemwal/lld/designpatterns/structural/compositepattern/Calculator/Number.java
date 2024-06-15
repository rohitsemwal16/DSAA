package org.rosemwal.lld.designpatterns.structural.compositepattern.Calculator;

public class Number implements ArithmeticExpression {

    int data;

    Number(int data)    {
        this.data = data;
    }

    @Override
    public int evaluate() {
        System.out.println("Number is "+ data);
        return data;
    }
}
