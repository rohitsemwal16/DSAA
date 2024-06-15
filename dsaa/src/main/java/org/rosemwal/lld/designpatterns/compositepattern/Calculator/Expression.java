package org.rosemwal.lld.designpatterns.compositepattern.Calculator;

public class Expression implements ArithmeticExpression {

    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operation operation;

    Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operation operation)  {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    @Override
    public int evaluate() {

        int value = 0;
        switch (operation)  {

            case ADD:
                value = leftExpression.evaluate() + rightExpression.evaluate();
                break;
            case MINUS:
                value = leftExpression.evaluate() - rightExpression.evaluate();
                break;
            case MULTIPLY:
                value = leftExpression.evaluate() * rightExpression.evaluate();
                break;
            case DIVIDE:
                value = leftExpression.evaluate() / rightExpression.evaluate();
                break;
        }

        System.out.println("Expression Value "+ value);
        return value;
    }
}
