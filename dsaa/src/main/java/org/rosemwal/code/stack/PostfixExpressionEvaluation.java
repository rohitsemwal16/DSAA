package org.rosemwal.code.stack;

import java.util.Stack;

public class PostfixExpressionEvaluation {

    public static void main(String[] args)  {

        String[] str = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Postfix exp eval is "+ evalRPN(str));
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++)  {

            if(tokens[i].matches("-?\\d+"))   {
                stack.push(Integer.parseInt(tokens[i]));
            }   else    {

                int a = stack.pop();
                int b = stack.pop();
                if (tokens[i] == "+")    {
                    stack.push(a+b);
                }   else if(tokens[i] == "-")    {
                    stack.push(b-a);
                }   else if(tokens[i] == "*")    {
                    stack.push(a*b);
                }   else if(tokens[i] == "/")    {
                    stack.push(b/a);
                }
            }
        }

        return stack.pop();
    }
}
