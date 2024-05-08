package org.rosemwal.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class ArithmeticExpressionEvaluation {

    public static void main(String[] args)  {

        String[] str = {"10","+","5","-","7","*","10","/","2","+","5"};

        String[] postfixExpression = convertInfixToPostFix(str);
        System.out.println("PostFixConversion is "+ Arrays.toString(postfixExpression));
        PostfixExpressionEvaluation postfixExpressionEvaluation = new PostfixExpressionEvaluation();
        System.out.println("Postfix exp eval is "+ postfixExpressionEvaluation.evalRPN(postfixExpression));
    }

    private static String[] convertInfixToPostFix(String[] str) {

        Stack<String> stack = new Stack<>();
        String[] postFixExp = new String[str.length];
        int count=0;

        for (int i=0; i<str.length; i++)    {

            if (str[i].matches("-?\\d+"))   {
                postFixExp[count++]=str[i];
            }   else {
                while(!stack.isEmpty() && findPriority(str[i]) <= findPriority(stack.peek()))  {
                    postFixExp[count++]=stack.pop();
                }
                stack.push(str[i]);
            }
        }

        while(!stack.isEmpty()) {
            postFixExp[count++]=stack.pop();

        }
        return postFixExp;
    }

    private static int findPriority(String str) {

        if (str =="+" || str == "-") {
            return 1;
        }
        else if (str == "*" || str == "/")  {
            return 2;
        }
        else return -1;
    }
}
