package org.rosemwal.code.stack;

import java.util.Stack;

public class ValidParenthesis302 {

    public static void main(String[] args)  {

        String str = "[{{()}}]";

        System.out.println("String is valid parenthesis "+ validate(str));
    }

    private static boolean validate(String str) {

        Stack<Character> stack = new Stack<Character>();

        char[] ch = str.toCharArray();

        for (int i=0;i<ch.length; i++)   {
            if (ch[i]=='{')  {
                stack.push('}');
            } else if(ch[i]=='(')  {
                stack.push(')');
            } else if(ch[i]=='[')  {
                stack.push(']');
            }  else    {
                if(stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if(pop!=ch[i])  {
                    return false;
                }
            }
        }

        if (!stack.isEmpty())    {
            return false;
        }
        return true;
    }
}
